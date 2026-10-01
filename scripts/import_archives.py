"""Import supplied study files without executing archive contents."""
import hashlib
import json
import re
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
SOURCES = [
    ('Aptitude.zip', 'Aptitude', 'Aptitude'),
    ('Web based Java-20260602T180614Z-3-001.zip', 'Java', 'Web based Java'),
    ('OOP using Java-20260602T195238Z-3-001.zip', 'Java', 'OOP using Java'),
]
allowed = {'.pdf', '.java', '.txt', '.md', '.docx', '.pptx', '.png', '.jpg', '.jpeg', '.sql'}
excluded = {'.git', '.metadata', 'node_modules', 'target', 'bin', '.settings', '__macosx'}
destination = ROOT / 'public/resources/imported'
destination.mkdir(parents=True, exist_ok=True)
data_file = ROOT / 'src/data/generatedResources.json'
resources = json.loads(data_file.read_text(encoding='utf-8'))
known = {item['id'] for item in resources}
report = {}
for filename, category, collection in SOURCES:
    count = 0
    with zipfile.ZipFile(Path('C:/Users/Nadeer/Downloads') / filename) as archive:
        for member in archive.infolist():
            parts = member.filename.replace('\\', '/').split('/')
            suffix = Path(parts[-1]).suffix.lower()
            if member.is_dir() or suffix not in allowed or any(p.lower() in excluded or p == '..' for p in parts):
                continue
            if member.file_size > 40 * 1024 * 1024:
                continue
            content = archive.read(member)
            digest = hashlib.sha256(content).hexdigest()[:16]
            identifier = 'archive-' + digest
            if identifier in known:
                continue
            name = re.sub(r'[^a-zA-Z0-9_-]', '-', Path(parts[-1]).stem)[:70] + '-' + digest + suffix
            (destination / name).write_bytes(content)
            title = Path(parts[-1]).stem.replace('_', ' ')
            resources.append(dict(id=identifier, title=title, category=category, technology=collection,
                description=f'{collection} / ' + ' / '.join(parts[1:-1]) + '. Supplied study material.',
                fileType=suffix[1:].upper(), pages=None, sizeMb=round(len(content)/1048576, 2),
                url='/resources/imported/' + name, tags=[collection, category, suffix[1:].upper()], collections=[collection]))
            known.add(identifier)
            count += 1
    report[collection] = count
data_file.write_text(json.dumps(resources, ensure_ascii=False, indent=2), encoding='utf-8')
print(json.dumps(dict(added=report, totalResources=len(resources))))
