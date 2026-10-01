import { useMemo, useState } from 'react'
import { Link, NavLink, Route, Routes, useLocation, useNavigate, useParams, useSearchParams } from 'react-router-dom'
import { aptitudeTopics, companies, dsaProblems, dsaTopics, gpts, hrQuestions, projects, questions, technologies, technologyGroups } from './data/content'
import generatedQuestions from './data/generatedQuestions.json'
import resources from './data/generatedResources.json'
import sourceCatalog from './data/generatedSourceCatalog.json'
import { useStudy } from './context/StudyContext'
import LibraryAssistant from './components/LibraryAssistant'

const navItems = [
  ['Technologies','/technologies'], ['DSA','/dsa'], ['Core CS','/core-cs'], ['Questions','/questions'],
  ['Projects','/projects'], ['Companies','/companies'], ['Aptitude','/aptitude'], ['HR','/hr'], ['Resources','/resources'],
]

const allQuestions = [...questions, ...generatedQuestions]
const searchItems = [
  ...technologies.map(x => ({ ...x, title:x.name, type:'Technology', url:`/technologies/${x.slug}`, text:`${x.name} ${x.group} ${x.description}` })),
  ...allQuestions.map(x => ({ ...x, title:x.question, type:'Question', url:`/questions?focus=${x.id}`, text:`${x.question} ${x.shortAnswer} ${x.category} ${x.topic} ${x.tags?.join(' ')}` })),
  ...dsaProblems.map(x => ({ ...x, type:'Coding', url:'/dsa', text:`${x.title} ${x.topic} ${x.approach} ${x.tags.join(' ')}` })),
  ...projects.map(x => ({ ...x, type:'Project', url:`/projects?focus=${x.id}`, text:`${x.title} ${x.summary} ${x.stack.join(' ')}` })),
  ...companies.map(x => ({ ...x, title:x.name, type:'Company', url:'/companies', text:`${x.name} ${x.source} ${x.tags.join(' ')}` })),
  ...resources.map(x => ({ ...x, type:'Resource', url:'/resources', text:`${x.title} ${x.category} ${x.technology} ${x.description} ${x.tags.join(' ')}` })),
  ...hrQuestions.map(x => ({ ...x, title:x.question, type:'HR', url:'/hr', text:`${x.question} ${x.guide}` })),
  ...aptitudeTopics.map(x => ({ ...x, type:'Aptitude', url:'/aptitude', text:`${x.title} ${x.category}` })),
]

function App() {
  return <div className="app-shell"><Navbar /><main><Routes>
    <Route path="/" element={<Home />} />
    <Route path="/technologies" element={<Technologies />} />
    <Route path="/technologies/:slug" element={<TechnologyDetail />} />
    <Route path="/dsa" element={<DSA />} />
    <Route path="/core-cs" element={<CoreCS />} />
    <Route path="/questions" element={<Questions />} />
    <Route path="/projects" element={<Projects />} />
    <Route path="/companies" element={<Companies />} />
    <Route path="/aptitude" element={<Aptitude />} />
    <Route path="/hr" element={<HR />} />
    <Route path="/resources" element={<Resources />} />
    <Route path="/bookmarks" element={<Bookmarks />} />
    <Route path="/revision" element={<Revision />} />
    <Route path="/mock-interview" element={<MockInterview />} />
    <Route path="/ask-gpt" element={<AskGPT />} />
    <Route path="/add-content" element={<AddContent />} />
    <Route path="/search" element={<SearchPage />} />
    <Route path="*" element={<NotFound />} />
  </Routes></main><Footer /></div>
}

function Navbar() {
  const { theme, setTheme, bookmarks } = useStudy()
  const [query, setQuery] = useState('')
  const navigate = useNavigate()
  const submit = e => { e.preventDefault(); if (query.trim()) navigate(`/search?q=${encodeURIComponent(query.trim())}`) }
  return <header className="topbar sticky-top">
    <nav className="navbar navbar-expand-xl" aria-label="Main navigation">
      <div className="container-fluid px-lg-4">
        <Link className="navbar-brand d-flex align-items-center gap-2" to="/"><span className="brand-mark">A</span><span><strong>AnsariPrep</strong><small> Interview Platform</small></span></Link>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNav" aria-controls="mainNav" aria-expanded="false" aria-label="Toggle navigation"><span className="navbar-toggler-icon" /></button>
        <div className="collapse navbar-collapse" id="mainNav">
          <ul className="navbar-nav me-auto mt-3 mt-xl-0">
            {navItems.map(([label,url]) => <li className="nav-item" key={url}><NavLink className="nav-link" to={url}>{label}</NavLink></li>)}
          </ul>
          <form className="nav-search d-flex" onSubmit={submit} role="search"><i className="bi bi-search" /><input value={query} onChange={e=>setQuery(e.target.value)} aria-label="Search all interview preparation content" placeholder="Search everything..." /></form>
          <div className="d-flex gap-2 ms-xl-3 mt-3 mt-xl-0">
            <Link className="icon-btn" to="/bookmarks" aria-label={`${bookmarks.length} bookmarks`}><i className="bi bi-bookmark-star" /><span className="mini-count">{bookmarks.length}</span></Link>
            <button className="icon-btn" onClick={()=>setTheme(theme === 'dark' ? 'light' : 'dark')} aria-label="Toggle color theme"><i className={`bi ${theme === 'dark' ? 'bi-sun' : 'bi-moon-stars'}`} /></button>
          </div>
        </div>
      </div>
    </nav>
  </header>
}

