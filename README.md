# AnsariPrep

**Learn • Practice • Prepare • Succeed**

AnsariPrep is a public interview-preparation platform for students, freshers, and software-development candidates. Explore technology topics, interview questions, Java DSA practice, aptitude, projects, company preparation, and a searchable library of study resources.

**Created by Nadeer Ansari**

## Preview

### Home

![AnsariPrep home](docs/screenshots/home.png)

### Study assistant

![AnsariPrep study assistant](docs/screenshots/assistant.png)

### Resource library

![AnsariPrep resources](docs/screenshots/resources.png)

## Features

- Search and browse interview-preparation topics, questions, DSA, projects, companies, aptitude, HR, and resources.
- Track bookmarks and study progress in your browser.
- Preview or download study documents and use the library assistant to find relevant materials.
- Switch between dark and light themes.

The library assistant searches the site's existing study material; it is not a connected generative AI model. Custom GPT links open in ChatGPT.

## Run locally

Requires Node.js 20+ and pnpm.

```bash
pnpm install
pnpm dev
```

Create a production build with `pnpm build` and preview it with `pnpm preview`.

## Project structure

```text
src/                 React app, data, components, and services
public/assets/        App and project images
public/resources/     Study documents
docs/screenshots/     README preview images
scripts/              Content-import utilities
```

## Deployment

The site is deployed to [GitHub Pages](https://nadeer-ansari.github.io/AnsariPrep/). Push changes to `main`; the GitHub Actions workflow builds the app and publishes `dist/`.

## Data and privacy

Bookmarks, recent topics, theme selection, and study progress are stored in the visitor's browser using `localStorage`. The app has no account system or shared cloud storage.
