<p align="center">
  <a href="https://github.com/runapi-ai/heygen-video">
    <h3 align="center">HeyGen Video API Skill for RunAPI</h3>
  </a>
</p>

<p align="center">
  Install this agent skill to use HeyGen Video text, reference-media, and first-frame video generation through RunAPI.
</p>

<div align="center">

[![skills.sh](https://www.skills.sh/b/runapi-ai/heygen-video)](https://www.skills.sh/runapi-ai/heygen-video/heygen-video)
[![ClawHub](https://img.shields.io/badge/ClawHub-runapi--heygen--video-111827)](https://clawhub.ai/runapi-ai/runapi-heygen-video)
[![License](https://img.shields.io/github/license/runapi-ai/heygen-video)](https://github.com/runapi-ai/heygen-video/blob/main/LICENSE)

</div>
<br/>

```bash
npx skills add runapi-ai/heygen-video -g
```

Or paste this prompt to your AI agent:

```text
Install the heygen-video skill for me:

1. Clone https://github.com/runapi-ai/heygen-video
2. Copy the skills/heygen-video/ directory into your
   user-level skills directory (e.g. ~/.claude/skills/
   for Claude Code, ~/.codex/skills/ for Codex, or the
   configured Gemini CLI skills directory).
3. Verify that SKILL.md is present.
4. Confirm the install path when done.
```

The canonical agent instructions are in `skills/heygen-video/SKILL.md` and cover Claude Code, Codex, Gemini CLI, Cursor, and compatible skill hosts.

## Quick Example

```shell
runapi heygen-video text-to-video --input-file request.json
```

Use the target-language SDK for application integration. Use the CLI for one-off jobs and manual testing.

## Links

- [Model reference](https://runapi.ai/models/heygen-video)
- [API reference](https://runapi.ai/docs/api/heygen-video/text-to-video)
- [SDK repository](https://github.com/runapi-ai/heygen-video-sdk)
- [Pricing and rate limits](https://runapi.ai/models/heygen-video)

## License

Licensed under the Apache License, Version 2.0.