function Home() {
  const { recent, completed } = useStudy()
  const [query,setQuery] = useState('')
  const navigate = useNavigate()
  const stats = [
    ['Technologies', technologies.length, 'bi-layers', '/technologies'],
    ['Questions', allQuestions.length, 'bi-patch-question', '/questions'],
    ['Coding Problems', dsaProblems.length, 'bi-braces', '/dsa'],
    ['Companies', companies.length, 'bi-buildings', '/companies'],
    ['Projects', projects.length, 'bi-kanban', '/projects'],
    ['Resources', resources.length, 'bi-file-earmark-pdf', '/resources'],
  ]
  return <>
    <section className="hero-section container-fluid px-lg-4">
      <div className="hero-grid">
        <div className="hero-copy">
          <div className="eyebrow"><span /> Public interview preparation platform</div>
          <h1>Master your<br/><span>technical interviews.</span></h1>
          <p>A public preparation platform for students, freshers, and software-development candidates — built from technical notes, interview experiences, coding practice and real project work.</p>
          <form className="hero-search" onSubmit={e=>{e.preventDefault(); navigate(`/search?q=${encodeURIComponent(query)}`)}}>
            <i className="bi bi-search" /><input value={query} onChange={e=>setQuery(e.target.value)} placeholder="Search Java, Spring Boot, SQL, DSA, React..." aria-label="Search interview preparation" /><button>Search</button>
          </form>
          <div className="d-flex flex-wrap gap-3 mt-4"><Link className="btn btn-accent" to="/revision"><i className="bi bi-lightning-charge-fill me-2"/>Quick revision</Link><Link className="btn btn-ghost" to="/technologies">Explore technologies</Link></div>
        </div>
        <div className="profile-panel">
          <div className="profile-orbit"><img src="/assets/nadeer.png" alt="Nadeer Ansari" /></div>
          <div><small>CREATED BY</small><h2>Nadeer Ansari</h2><p>Java Backend Developer · Software Engineer</p></div>
          <div className="profile-signal"><span className="pulse-dot"/> C-DAC PGCP-AC · Open to work</div>
          <div className="profile-links"><a href="https://github.com/Nadeer-Ansari" target="_blank" rel="noreferrer"><i className="bi bi-github"/> GitHub</a><a href="https://www.linkedin.com/in/nadeer-ansari/" target="_blank" rel="noreferrer"><i className="bi bi-linkedin"/> LinkedIn</a></div>
        </div>
      </div>
      <div className="stat-grid">{stats.map(([label,value,icon,url]) => <Link className="stat-card" to={url} key={label}><i className={`bi ${icon}`} /><div><strong>{value}</strong><span>{label}</span></div></Link>)}</div>
    </section>
    <section className="container-fluid px-lg-4 section-block">
      <SectionHeading eyebrow="YOUR MOMENTUM" title="Continue learning" action={<Link to="/revision">Open revision mode</Link>} />
      <div className="row g-3">{(recent.length ? recent : [technologies[2], questions[10], technologies.find(x=>x.name==='Spring Boot'), dsaProblems[3]]).slice(0,4).map((item,i)=><div className="col-md-6 col-xl-3" key={item.id}><Link to={item.url || (item.slug?`/technologies/${item.slug}`:'/questions')} className="learning-card"><span>0{i+1}</span><div><h3>{item.title || item.name || item.question}</h3><p>{item.type || item.group || item.topic || 'Recommended next'}</p></div><i className="bi bi-play-fill"/></Link></div>)}</div>
    </section>
    <section className="container-fluid px-lg-4 section-block">
      <SectionHeading eyebrow="FOCUS AREAS" title="Prepare by track" />
      <div className="track-grid">{[
        ['Java backend','Java, Spring Boot, REST, Security and SQL','bi-cup-hot','/technologies/java'],
        ['DSA practice','Patterns, Java solutions and complexity notes','bi-diagram-3','/dsa'],
        ['Project defense','Architecture, trade-offs and follow-up questions','bi-boxes','/projects'],
        ['Interview rounds','Technical, company, aptitude and HR preparation','bi-person-video3','/companies'],
      ].map(([title,body,icon,url])=><Link to={url} className="track-card" key={title}><i className={`bi ${icon}`} /><h3>{title}</h3><p>{body}</p><span>Explore <i className="bi bi-chevron-right"/></span></Link>)}</div>
    </section>
  </>
}

