<div align="center">

# AnsariPrep

### Learn • Practice • Prepare • Succeed

A public interview-preparation platform for students, freshers, and software-development candidates.

![React 19](https://img.shields.io/badge/React-19-149ECA?style=flat-square&logo=react&logoColor=white)
![Vite 7](https://img.shields.io/badge/Vite-7-646CFF?style=flat-square&logo=vite&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-ES_Modules-F7DF1E?style=flat-square&logo=javascript&logoColor=black)
![Bootstrap 5](https://img.shields.io/badge/Bootstrap-5-7952B3?style=flat-square&logo=bootstrap&logoColor=white)

[Live Demo](#-live-demo) · [Features](#-key-features) · [Screenshots](#-screenshots) · [Getting Started](#-getting-started) · [Deployment](#-deployment)

**Created by Nadeer Ansari**

</div>

---

## 📖 Overview

AnsariPrep brings technical revision, coding practice, interview questions, project discussions, and study documents into one searchable workspace. Learners can explore topics, save useful material, track their progress, and rehearse interview answers at their own pace.

The application runs as a React single-page app. Its study library ships with the website, while each visitor's bookmarks, drafts, and progress stay in their own browser.

## 🌐 Live Demo

- **Vercel:** [ansariprep.vercel.app](https://ansariprep.vercel.app/)
- **Netlify:** [ansariprep.netlify.app](https://ansariprep.netlify.app/)

## ✨ Key Features

- **Unified search** across technology topics, questions, coding problems, projects, companies, and resources.
- **Technical preparation** covering Java, Spring Boot, SQL, web development, and core computer-science subjects.
- **Java DSA practice** with problem descriptions, approaches, solutions, and complexity notes.
- **Question bank and mock interviews** with reference answers and self-assessment controls.
- **Project and company preparation** with project summaries, technology stacks, and interview experiences.
- **Resource library** with category filters, PDF previews, and downloadable study files.
- **Library assistant** that returns existing study answers and links to relevant sources, plus external custom GPT links.
- **Personal study tools** including bookmarks, progress tracking, HR answer drafts, local content entries, and light/dark themes.

## 🧭 Learning Modules

| Module | What you can do |
| --- | --- |
| Technologies & Core CS | Review language, framework, database, and foundational topics. |
| DSA & Coding | Study Java solutions and revisit common problem-solving patterns. |
| Interview Questions | Explore questions, reveal explanations, bookmark items, and track completion. |
| Mock Interview | Rehearse answers and mark questions as correct or needing revision. |
| Projects & Companies | Prepare project explanations and review company interview material. |
| Aptitude & HR | Browse aptitude topics and draft personal HR interview answers. |
| Resources | Search, filter, preview, and download study documents. |
| Study Assistant | Find answers already in the library or open a custom GPT in ChatGPT. |

## 🛠️ Technology Stack

| Area | Technology |
| --- | --- |
| User interface | React 19, JavaScript |
| Build tooling | Vite 7 |
| Styling | Bootstrap 5, Bootstrap Icons, custom CSS |
| Routing | React Router |
| Study content | JavaScript and JSON data files |
| Personal state | React Context and browser `localStorage` |
| Hosting | Static build with GitHub Pages, Vercel, and Netlify configuration |

## 📸 Screenshots

### Home & Learning Dashboard

![AnsariPrep home and learning dashboard](docs/screenshots/home.png)

<table>
  <tr>
    <td width="50%"><b>Study Assistant</b></td>
    <td width="50%"><b>Resource Library</b></td>
  </tr>
  <tr>
    <td><a href="docs/screenshots/assistant.png"><img src="docs/screenshots/assistant.png" alt="AnsariPrep study assistant and custom GPT links" width="100%"></a></td>
    <td><a href="docs/screenshots/resources.png"><img src="docs/screenshots/resources.png" alt="AnsariPrep searchable resource library" width="100%"></a></td>
  </tr>
</table>

Click a screenshot to view the full image. Screenshots show the dark theme; the app also includes a light theme.

## 📁 Repository Structure

```text
AnsariPrep/
├── .github/workflows/       GitHub Pages deployment
├── docs/screenshots/        Website preview images
├── public/
│   ├── assets/              Creator and project images
│   └── resources/           Study documents and imported examples
├── scripts/                Content-import utilities
├── src/
│   ├── components/         Reusable interface components
│   ├── context/            Personal study state
│   ├── data/               Curated content and generated catalogs
│   ├── services/           Library assistant logic
│   ├── App.jsx             Pages and routes
│   ├── main.jsx            Application entry point
│   └── styles.css          Theme and responsive styles
├── index.html
├── netlify.toml            Netlify build and routing settings
├── vercel.json             Vercel build and routing settings
├── vite.config.js
├── package.json
└── pnpm-lock.yaml
```

## 🚀 Getting Started

### Prerequisites

- Node.js **22.12 or newer**
- pnpm **9**
- Git

### Clone and install

```bash
git clone https://github.com/Nadeer-Ansari/AnsariPrep.git
cd AnsariPrep
pnpm install --frozen-lockfile
```

### Start development

```bash
pnpm dev
```

Open the local URL printed in your terminal, usually `http://localhost:5173`.

### Build and preview

```bash
pnpm build
pnpm preview
```

The production build is generated in `dist/`. No API key, database, or `.env` file is required for the current app.

## ☁️ Deployment

Live deployments are available on [Vercel](https://ansariprep.vercel.app/) and [Netlify](https://ansariprep.netlify.app/). Configuration for both hosts is included in the repository.

| Setting | Value |
| --- | --- |
| Repository | `Nadeer-Ansari/AnsariPrep` |
| Production branch | `main` |
| Framework | Vite |
| Root directory | Repository root |
| Build command | `pnpm build` |
| Output directory | `dist` |
| Node.js | 22 |

**Vercel:** Import the GitHub repository. `vercel.json` supplies the build settings and a fallback for client-side routes.

**Netlify:** Import the GitHub repository. `netlify.toml` supplies the build settings and a fallback for client-side routes.

**GitHub Pages:** The existing workflow publishes pushes to `main`. Vite uses the `/AnsariPrep/` base path for this workflow and `/` for other hosts.

Routing configuration follows the official [Vercel Vite guide](https://vercel.com/docs/frameworks/frontend/vite) and [Netlify SPA guide](https://docs.netlify.com/build/configure-builds/javascript-spas/).

## 📚 Adding Study Content

- Update curated topics, questions, coding problems, and project entries in `src/data/content.js`.
- Store downloadable documents in `public/resources/` and update their metadata in `src/data/generatedResources.json`.
- Use the utilities in `scripts/` when importing source materials; review their local source paths before running them.
- The **Add Content** page saves entries in the current browser. Publishing content for all visitors requires updating the repository and redeploying.

## 💬 Assistant & Data Storage

The built-in assistant matches questions against existing structured content. It is not currently connected to a generative AI model and does not reason over every uploaded document. The custom GPT buttons open the linked assistants in ChatGPT.

Bookmarks, progress, recent topics, theme selection, and HR drafts are stored in `localStorage`. They do not sync across devices, and clearing browser site data removes them. There is currently no login system or shared database.

## 🤝 Contributing

Suggestions, corrections, and improvements are welcome through [GitHub issues](https://github.com/Nadeer-Ansari/AnsariPrep/issues) or pull requests. For study material, include a clear topic, answer or explanation, and source attribution where applicable. Run `pnpm build` before submitting code changes.

## 👨‍💻 Creator

**Created by Nadeer Ansari**

[GitHub](https://github.com/Nadeer-Ansari) · [Portfolio](https://nadeer-ansari.netlify.app/)

---


<div align="center">

**AnsariPrep — Learn • Practice • Prepare • Succeed**

</div>
