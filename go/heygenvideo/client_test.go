package heygenvideo

import (
	"context"
	"encoding/json"
	"testing"

	"github.com/runapi-ai/core-sdk/go/core"
)

type stubHTTPClient struct {
	method, path string
	body         any
}

func (s *stubHTTPClient) Request(_ context.Context, method, path string, opts *core.HTTPRequestOptions) (json.RawMessage, error) {
	s.method, s.path = method, path
	if opts != nil {
		s.body = opts.Body
	}
	return json.RawMessage(`{"id":"task_123","status":"processing"}`), nil
}

func TestTextToVideoCreateWithReferences(t *testing.T) {
	stub := &stubHTTPClient{}
	client := NewClientWithHTTP(stub)
	_, err := client.TextToVideo.Create(context.Background(), TextToVideoParams{Model: ModelHeyGenVideo1, Prompt: "Continue the performance", ReferenceImageURLs: []string{"https://cdn.runapi.ai/public/samples/image.jpg"}, ReferenceAudioURLs: []string{"https://cdn.runapi.ai/public/samples/voice.mp3"}, AspectRatio: "adaptive"})
	if err != nil {
		t.Fatal(err)
	}
	if stub.method != "POST" || stub.path != textToVideoPath {
		t.Fatalf("unexpected request: %s %s", stub.method, stub.path)
	}
	body := stub.body.(map[string]any)
	if body["model"] != "heygen-video-1" {
		t.Fatalf("unexpected model: %v", body["model"])
	}
}

func TestImageToVideoCreateWithFirstFrame(t *testing.T) {
	stub := &stubHTTPClient{}
	client := NewClientWithHTTP(stub)
	seed := 42
	_, err := client.ImageToVideo.Create(context.Background(), ImageToVideoParams{Model: ModelHeyGenVideo1, Prompt: "Animate the scene", FirstFrameImageURL: "https://cdn.runapi.ai/public/samples/image.jpg", Seed: &seed})
	if err != nil {
		t.Fatal(err)
	}
	if stub.method != "POST" || stub.path != imageToVideoPath {
		t.Fatalf("unexpected request: %s %s", stub.method, stub.path)
	}
	body := stub.body.(map[string]any)
	if body["first_frame_image_url"] != "https://cdn.runapi.ai/public/samples/image.jpg" {
		t.Fatalf("unexpected first frame: %v", body["first_frame_image_url"])
	}
	if body["seed"] != float64(42) && body["seed"] != 42 {
		t.Fatalf("unexpected seed: %v", body["seed"])
	}
}