function PageHero({ eyebrow, title, text, actions }) { return <section className="page-hero container-fluid px-lg-4"><div><div className="eyebrow"><span/>{eyebrow}</div><h1>{title}</h1><p>{text}</p>{actions && <div className="d-flex gap-2 flex-wrap mt-4">{actions}</div>}</div></section> }
function SectionHeading({eyebrow,title,action}) { return <div className="section-heading"><div><small>{eyebrow}</small><h2>{title}</h2></div>{action}</div> }
function EmptyState({icon='bi-inbox', title='Nothing here yet', text='Add content or change your filters.'}) { return <div className="empty-state"><i className={`bi ${icon}`} /><h3>{title}</h3><p>{text}</p></div> }

function Technologies() {
  const [filter,setFilter] = useState('')
  const visible = technologyGroups.map(group => ({...group, items:group.items.filter(x=>x.toLowerCase().includes(filter.toLowerCase()))})).filter(g=>g.items.length)
  return <><PageHero eyebrow="KNOWLEDGE MAP" title="Technologies" text="A scalable map of the languages, frameworks, databases and delivery tools in your preparation library." />
    <div className="container-fluid px-lg-4 pb-5"><FilterInput value={filter} onChange={setFilter} placeholder="Filter technologies..." />
      {visible.map(group=><section className="mb-5" key={group.name}><SectionHeading eyebrow={group.name.toUpperCase()} title={`${group.items.length} study areas`} /><div className="technology-grid">{group.items.map(name=>{const tech=technologies.find(x=>x.name===name); return <Link className="technology-card" to={`/technologies/${tech.slug}`} key={name}><div className="tech-icon"><i className={`bi ${group.icon}`}/></div><div><h3>{name}</h3><p>Concepts · questions · revision</p></div><i className="bi bi-chevron-right"/></Link>})}</div></section>)}</div></>
}

function TechnologyDetail() {
  const { slug } = useParams(); const tech = technologies.find(x=>x.slug===slug); const { openItem, completed } = useStudy()
  if (!tech) return <NotFound />
  const related = allQuestions.filter(q => `${q.category} ${q.topic} ${q.tags?.join(' ')}`.toLowerCase().includes(tech.name.toLowerCase().replace('.js',''))).slice(0,20)
  const topicNames = related.length ? [...new Set(related.map(q=>q.topic))] : ['Overview','Fundamentals','Important concepts','Examples','Interview questions','Revision notes']
  const done = related.filter(x=>completed.includes(x.id)).length
  return <><PageHero eyebrow={tech.group} title={tech.name} text={tech.description} actions={[<Link key="rev" className="btn btn-accent" to={`/revision?tech=${encodeURIComponent(tech.name)}`}>Start revision</Link>,<Link key="q" className="btn btn-ghost" to={`/questions?tech=${encodeURIComponent(tech.name)}`}>View questions</Link>]} />
    <div className="container-fluid px-lg-4 pb-5"><div className="progress-strip"><div><strong>{related.length}</strong><span>indexed questions</span></div><div><strong>{topicNames.length}</strong><span>topic groups</span></div><div><strong>{related.length ? Math.round(done/related.length*100) : 0}%</strong><span>completed</span></div></div>
      <SectionHeading eyebrow="LEARNING PATH" title="Topics"/><div className="topic-grid">{topicNames.map((topic,i)=><article className="topic-card" key={topic} onClick={()=>openItem({id:`${tech.id}-${topic}`,title:`${tech.name}: ${topic}`,type:'Topic',url:`/technologies/${tech.slug}`})}><span>{String(i+1).padStart(2,'0')}</span><h3>{topic}</h3><p>Open related notes and interview prompts.</p></article>)}</div>
      <div className="mt-5"><SectionHeading eyebrow="INTERVIEW SET" title={`Questions for ${tech.name}`}/>{related.length ? related.map(q=><QuestionCard key={q.id} item={q}/>) : <EmptyState icon="bi-journal-plus" title="Ready for your notes" text={`Add ${tech.name} questions using Add Content; the page structure is already prepared.`}/>}</div></div></>
}

