# HeyGen Video API Ruby SDK for RunAPI

Use `runapi-heygen-video` for HeyGen Video video tasks in Ruby.

```bash
gem install runapi-heygen-video
```

```ruby
require "runapi/heygen_video"

client = RunApi::HeyGenVideo::Client.new
result = client.text_to_video.run(
  model: "heygen-video-1",
  prompt: "A cinematic tracking shot through a rain-soaked city",
  aspect_ratio: "16:9"
)
puts result.videos.first.url
```

Use `text_to_video` for prompt-only or reference-media generation. Use `image_to_video` with a first-frame image. Each resource provides `create`, `get`, and `run`.

- [Model reference](https://runapi.ai/models/heygen-video)
- [API reference](https://runapi.ai/docs/api/heygen-video/text-to-video)
- [Pricing and rate limits](https://runapi.ai/models/heygen-video)

Licensed under the Apache License, Version 2.0.
