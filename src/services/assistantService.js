import { questions, projects, dsaProblems } from '../data/content.js'

const stopWords = new Set('a an the is are was what why how does do can could please explain tell me about give some interview question questions ask of in on for to and it my i'.split(' '))
export function termsFor(text) {
  return [...new Set((text.toLowerCase().match(/[a-z0-9+#]+/g) || []).filter(w => !stopWords.has(w)))]
}
function score(query, text) {
  const words = new Set(termsFor(text))
  return query.reduce((sum, word) => sum + (words.has(word) ? 1 : 0), 0)
}

// Returns existing content, not generated model output. Keep provider calls behind
// this boundary if a server-side AI integration is configured in the future.
export function answerFromLibrary(prompt, resources = []) {
  if (/mock\s+interview/i.test(prompt)) return {
    text: 'Start a practice session, choose a technology, and answer one question at a time. You can reveal reference answers and mark your own performance.',
    sources: [{ title: 'Start mock interview', url: '/mock-interview' }],
  }
  const query = termsFor(prompt)
  if (!query.length) return { text: 'Ask about a specific topic such as Java collections, SQL joins, JWT, or Smart Society Connect.', sources: [] }
  const project = projects.find(p => p.title.toLowerCase().split(/\W+/).filter(w => w.length > 3).some(w => query.includes(w)))
  if (project) return {
    text: `${project.title}\n\n${project.summary}\n\nTech stack: ${project.stack.join(', ')}.${project.teamNote ? '\n\n' + project.teamNote : ''}${project.modules ? '\n\nModules: ' + project.modules.join(', ') + '.' : ''}\n\nPractice prompt: Explain the architecture and one design trade-off. Describe your own contribution separately from the team's work.`,
    sources: [{ title: project.title + ' — project details', url: '/projects' }],
  }
  const ranked = questions.map(q => ({ q, rank: score(query, `${q.question} ${q.category} ${q.topic} ${q.tags.join(' ')}`) })).filter(x => x.rank >= Math.max(1, Math.ceil(query.length * .6))).sort((a,b) => b.rank - a.rank)
  if (ranked.length) {
    const selected = ranked.slice(0, /questions/i.test(prompt) ? 3 : 1).map(x => x.q)
    const practice = /ask me/i.test(prompt)
    return {
      text: selected.map(q => `${q.question}${practice ? '\n\nTry answering aloud, then select Show answer.' : '\n\n' + q.shortAnswer + '\n\n' + q.detailedAnswer}`).join('\n\n———\n\n'),
      reveal: practice ? selected[0].shortAnswer + '\n\n' + selected[0].detailedAnswer : null,
      sources: selected.map(q => ({title: q.category + ': ' + q.question, url: `/questions?tech=${encodeURIComponent(q.category)}`})),
    }
  }
  const problem = dsaProblems.find(p => score(query, `${p.title} ${p.topic} ${p.tags.join(' ')}`) >= Math.max(1, Math.ceil(query.length * .6)))
  if (problem) return { text: `${problem.title}\n\n${problem.problem}\n\nApproach: ${problem.approach}\n\nTime: ${problem.timeComplexity} · Space: ${problem.spaceComplexity}`, sources: [{title: problem.title, url: '/dsa'}] }
  const matches = resources.map(r=>({r,rank:score(query, `${r.title} ${r.technology} ${r.tags.join(' ')}`)})).filter(x=>x.rank >= Math.max(1,Math.ceil(query.length*.6))).sort((a,b)=>b.rank-a.rank).slice(0,4)
  if (matches.length) return { text: 'I found related study materials, but no complete answer in the structured question bank. Open these sources to study the details. This assistant does not read the full contents of every PDF.', sources: matches.map(({r})=>({title:r.title,url:r.url})) }
  return { text: 'I could not find a reliable answer in the available library. Try a more specific technical topic, or open one of Nadeer’s GPTs for a broader discussion.', sources: [] }
}
