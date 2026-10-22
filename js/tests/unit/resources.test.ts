import { beforeEach, describe, expect, it, vi } from 'vitest';
import type { HttpClient } from '@runapi.ai/core';
import { TextToVideo } from '../../src/resources/text-to-video';
import { ImageToVideo } from '../../src/resources/image-to-video';

describe('HeyGen Video resources', () => {
  const mockHttp: HttpClient = { request: vi.fn() };

  beforeEach(() => vi.clearAllMocks());

  it('creates reference-to-video through the text-to-video endpoint', async () => {
    vi.mocked(mockHttp.request).mockResolvedValueOnce({ id: 'task-1' });

    await new TextToVideo(mockHttp).create({
      model: 'heygen-video-1',
      prompt: 'Carry the character and voice into a new scene',
      reference_image_urls: ['https://cdn.runapi.ai/public/samples/image.jpg'],
      reference_audio_urls: ['https://cdn.runapi.ai/public/samples/voice.mp3'],
      aspect_ratio: 'adaptive',
    });

    expect(mockHttp.request).toHaveBeenCalledWith('POST', '/api/v1/heygen_video/text_to_video', {
      body: {
        model: 'heygen-video-1',
        prompt: 'Carry the character and voice into a new scene',
        reference_image_urls: ['https://cdn.runapi.ai/public/samples/image.jpg'],
        reference_audio_urls: ['https://cdn.runapi.ai/public/samples/voice.mp3'],
        aspect_ratio: 'adaptive',
      },
    });
  });

  it('creates image-to-video with a first frame', async () => {
    vi.mocked(mockHttp.request).mockResolvedValueOnce({ id: 'task-2' });

    await new ImageToVideo(mockHttp).create({
      model: 'heygen-video-1',
      prompt: 'Animate the supplied frame',
      first_frame_image_url: 'https://cdn.runapi.ai/public/samples/image.jpg',
      duration_seconds: 8,
      output_resolution: '1080p',
      seed: 42,
    });

    expect(mockHttp.request).toHaveBeenCalledWith('POST', '/api/v1/heygen_video/image_to_video', {
      body: {
        model: 'heygen-video-1',
        prompt: 'Animate the supplied frame',
        first_frame_image_url: 'https://cdn.runapi.ai/public/samples/image.jpg',
          duration_seconds: 8,
        output_resolution: '1080p',
        seed: 42,
      },
    });
  });
});
