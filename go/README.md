# HeyGen Video API Go SDK for RunAPI

Use the HeyGen Video Go module for typed video tasks.

```bash
go get github.com/runapi-ai/heygen-video-sdk/go@latest
```

```go
import (
  "context"
  "github.com/runapi-ai/heygen-video-sdk/go/heygenvideo"
)

client, err := heygenvideo.NewClient()
result, err := client.TextToVideo.Run(context.Background(), heygenvideo.TextToVideoParams{
  Model: heygenvideo.ModelHeyGenVideo,
  Prompt: "A cinematic tracking shot through a rain-soaked city",
  AspectRatio: "16:9",
})
```

Use `TextToVideo` for prompt-only or reference-media generation. Use `ImageToVideo` with a first-frame image. Each resource provides `Create`, `Get`, and `Run`.

- [Model reference](https://runapi.ai/models/heygen-video)
- [API reference](https://runapi.ai/docs/api/heygen-video/text-to-video)
- [Pricing and rate limits](https://runapi.ai/models/heygen-video)

Licensed under the Apache License, Version 2.0.
