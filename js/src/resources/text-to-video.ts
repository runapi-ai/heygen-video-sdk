import type { HttpClient, PollingOptions, RequestOptions } from '@runapi.ai/core';
import { compactParams } from '@runapi.ai/core';
import { pollUntilComplete } from '@runapi.ai/core/internal';
import type {
  CompletedHeyGenVideoVideoResponse,
  HeyGenVideoTextToVideoParams,
  HeyGenVideoVideoResponse,
  TaskCreateResponse,
} from '../types';

const ENDPOINT = '/api/v1/heygen_video/text_to_video';

export class TextToVideo {
  constructor(private readonly http: HttpClient) {}

  async run(
    params: HeyGenVideoTextToVideoParams,
    options?: RequestOptions & PollingOptions
  ): Promise<CompletedHeyGenVideoVideoResponse> {
    const { id } = await this.create(params, options);
    return pollUntilComplete<HeyGenVideoVideoResponse>(() => this.get(id, options), {
      maxWaitMs: options?.maxWaitMs,
      pollIntervalMs: options?.pollIntervalMs,
    }) as Promise<CompletedHeyGenVideoVideoResponse>;
  }

  async create(params: HeyGenVideoTextToVideoParams, options?: RequestOptions): Promise<TaskCreateResponse> {
    const body = compactParams(params);
    return this.http.request<TaskCreateResponse>('POST', ENDPOINT, { body, ...options });
  }

  async get(id: string, options?: RequestOptions): Promise<HeyGenVideoVideoResponse> {
    return this.http.request<HeyGenVideoVideoResponse>('GET', `${ENDPOINT}/${id}`, options ?? {});
  }
}
