import { useEffect, useRef, useState } from 'react'
import { Link } from 'react-router-dom'
import { answerFromLibrary } from '../services/assistantService'

const prompts = ['Ask me a Java interview question', 'Explain Spring Security', 'Give me SQL interview questions', 'Start a mock interview', 'Ask me about Smart Society Connect']

export default function LibraryAssistant({ resources }) {
  const [input, setInput] = useState('')
  const [messages, setMessages] = useState([])
  const end = useRef(null)
  useEffect(() => { if (messages.length) end.current?.scrollIntoView({ block: 'nearest' }) }, [messages])
  function send(value) {
    const prompt = value.trim().slice(0, 2000)
    if (!prompt) return
    const response = answerFromLibrary(prompt, resources)
    setMessages(old => [...old, {role: 'user', text: prompt}, {role: 'assistant', ...response}])
    setInput('')
  }
  return <div className="assistant-preview">
    <div className="chat-top"><span className="ai-orb"><i className="bi bi-chat-dots"/></span><div><strong>AnsariPrep library assistant</strong><small>Existing study answers and source links · No AI model connected</small></div></div>
    <div className="library-chat-log" role="log" aria-live="polite" aria-label="Study conversation">
      {!messages.length && <p className="chat-message">Ask about Java, SQL, Spring Security, coding problems, or the projects in this library. Select a suggestion to get started.</p>}
      {messages.map((message, index) => <article className={`library-message ${message.role}`} key={index}>
        <strong>{message.role === 'user' ? 'You' : 'Library assistant'}</strong>
        <p>{message.text}</p>
        {message.reveal && <details><summary>Show answer</summary><p>{message.reveal}</p></details>}
        {message.sources?.length > 0 && <div className="library-sources"><small>Sources / next steps</small>{message.sources.map((source,i) => source.url.startsWith('/resources/') ? <a key={i} href={source.url} target="_blank" rel="noreferrer">{source.title}</a> : <Link key={i} to={source.url}>{source.title}</Link>)}</div>}
      </article>)}
      <div ref={end}/>
    </div>
    <div className="prompt-grid">{prompts.map(prompt => <button type="button" key={prompt} onClick={()=>send(prompt)}>{prompt}</button>)}</div>
    <form className="library-composer" onSubmit={e=>{e.preventDefault();send(input)}}>
      <input aria-label="Ask the library assistant" value={input} onChange={e=>setInput(e.target.value)} maxLength={2000} placeholder="Ask about your study topic…"/>
      <button type="submit" disabled={!input.trim()} aria-label="Send question"><i className="bi bi-send"/></button>
    </form>
    {messages.length > 0 && <button className="btn btn-ghost btn-sm mt-3" onClick={()=>setMessages([])}>Clear conversation</button>}
  </div>
}
