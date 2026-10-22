import type { AsyncTaskStatus, TaskResponse } from '@runapi.ai/core';

export type HeyGenVideoModel = 'heygen-video-1';
export type HeyGenVideoDurationSeconds = 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15;
export type HeyGenVideoOutputResolution = '480p' | '768p' | '1080p' | '2k';
export type HeyGenVideoAspectRatio = 'adaptive' | '21:9' | '16:9' | '4:3' | '1:1' | '3:4' | '9:16';

interface TaskCommonParams {
  model: HeyGenVideoModel;
  prompt: string;
  duration_seconds?: HeyGenVideoDurationSeconds;
  output_resolution?: HeyGenVideoOutputResolution;
  seed?: number;
  callback_url?: string;
}

export interface HeyGenVideoTextToVideoParams extends TaskCommonParams {
  aspect_ratio?: HeyGenVideoAspectRatio;
  reference_image_urls?: string[];
  reference_video_urls?: string[];
  reference_audio_urls?: string[];
}

export interface HeyGenVideoImageToVideoParams extends TaskCommonParams {
  first_frame_image_url: string;
}

export interface TaskCreateResponse {
  id: string;
}

export interface MediaUrl {
  url: string;
}

export interface HeyGenVideoVideoResponse extends TaskResponse {
  id: string;
  status: AsyncTaskStatus;
  videos?: MediaUrl[];
  error?: string;
  [key: string]: unknown;
}

export type CompletedHeyGenVideoVideoResponse = HeyGenVideoVideoResponse & {
  status: 'completed';
  videos: MediaUrl[];
};
