# HeyGen Video API Java SDK for RunAPI

Use `ai.runapi:runapi-heygen-video` for typed HeyGen Video video tasks.

```kotlin
dependencies {
  implementation("ai.runapi:runapi-heygen-video:0.1.0")
}
```

```java
import ai.runapi.heygenvideo.HeyGenVideoClient;
import ai.runapi.heygenvideo.types.TextToVideoModel;
import ai.runapi.heygenvideo.types.TextToVideoParams;

HeyGenVideoClient client = HeyGenVideoClient.builder().build();
var result = client.textToVideo().run(
    TextToVideoParams.builder()
        .model(TextToVideoModel.HEYGEN_VIDEO)
        .prompt("A cinematic tracking shot through a rain-soaked city")
        .aspectRatio("16:9")
        .build());
```

Use `textToVideo()` for prompt-only or reference-media generation. Use `imageToVideo()` with a first-frame image. Each resource provides `create`, `get`, and `run`.

- [Model reference](https://runapi.ai/models/heygen-video)
- [API reference](https://runapi.ai/docs/api/heygen-video/text-to-video)
- [Pricing and rate limits](https://runapi.ai/models/heygen-video)

Licensed under the Apache License, Version 2.0.
