from runapi.heygen_video import HeyGenVideoClient


class FakeHttp:
    def __init__(self, response=None):
        self.response = response or {"id": "task_1", "status": "pending"}
        self.calls = []

    def request(self, method, path, body=None, options=None):
        self.calls.append((method, path, body))
        return self.response


def test_posts_reference_media_through_text_to_video():
    fake = FakeHttp()
    client = HeyGenVideoClient(api_key="k", http_client=fake)
    client.text_to_video.create(
        model="heygen-video-1",
        prompt="Continue the performance",
        reference_image_urls=["https://cdn.runapi.ai/public/samples/image.jpg"],
        reference_audio_urls=["https://cdn.runapi.ai/public/samples/voice.mp3"],
        aspect_ratio="adaptive",
    )
    assert fake.calls == [("post", "/api/v1/heygen_video/text_to_video", {
        "model": "heygen-video-1",
        "prompt": "Continue the performance",
        "reference_image_urls": ["https://cdn.runapi.ai/public/samples/image.jpg"],
        "reference_audio_urls": ["https://cdn.runapi.ai/public/samples/voice.mp3"],
        "aspect_ratio": "adaptive",
    })]


def test_posts_first_frame_and_seed_through_image_to_video():
    fake = FakeHttp()
    client = HeyGenVideoClient(api_key="k", http_client=fake)
    client.image_to_video.create(
        model="heygen-video-1",
        prompt="Animate",
        first_frame_image_url="https://cdn.runapi.ai/public/samples/image.jpg",
        seed=42,
    )
    assert fake.calls == [("post", "/api/v1/heygen_video/image_to_video", {
        "model": "heygen-video-1",
        "prompt": "Animate",
        "first_frame_image_url": "https://cdn.runapi.ai/public/samples/image.jpg",
        "seed": 42,
    })]
