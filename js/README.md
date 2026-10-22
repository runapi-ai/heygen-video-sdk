# HeyGen Video API JavaScript SDK for RunAPI

Use `@runapi.ai/heygen-video` for typed HeyGen Video video tasks in JavaScript and TypeScript.

```bash
npm install @runapi.ai/heygen-video
```

```typescript
import { HeyGenVideoClient } from '@runapi.ai/heygen-video';

const client = new HeyGenVideoClient();
const result = await client.textToVideo.run({
  model: 'heygen-video-1',
  prompt: 'A cinematic tracking shot through a rain-soaked city',
  aspect_ratio: '16:9',
});
console.log(result.videos[0].url);
```

Use `textToVideo` for prompt-only or reference-media generation. Use `imageToVideo` with a first-frame image. Each resource provides `create`, `get`, and `run`.

- [Model reference](https://runapi.ai/models/heygen-video)
- [API reference](https://runapi.ai/docs/api/heygen-video/text-to-video)
- [Pricing and rate limits](https://runapi.ai/models/heygen-video)

Licensed under the Apache License, Version 2.0.