function DSA() {
  const [topic,setTopic]=useState('All'); const [difficulty,setDifficulty]=useState('All')
  const visible=dsaProblems.filter(p=>(topic==='All'||p.topic===topic)&&(difficulty==='All'||p.difficulty===difficulty))
  return <><PageHero eyebrow="JAVA-FIRST PRACTICE" title="Data Structures & Algorithms" text="Recognize the pattern, explain the trade-off, then code it cleanly in Java." actions={[<Link key="mock" className="btn btn-accent" to="/mock-interview">Start mock session</Link>]} />
    <div className="container-fluid px-lg-4 pb-5"><div className="topic-scroller">{['All',...dsaTopics].map(x=><button className={topic===x?'active':''} onClick={()=>setTopic(x)} key={x}>{x}</button>)}</div><div className="d-flex gap-2 mb-4"><select className="form-select compact-select" value={difficulty} onChange={e=>setDifficulty(e.target.value)}><option>All</option><option>Easy</option><option>Medium</option><option>Hard</option></select><span className="result-count">{visible.length} problems</span></div><div className="row g-4">{visible.map(p=><div className="col-lg-6" key={p.id}><ProblemCard item={p}/></div>)}</div>{!visible.length&&<EmptyState/>}</div></>
}

function ProblemCard({item}) { const {bookmarks,completed,toggleBookmark,toggleCompleted}=useStudy(); return <article className="content-card h-100"><div className="card-meta"><Difficulty value={item.difficulty}/><span>{item.topic}</span></div><h3>{item.title}</h3><p>{item.problem}</p><div className="approach-box"><small>APPROACH</small><p>{item.approach}</p></div><div className="complexity"><span>Time <strong>{item.timeComplexity}</strong></span><span>Space <strong>{item.spaceComplexity}</strong></span></div>{item.javaCode&&<CodeBlock code={item.javaCode}/>}<div className="card-actions"><button onClick={()=>toggleBookmark(item.id)}><i className={`bi ${bookmarks.includes(item.id)?'bi-bookmark-fill':'bi-bookmark'}`}/> Save</button><button onClick={()=>toggleCompleted(item.id)} className={completed.includes(item.id)?'is-done':''}><i className="bi bi-check2-circle"/> {completed.includes(item.id)?'Completed':'Mark complete'}</button></div></article> }
function CodeBlock({code}) { const [open,setOpen]=useState(false); const copy=()=>navigator.clipboard.writeText(code); return <div className="code-block"><div><span><i className="bi bi-filetype-java"/> Java</span><div><button onClick={copy}><i className="bi bi-copy"/> Copy</button><button onClick={()=>setOpen(!open)}>{open?'Collapse':'Expand'}</button></div></div>{open&&<pre><code>{code}</code></pre>}</div> }

function Questions() {
  const [params]=useSearchParams(); const techParam=params.get('tech')||''; const [query,setQuery]=useState(techParam); const [difficulty,setDifficulty]=useState('All'); const [showImported,setShowImported]=useState(false)
  const list=allQuestions.filter(q=>{const hay=`${q.question} ${q.shortAnswer} ${q.category} ${q.topic} ${q.tags?.join(' ')}`.toLowerCase(); return hay.includes(query.toLowerCase())&&(difficulty==='All'||q.difficulty===difficulty)&&(showImported||!q.imported)}).slice(0,100)
  return <><PageHero eyebrow="ANSWER WITH CLARITY" title="Interview Questions" text="Short speaking answers first, deeper explanation second, likely follow-ups next."/><div className="container-fluid px-lg-4 pb-5"><div className="filter-bar"><FilterInput value={query} onChange={setQuery} placeholder="Search question, answer, topic or tag..."/><select className="form-select" value={difficulty} onChange={e=>setDifficulty(e.target.value)}><option>All</option><option>Easy</option><option>Medium</option><option>Hard</option><option>Unrated</option></select><label className="form-check form-switch"><input className="form-check-input" type="checkbox" checked={showImported} onChange={e=>setShowImported(e.target.checked)}/><span>Include PDF-indexed prompts</span></label></div><p className="result-count mb-3">Showing {list.length} of {allQuestions.length} questions</p>{list.map(q=><QuestionCard key={q.id} item={q}/>)}</div></>
}
function QuestionCard({item,compact=false}) { const {bookmarks,completed,toggleBookmark,toggleCompleted,openItem}=useStudy(); const [open,setOpen]=useState(false); const copy=()=>navigator.clipboard.writeText(item.shortAnswer); return <article className={`question-card ${open?'open':''}`} onClick={()=>openItem({id:item.id,title:item.question,type:'Question',url:'/questions'})}><div className="question-main"><div className="card-meta"><Difficulty value={item.difficulty}/><span>{item.category}</span><span>{item.topic}</span></div><h3>{item.question}</h3><div className="short-answer"><small>SHORT INTERVIEW ANSWER</small><p>{item.shortAnswer}</p></div>{open&&!compact&&<div className="question-detail"><h4>Detailed explanation</h4><p>{item.detailedAnswer}</p>{item.followUps?.length>0&&<><h4>Likely follow-ups</h4><ul>{item.followUps.map(x=><li key={x}>{x}</li>)}</ul></>}</div>}<div className="tag-row">{item.tags?.slice(0,4).map(x=><span key={x}>{x}</span>)}</div></div><div className="question-actions"><button title="Copy answer" onClick={e=>{e.stopPropagation();copy()}}><i className="bi bi-copy"/></button><button title="Bookmark" onClick={e=>{e.stopPropagation();toggleBookmark(item.id)}}><i className={`bi ${bookmarks.includes(item.id)?'bi-bookmark-fill':'bi-bookmark'}`}/></button><button title="Mark completed" className={completed.includes(item.id)?'is-done':''} onClick={e=>{e.stopPropagation();toggleCompleted(item.id)}}><i className="bi bi-check2-circle"/></button><button title="Show details" onClick={e=>{e.stopPropagation();setOpen(!open)}}><i className={`bi bi-chevron-${open?'up':'down'}`}/></button></div></article> }
function Difficulty({value}) { return <span className={`difficulty ${value?.toLowerCase()}`}>{value}</span> }

