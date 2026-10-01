from __future__ import annotations

import hashlib
import json
import os
import re
import shutil
from pathlib import Path

from pypdf import PdfReader


PROJECT = Path(r"C:\Users\Nadeer\Desktop\Interview-Prepration")
OUTPUT = PROJECT / "public" / "resources"
DATA = PROJECT / "src" / "data"

ROOTS = [
    ("PGCP-AC", Path(r"C:\Users\Nadeer\Desktop\PGCP-AC")),
    ("Prep Material", Path(r"C:\Users\Nadeer\Desktop\Prep Material")),
]

DOWNLOADS = [
    Path(r"C:\Users\Nadeer\Downloads\1773763190714.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\1773724378848.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\kA48nUAeSB8kRYT5cXHkF9.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\Interview Questions.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\Java prog (1)-2.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\Java core concepts .pdf"),
    Path(r"C:\Users\Nadeer\Downloads\C3IT Interview+Test.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\Vaipratech_interview_Qs.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\netspi.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\MyThinkbridgeInterviewExperience.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\Interview Experience Pattern Technologies.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\interview-preparation-master.pdf"),
    Path(r"C:\Users\Nadeer\Downloads\1776517483290.pdf"),
]

SKIP_PARTS = {"node_modules", ".git", "target", "dist", "build", ".next", "bin", "obj"}
USEFUL_SUFFIXES = {".pdf", ".doc", ".docx", ".ppt", ".pptx", ".xls", ".xlsx", ".txt", ".md", ".java", ".c", ".cpp", ".js", ".jsx", ".sql", ".zip"}


def walk_files(root: Path, suffixes: set[str]):
    for current, dirs, names in os.walk(root):
        dirs[:] = [d for d in dirs if d.lower() not in SKIP_PARTS]
        for name in names:
            path = Path(current) / name
            if path.suffix.lower() in suffixes:
                yield path


def slugify(value: str) -> str:
    value = value.lower().strip()
    value = re.sub(r"[^a-z0-9]+", "-", value).strip("-")
    return value[:90] or "resource"


def file_hash(path: Path) -> str:
    h = hashlib.sha256()
    with path.open("rb") as stream:
        for block in iter(lambda: stream.read(1024 * 1024), b""):
            h.update(block)
    return h.hexdigest()


def title_from_path(path: Path) -> str:
    raw = re.sub(r"[_-]+", " ", path.stem)
    raw = re.sub(r"\s+", " ", raw).strip()
    if re.fullmatch(r"[A-Za-z0-9]{8,}", raw):
        return "Interview preparation document"
    return raw


def classify(path: Path, text: str) -> tuple[str, str, list[str]]:
    haystack = f"{path} {text[:8000]}".lower()
    rules = [
        (("java", "jvm", "spring", "hibernate", "jdbc"), "Java", "Java"),
        (("react", "javascript", "jquery", "node js", "web module"), "Web Development", "JavaScript / React"),
        (("mysql", "sql", "rdbms", "database", "dbms"), "Database", "SQL / DBMS"),
        (("dynamic programming", "algorithm", "sorting", "data structure", "dsa", "linked list", "tree", "graph"), "DSA", "Algorithms"),
        (("aptitude", "quantitative", "reasoning"), "Aptitude", "Aptitude"),
        (("interview", "company", "hr round", "technical round"), "Interview", "Interview Preparation"),
        (("software engineering", "software testing", "sdm"), "Core CS", "Software Engineering"),
        (("c++", "cpp", "smart pointer"), "Programming", "C++"),
        (("storage class", " c ", "c language"), "Programming", "C"),
        (("python", "agentic", "prompt", "generative ai"), "AI", "AI / Python"),
    ]
    for needles, category, technology in rules:
        if any(needle in haystack for needle in needles):
            tags = [technology, category, "Study Material"]
            return category, technology, list(dict.fromkeys(tags))
    return "Resources", "General", ["Interview Preparation", "Study Material"]


