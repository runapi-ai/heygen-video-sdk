<p align="center">
  <a href="https://runapi.ai"><img src="https://runapi.ai/icon.svg" height="56" alt="RunAPI"></a>
</p>

<h3 align="center">
  <a href="https://github.com/runapi-ai/heygen-video-sdk">HeyGen Video API SDK for RunAPI</a>
</h3>

<p align="center">
  HeyGen Video API SDKs for JavaScript, Python, Ruby, Go, Java, and PHP on RunAPI.
</p>

<div align="center">

[![npm](https://img.shields.io/npm/v/@runapi.ai/heygen-video)](https://www.npmjs.com/package/@runapi.ai/heygen-video)
[![PyPI](https://img.shields.io/pypi/v/runapi-heygen-video)](https://pypi.org/project/runapi-heygen-video/)
[![RubyGems](https://img.shields.io/gem/v/runapi-heygen-video)](https://rubygems.org/gems/runapi-heygen-video)
[![Go Reference](https://pkg.go.dev/badge/github.com/runapi-ai/heygen-video-sdk/go.svg)](https://pkg.go.dev/github.com/runapi-ai/heygen-video-sdk/go)
[![Maven Central](https://img.shields.io/maven-central/v/ai.runapi/runapi-heygen-video)](https://central.sonatype.com/artifact/ai.runapi/runapi-heygen-video)
[![License](https://img.shields.io/github/license/runapi-ai/heygen-video-sdk)](https://github.com/runapi-ai/heygen-video-sdk/blob/main/LICENSE)

</div>
<br/>

Typed SDKs for HeyGen Video video generation through RunAPI. The public `heygen-video-sdk` repository groups the JavaScript, Python, Ruby, Go, and Java packages. PHP is released from the split `heygen-video-php` Composer repository.

HeyGen Video exposes two resources:

- `textToVideo` / `text_to_video` for prompt-only requests and requests with reference images, videos, or audio.
- `imageToVideo` / `image_to_video` for first-frame image requests.

## Packages

| Language | Package |
| --- | --- |
| JavaScript / TypeScript | `@runapi.ai/heygen-video` |
| Python | `runapi-heygen-video` |
| Ruby | `runapi-heygen-video` |
| Go | `github.com/runapi-ai/heygen-video-sdk/go` |
| Java | `ai.runapi:runapi-heygen-video` |

For PHP, use `runapi-ai/heygen-video` from the [split Composer repository](https://github.com/runapi-ai/heygen-video-php).

## JavaScript Quick Start

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

Reference media uses the same `textToVideo` resource:

```typescript
const task = await client.textToVideo.create({
  model: 'heygen-video-1',
  prompt: 'Keep the character and voice consistent in a new scene',
  reference_image_urls: ['https://cdn.runapi.ai/public/samples/image.jpg'],
  reference_audio_urls: ['https://cdn.runapi.ai/public/samples/voice.mp3'],
  aspect_ratio: 'adaptive',
});
```

Use `create` to submit and return a task id, `get` to read current status, or `run` to submit and poll to completion. In request handlers, prefer `create` with a callback or later polling.

Returned file URLs are temporary. Download generated files into durable storage within the retention window.

## Links

- [Model reference](https://runapi.ai/models/heygen-video)
- [API reference](https://runapi.ai/docs/api/heygen-video/text-to-video)
- [SDK documentation](https://runapi.ai/docs/resources/sdks)
- [Pricing and rate limits](https://runapi.ai/models/heygen-video)
- [Model catalog](https://runapi.ai/models)

## License

Licensed under the Apache License, Version 2.0.
