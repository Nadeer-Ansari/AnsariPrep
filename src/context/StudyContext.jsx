import { createContext, useContext, useEffect, useMemo, useState } from 'react'

const StudyContext = createContext(null)
const read = (key, fallback) => {
  try { return JSON.parse(localStorage.getItem(key)) ?? fallback } catch { return fallback }
}

export function StudyProvider({ children }) {
  const [bookmarks, setBookmarks] = useState(() => read('nip-bookmarks', []))
  const [completed, setCompleted] = useState(() => read('nip-completed', []))
  const [recent, setRecent] = useState(() => read('nip-recent', []))
  const [customContent, setCustomContent] = useState(() => read('nip-custom-content', []))
  const [theme, setTheme] = useState(() => localStorage.getItem('nip-theme') || 'dark')

  useEffect(() => { localStorage.setItem('nip-bookmarks', JSON.stringify(bookmarks)) }, [bookmarks])
  useEffect(() => { localStorage.setItem('nip-completed', JSON.stringify(completed)) }, [completed])
  useEffect(() => { localStorage.setItem('nip-recent', JSON.stringify(recent)) }, [recent])
  useEffect(() => { localStorage.setItem('nip-custom-content', JSON.stringify(customContent)) }, [customContent])
  useEffect(() => {
    localStorage.setItem('nip-theme', theme)
    document.documentElement.setAttribute('data-bs-theme', theme)
  }, [theme])

  const toggleBookmark = id => setBookmarks(items => items.includes(id) ? items.filter(x => x !== id) : [...items, id])
  const toggleCompleted = id => setCompleted(items => items.includes(id) ? items.filter(x => x !== id) : [...items, id])
  const openItem = item => setRecent(items => [item, ...items.filter(x => x.id !== item.id)].slice(0, 6))
  const addContent = item => setCustomContent(items => [{ ...item, id: `custom-${Date.now()}` }, ...items])
  const value = useMemo(() => ({ bookmarks, completed, recent, customContent, theme, setTheme, toggleBookmark, toggleCompleted, openItem, addContent }), [bookmarks, completed, recent, customContent, theme])
  return <StudyContext.Provider value={value}>{children}</StudyContext.Provider>
}

export const useStudy = () => useContext(StudyContext)