function CoreCS(){ const subjects=['DBMS','Operating Systems','Computer Networks','OOP','Software Engineering']; return <><PageHero eyebrow="FOUNDATIONAL SYSTEMS" title="Core Computer Science" text="Definitions, mental models, FAQs and fast revision for the subjects interviewers return to."/><div className="container-fluid px-lg-4 pb-5"><div className="track-grid">{subjects.map((s,i)=><Link to={`/technologies/${technologies.find(t=>t.name===s)?.slug||'software-engineering'}`} className="track-card" key={s}><i className={`bi ${['bi-database','bi-cpu','bi-router','bi-bounding-box','bi-bezier2'][i]}`}/><h3>{s}</h3><p>Concepts · definitions · questions · quick revision</p><span>Study subject <i className="bi bi-chevron-right"/></span></Link>)}</div></div></> }

function Projects(){return <><PageHero eyebrow="DEFEND YOUR WORK" title="Project Interview Preparation" text="Explain architecture, ownership, trade-offs, security, challenges and results without overstating individual contribution."/><div className="container-fluid px-lg-4 pb-5"><div className="project-grid">{projects.map(p=><article className="project-card" key={p.id}><img src={p.image} alt=""/><div className="project-card-body"><small>{p.period}</small><h2>{p.title}</h2><p>{p.summary}</p>{p.teamNote&&<div className="truth-note"><i className="bi bi-people"/> {p.teamNote}</div>}<div className="tag-row">{p.stack.map(x=><span key={x}>{x}</span>)}</div>{p.modules&&<div className="module-list"><strong>Key modules</strong><p>{p.modules.join(' · ')}</p></div>}<div className="d-flex gap-2 mt-4"><a className="btn btn-ghost btn-sm" href={p.code} target="_blank" rel="noreferrer"><i className="bi bi-github me-2"/>Code</a>{p.demo&&<a className="btn btn-accent btn-sm" href={p.demo} target="_blank" rel="noreferrer">Live demo</a>}</div></div></article>)}</div></div></>}

function Companies(){const [query,setQuery]=useState(''); const list=companies.filter(x=>`${x.name} ${x.tags.join(' ')}`.toLowerCase().includes(query.toLowerCase())); return <><PageHero eyebrow="DOCUMENT-BACKED" title="Company Preparation" text="Interview experiences and supplied question sets, with no invented company patterns."/><div className="container-fluid px-lg-4 pb-5"><FilterInput value={query} onChange={setQuery} placeholder="Search company or tag..."/><div className="row g-4 mt-1">{list.map(c=><div className="col-md-6 col-xl-4" key={c.id}><article className="content-card h-100"><div className="company-icon"><i className="bi bi-buildings"/></div><h3>{c.name}</h3><p>{c.note}</p><div className="tag-row">{c.tags.map(x=><span key={x}>{x}</span>)}</div><small className="source-note"><i className="bi bi-file-earmark-text"/> {c.source}</small><Link className="text-link mt-3" to="/resources">Find source document</Link></article></div>)}</div></div></>}

