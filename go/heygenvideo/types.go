package heygenvideo

import "github.com/runapi-ai/core-sdk/go/core"

type Model string

const ModelHeyGenVideo1 Model = "heygen-video-1"

type Video struct {
	URL string `json:"url"`
}

type AsyncTaskResponse struct {
	Usage  *core.TaskUsage `json:"usage,omitempty"`
	ID     string          `json:"id"`
	Status string          `json:"status"`
	Error  string          `json:"error,omitempty"`
}

func (r AsyncTaskResponse) GetID() string     { return r.ID }
func (r AsyncTaskResponse) GetStatus() string { return r.Status }
func (r AsyncTaskResponse) GetError() string  { return r.Error }

type VideoTaskResponse struct {
	AsyncTaskResponse
	Videos []Video `json:"videos,omitempty"`
}

type TextToVideoParams struct {
	Model              Model    `json:"model" help:"required; model slug"`
	Prompt             string   `json:"prompt" help:"required; 1 to 16000 characters"`
	DurationSeconds    int      `json:"duration_seconds,omitempty" help:"optional; 5 to 15 seconds; default 5"`
	OutputResolution   string   `json:"output_resolution,omitempty" help:"optional; 480p, 768p, 1080p, or 2k; default 768p"`
	AspectRatio        string   `json:"aspect_ratio,omitempty" help:"optional; adaptive requires reference images or videos; 1080p and 2k support only 16:9 and 9:16"`
	ReferenceImageURLs []string `json:"reference_image_urls,omitempty" help:"optional; up to 9 public HTTPS image URLs"`
	ReferenceVideoURLs []string `json:"reference_video_urls,omitempty" help:"optional; up to 3 public HTTPS video URLs"`
	ReferenceAudioURLs []string `json:"reference_audio_urls,omitempty" help:"optional; up to 3 public HTTPS audio URLs; requires reference images or videos"`
	Seed               *int     `json:"seed,omitempty" help:"optional; integer from 0 to 4294967295"`
	CallbackURL        string   `json:"callback_url,omitempty" help:"optional; URL that receives completion callback"`
}

type ImageToVideoParams struct {
	Model              Model  `json:"model" help:"required; model slug"`
	Prompt             string `json:"prompt" help:"required; 1 to 16000 characters"`
	FirstFrameImageURL string `json:"first_frame_image_url" help:"required; public HTTPS first-frame image URL"`
	DurationSeconds    int    `json:"duration_seconds,omitempty" help:"optional; 5 to 15 seconds; default 5"`
	OutputResolution   string `json:"output_resolution,omitempty" help:"optional; 480p, 768p, 1080p, or 2k; default 768p"`
	Seed               *int   `json:"seed,omitempty" help:"optional; integer from 0 to 4294967295"`
	CallbackURL        string `json:"callback_url,omitempty" help:"optional; URL that receives completion callback"`
}