def clean_text(text: str) -> str:
    text = re.sub(r"\s+", " ", text or "").strip()
    return text.encode("utf-8", "ignore").decode("utf-8")


def unique_destination(path: Path, digest: str) -> Path:
    return OUTPUT / f"{slugify(path.stem)}-{digest[:8]}.pdf"


def extract_pdf(path: Path) -> tuple[int, str, list[str]]:
    # Keep bulk import fast and resilient. The original PDF remains the source of
    # truth and is served intact; searchable classification comes from filenames
    # and folder context. Rich questions live in the curated data model.
    return 0, "", []


def scan_sources() -> list[dict]:
    catalog: list[dict] = []
    for collection, root in ROOTS:
        for path in walk_files(root, USEFUL_SUFFIXES):
            relative = path.relative_to(root)
            category = relative.parts[0] if len(relative.parts) > 1 else "General"
            catalog.append({
                "id": f"source-{len(catalog)+1}",
                "title": title_from_path(path),
                "collection": collection,
                "category": category,
                "type": path.suffix.lower().lstrip(".").upper(),
                "relativePath": str(relative).replace("\\", "/"),
            })
    return catalog


def main() -> None:
    OUTPUT.mkdir(parents=True, exist_ok=True)
    DATA.mkdir(parents=True, exist_ok=True)

    pdf_candidates: list[tuple[str, Path]] = [("Downloads", p) for p in DOWNLOADS if p.exists()]
    for collection, root in ROOTS:
        pdf_candidates.extend((collection, p) for p in walk_files(root, {".pdf"}))

    seen: dict[str, dict] = {}
    extracted_questions: list[dict] = []
    for collection, path in pdf_candidates:
        digest = file_hash(path)
        if digest in seen:
            seen[digest]["collections"] = sorted(set(seen[digest]["collections"] + [collection]))
            continue

        pages, raw_text, questions = extract_pdf(path)
        category, technology, tags = classify(path, raw_text)
        destination = unique_destination(path, digest)
        shutil.copy2(path, destination)
        title = title_from_path(path)
        snippet = clean_text(raw_text)[:520]
        description = snippet if snippet else f"Study material from {collection}; open the PDF to review the complete document."
        item = {
            "id": f"resource-{len(seen)+1}",
            "title": title,
            "category": category,
            "technology": technology,
            "description": description,
            "fileType": "PDF",
            "pages": pages,
            "sizeMb": round(path.stat().st_size / 1024 / 1024, 2),
            "url": f"/resources/{destination.name}",
            "tags": tags,
            "collections": [collection],
        }
        seen[digest] = item
        for question in questions:
            extracted_questions.append({
                "id": f"imported-{len(extracted_questions)+1}",
                "question": question,
                "shortAnswer": "Open the linked source document to review the supplied answer and context.",
                "detailedAnswer": f"This question was indexed from {title}. The original PDF is preserved in the resource library.",
                "category": technology,
                "topic": category,
                "difficulty": "Unrated",
                "tags": list(dict.fromkeys([technology, category, "Imported"])),
                "resourceId": item["id"],
                "followUps": [],
                "code": None,
                "imported": True,
            })

    catalog = scan_sources()
    (DATA / "generatedResources.json").write_text(json.dumps(list(seen.values()), indent=2, ensure_ascii=False), encoding="utf-8")
    (DATA / "generatedQuestions.json").write_text(json.dumps(extracted_questions[:220], indent=2, ensure_ascii=False), encoding="utf-8")
    (DATA / "generatedSourceCatalog.json").write_text(json.dumps(catalog, indent=2, ensure_ascii=False), encoding="utf-8")
    print(json.dumps({"resources": len(seen), "questions": min(220, len(extracted_questions)), "catalog": len(catalog)}, indent=2))


if __name__ == "__main__":
    main()