function Aptitude(){const groups=[...new Set(aptitudeTopics.map(x=>x.category))];return <><PageHero eyebrow="SPEED + ACCURACY" title="Aptitude Preparation" text="Build concept clarity first, then formulas, worked examples and timed practice." actions={[<a key="gpt" className="btn btn-accent" href={gpts[0].url} target="_blank" rel="noreferrer">Open Aptitude GPT</a>]}/><div className="container-fluid px-lg-4 pb-5">{groups.map(g=><section className="mb-5" key={g}><SectionHeading eyebrow={g.toUpperCase()} title="Practice topics"/><div className="technology-grid">{aptitudeTopics.filter(x=>x.category===g).map(x=><article className="technology-card" key={x.id}><div className="tech-icon"><i className="bi bi-calculator"/></div><div><h3>{x.title}</h3><p>{x.status}</p></div></article>)}</div></section>)}</div></>}

function HR(){return <><PageHero eyebrow="SOUND LIKE YOURSELF" title="HR Interview" text="Editable answer prompts grounded in your real education, projects and experience."/><div className="container-fluid px-lg-4 pb-5"><div className="row g-3">{hrQuestions.map((q,i)=><div className="col-lg-6" key={q.id}><article className="hr-card"><span>{String(i+1).padStart(2,'0')}</span><div><h3>{q.question}</h3><p>{q.guide}</p><textarea aria-label={`Draft answer for ${q.question}`} placeholder="Draft your factual answer here..." defaultValue={localStorage.getItem(`nip-${q.id}`)||''} onBlur={e=>localStorage.setItem(`nip-${q.id}`,e.target.value)}/></div></article></div>)}</div></div></>}

function Resources(){const [query,setQuery]=useState(''); const [category,setCategory]=useState('All'); const [preview,setPreview]=useState(null); const categories=['All',...new Set(resources.map(x=>x.category))]; const list=resources.filter(r=>(category==='All'||r.category===category)&&`${r.title} ${r.technology} ${r.tags.join(' ')}`.toLowerCase().includes(query.toLowerCase())); return <><PageHero eyebrow="STUDY RESOURCE LIBRARY" title="Resource Library" text="Supplied PDFs and course documents are organized by technology and kept in their original form for focused study."/><div className="container-fluid px-lg-4 pb-5"><div className="filter-bar"><FilterInput value={query} onChange={setQuery} placeholder="Search PDFs, notes or technologies..."/><select className="form-select" value={category} onChange={e=>setCategory(e.target.value)}>{categories.map(x=><option key={x}>{x}</option>)}</select></div><p className="result-count mb-3">{list.length} resources · {sourceCatalog.length} additional source files indexed from PGCP-AC and Prep Material</p><div className="row g-4">{list.map(r=><div className="col-md-6 col-xl-4" key={r.id}><article className="resource-card"><div className="pdf-icon"><i className="bi bi-file-earmark-pdf-fill"/></div><div className="card-meta"><span>{r.category}</span><span>{r.pages ? `${r.pages} pages` : r.fileType}</span><span>{r.sizeMb} MB</span></div><h3>{r.title}</h3><p>{r.description}</p><div className="tag-row">{[...new Set(r.tags)].map(x=><span key={x}>{x}</span>)}</div><div className="card-actions">{['PDF','PNG','JPG','JPEG','TXT'].includes(r.fileType)&&<button onClick={()=>setPreview(r)}><i className="bi bi-eye"/> Preview</button>}<a href={r.url} download><i className="bi bi-download"/> Download</a></div></article></div>)}</div></div>{preview&&<div className="pdf-modal" role="dialog" aria-modal="true" aria-label={`Preview ${preview.title}`}><div className="pdf-modal-head"><div><small>DOCUMENT PREVIEW</small><strong>{preview.title}</strong></div><button onClick={()=>setPreview(null)} aria-label="Close preview"><i className="bi bi-x-lg"/></button></div><iframe src={preview.url} title={preview.title}/></div>}</>}

function Bookmarks(){const {bookmarks}=useStudy(); const items=searchItems.filter(x=>bookmarks.includes(x.id)); return <><PageHero eyebrow="YOUR SAVED LIST" title="Bookmarks" text="Keep important questions, coding problems and resources close for the next revision session."/><div className="container-fluid px-lg-4 pb-5">{items.length?items.map(x=>x.type==='Question'?<QuestionCard key={x.id} item={x}/>:<Link className="search-result" to={x.url} key={x.id}><span>{x.type}</span><div><h3>{x.title}</h3><p>{x.text?.slice(0,180)}</p></div></Link>):<EmptyState icon="bi-bookmark" title="No bookmarks yet" text="Use the bookmark button on questions and coding problems to build this list."/>}</div></>}

function Revision(){const [params]=useSearchParams(); const initial=params.get('tech')||'All'; const [tech,setTech]=useState(initial); const filtered=questions.filter(q=>tech==='All'||q.category===tech||q.tags.includes(tech)); const [index,setIndex]=useState(0); const item=filtered[index%Math.max(filtered.length,1)]; return <><PageHero eyebrow="LAST-MINUTE MODE" title="Quick Revision" text="One concise answer at a time. Speak it aloud, remember the key point, move on."/><div className="container-fluid px-lg-4 pb-5"><div className="revision-toolbar"><select className="form-select" value={tech} onChange={e=>{setTech(e.target.value);setIndex(0)}}><option>All</option>{[...new Set(questions.map(q=>q.category))].map(x=><option key={x}>{x}</option>)}</select><span>{filtered.length ? index+1 : 0} / {filtered.length}</span></div>{item?<div className="revision-card"><div className="card-meta"><Difficulty value={item.difficulty}/><span>{item.category}</span></div><h2>{item.question}</h2><div className="revision-answer"><small>YOUR INTERVIEW ANSWER</small><p>{item.shortAnswer}</p></div><div className="revision-controls"><button onClick={()=>setIndex(i=>Math.max(0,i-1))} disabled={index===0}><i className="bi bi-chevron-left"/> Previous</button><button className="primary" onClick={()=>setIndex(i=>(i+1)%filtered.length)}>Next question <i className="bi bi-chevron-right"/></button></div></div>:<EmptyState/>}</div></>}

function MockInterview(){const [started,setStarted]=useState(false); const [tech,setTech]=useState('Java'); const [count,setCount]=useState(5); const [index,setIndex]=useState(0); const [answers,setAnswers]=useState({}); const [show,setShow]=useState(false); const pool=questions.filter(q=>tech==='All'||q.category===tech||q.tags.includes(tech)).slice(0,count); const item=pool[index]; if(!started)return <><PageHero eyebrow="PRACTICE UNDER PRESSURE" title="Mock Interview" text="Choose a focus and answer one question at a time. Self-mark honestly; no fake AI scoring."/><div className="container-fluid px-lg-4 pb-5"><div className="setup-card"><label>Technology<select className="form-select" value={tech} onChange={e=>setTech(e.target.value)}><option>All</option>{[...new Set(questions.map(q=>q.category))].map(x=><option key={x}>{x}</option>)}</select></label><label>Number of questions<select className="form-select" value={count} onChange={e=>setCount(Number(e.target.value))}><option>5</option><option>10</option></select></label><button className="btn btn-accent" onClick={()=>setStarted(true)}>Begin session</button></div></div></>; if(index>=pool.length){const correct=Object.values(answers).filter(x=>x==='correct').length;return <><PageHero eyebrow="SESSION COMPLETE" title={`${correct} of ${pool.length} felt correct`} text="Review anything marked Needs revision, then repeat the session after a break."/><div className="container-fluid px-lg-4 pb-5"><button className="btn btn-accent" onClick={()=>{setIndex(0);setAnswers({});setStarted(false)}}>Start another session</button></div></>}; return <><PageHero eyebrow={`QUESTION ${index+1} OF ${pool.length}`} title="Mock Interview" text={`${tech} · self-evaluated practice`}/><div className="container-fluid px-lg-4 pb-5"><div className="mock-card"><Difficulty value={item.difficulty}/><h2>{item.question}</h2><textarea className="form-control" rows="5" placeholder="Write brief speaking notes (optional)..."/>{show&&<div className="revision-answer"><small>REFERENCE ANSWER</small><p>{item.shortAnswer}</p></div>}<div className="mock-controls"><button onClick={()=>setShow(!show)}>{show?'Hide':'Show'} answer</button><button onClick={()=>setAnswers({...answers,[item.id]:'revision'})} className={answers[item.id]==='revision'?'active':''}>Needs revision</button><button onClick={()=>setAnswers({...answers,[item.id]:'correct'})} className={answers[item.id]==='correct'?'active':''}>Mark correct</button><button className="primary" onClick={()=>{setIndex(index+1);setShow(false)}}>Next</button></div></div></div></>}

function AskGPT(){return <><PageHero eyebrow="STUDY ASSISTANTS" title="Ask your interview question" text="Get existing answers and source links from the AnsariPrep library, or continue a broader conversation in one of Nadeer’s custom GPTs."/><div className="container-fluid px-lg-4 pb-5"><div className="gpt-layout"><LibraryAssistant resources={resources}/><div className="gpt-list">{gpts.map(g=><article key={g.title}><i className="bi bi-stars"/><h3>{g.title}</h3><p>{g.description}</p><a className="btn btn-accent" href={g.url} target="_blank" rel="noreferrer">Open this GPT <i className="bi bi-box-arrow-up-right ms-2"/></a></article>)}</div></div></div></>}

function AddContent(){const {addContent,customContent}=useStudy(); const [saved,setSaved]=useState(false); const submit=e=>{e.preventDefault(); const data=new FormData(e.currentTarget); addContent(Object.fromEntries(data)); e.currentTarget.reset(); setSaved(true)};return <><PageHero eyebrow="LOCAL CONTENT STUDIO" title="Add Content" text="Create local study entries now. This browser storage layer is intentionally replaceable by a Spring Boot API later."/><div className="container-fluid px-lg-4 pb-5"><div className="row g-4"><div className="col-lg-7"><form className="content-form" onSubmit={submit}><label>Content type<select className="form-select" name="type"><option>Interview Question</option><option>Technology</option><option>Topic</option><option>Coding Problem</option><option>Company</option><option>Project</option><option>Resource</option></select></label><label>Title<input className="form-control" name="title" required placeholder="What is...?"/></label><label>Category<input className="form-control" name="category" placeholder="Java, SQL, DSA..."/></label><label>Content<textarea className="form-control" name="content" rows="8" required placeholder="Add your notes, answer or description..."/></label><label>Tags<input className="form-control" name="tags" placeholder="java, oop, easy"/></label><button className="btn btn-accent" type="submit">Save locally</button>{saved&&<span className="save-message"><i className="bi bi-check2"/> Saved in this browser</span>}</form></div><div className="col-lg-5"><article className="architecture-card"><i className="bi bi-diagram-3"/><h3>Backend-ready boundary</h3><p>The UI reads through data and service boundaries. Local storage is suitable for personal drafts, not a production database.</p><code>GET /api/questions<br/>POST /api/questions<br/>GET /api/resources<br/>GET /api/projects</code><hr/><strong>{customContent.length} local entries</strong></article></div></div></div></>}

function SearchPage(){const [params,setParams]=useSearchParams(); const q=params.get('q')||''; const type=params.get('type')||'All'; const results=useMemo(()=>{if(!q.trim())return []; const terms=q.toLowerCase().split(/\s+/);return searchItems.filter(x=>terms.every(t=>x.text.toLowerCase().includes(t))).filter(x=>type==='All'||x.type===type).slice(0,100)},[q,type]); const grouped=Object.groupBy?Object.groupBy(results,x=>x.type):results.reduce((a,x)=>((a[x.type]??=[]).push(x),a),{}); return <><PageHero eyebrow="GLOBAL SEARCH" title={q?`Results for “${q}”`:'Search the knowledge hub'} text="Search technologies, answers, coding problems, companies, projects, PDFs, HR prompts, aptitude and tags."/><div className="container-fluid px-lg-4 pb-5"><form className="search-page-form" onSubmit={e=>{e.preventDefault();setParams({q:e.currentTarget.q.value,type})}}><i className="bi bi-search"/><input name="q" defaultValue={q} placeholder="Search all content..."/><button>Search</button></form><div className="topic-scroller">{['All',...new Set(searchItems.map(x=>x.type))].map(x=><button className={type===x?'active':''} onClick={()=>setParams({q,type:x})} key={x} type="button">{x}</button>)}</div>{Object.entries(grouped).map(([group,items])=><section className="search-group" key={group}><SectionHeading eyebrow={group.toUpperCase()} title={`${items.length} results`}/>{items.map(x=><Link className="search-result" to={x.url} key={`${x.type}-${x.id}`}><span>{x.type}</span><div><h3>{x.title}</h3><p>{x.text.slice(0,190)}</p></div><i className="bi bi-chevron-right"/></Link>)}</section>)}{q&&!results.length&&<EmptyState icon="bi-search" title="No matching result" text="Try a technology name, topic, project or shorter phrase."/>}</div></>}

function FilterInput({value,onChange,placeholder}){return <label className="filter-input"><i className="bi bi-search"/><input value={value} onChange={e=>onChange(e.target.value)} placeholder={placeholder}/></label>}
function NotFound(){return <><PageHero eyebrow="404" title="That study path does not exist" text="Return to the dashboard and continue from a known topic."/><div className="container-fluid px-lg-4 pb-5"><Link className="btn btn-accent" to="/">Back home</Link></div></>}
function Footer(){return <footer><div className="container-fluid px-lg-4"><div><span className="brand-mark">A</span><div><strong>AnsariPrep</strong><p>Learn • Practice • Prepare • Succeed</p></div></div><div className="footer-links"><Link to="/add-content">Add content</Link><Link to="/ask-gpt">My GPT</Link><a href="https://nadeer-ansari.netlify.app/" target="_blank" rel="noreferrer">Creator portfolio</a></div><p className="copyright">AnsariPrep — Created by Nadeer Ansari</p></div></footer>}

export default App
