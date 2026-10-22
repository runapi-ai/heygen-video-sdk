package ai.runapi.heygenvideo.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Parameters for text to video operations. */
public final class TextToVideoParams {
  private final String model;
  private final String prompt;
  private final Integer durationSeconds;
  private final String outputResolution;
  private final String aspectRatio;
  private final List<String> referenceImageUrls;
  private final List<String> referenceVideoUrls;
  private final List<String> referenceAudioUrls;
  private final Long seed;
  private final String callbackUrl;

  private TextToVideoParams(Builder builder) {
    this.model = builder.model;
    this.prompt = builder.prompt;
    this.durationSeconds = builder.durationSeconds;
    this.outputResolution = builder.outputResolution;
    this.aspectRatio = builder.aspectRatio;
    this.referenceImageUrls = HeygenvideoParamUtils.strings(builder.referenceImageUrls);
    this.referenceVideoUrls = HeygenvideoParamUtils.strings(builder.referenceVideoUrls);
    this.referenceAudioUrls = HeygenvideoParamUtils.strings(builder.referenceAudioUrls);
    this.seed = builder.seed;
    this.callbackUrl = builder.callbackUrl;
  }

  /** Creates a new TextToVideoParams builder. */
  public static Builder builder() {
    return new Builder();
  }

  /** Returns the RunAPI action key for this request. */
  public String action() {
    return "heygen-video/text-to-video";
  }

  /** Converts these parameters to the JSON request body shape. */
  public Map<String, Object> toMap() {
    Map<String, Object> raw = new LinkedHashMap<String, Object>();
    raw.put("model", HeygenvideoParamUtils.wireValue(model));
    raw.put("prompt", HeygenvideoParamUtils.wireValue(prompt));
    raw.put("duration_seconds", HeygenvideoParamUtils.wireValue(durationSeconds));
    raw.put("output_resolution", HeygenvideoParamUtils.wireValue(outputResolution));
    raw.put("aspect_ratio", HeygenvideoParamUtils.wireValue(aspectRatio));
    raw.put("reference_image_urls", HeygenvideoParamUtils.wireValue(referenceImageUrls));
    raw.put("reference_video_urls", HeygenvideoParamUtils.wireValue(referenceVideoUrls));
    raw.put("reference_audio_urls", HeygenvideoParamUtils.wireValue(referenceAudioUrls));
    raw.put("seed", HeygenvideoParamUtils.wireValue(seed));
    raw.put("callback_url", HeygenvideoParamUtils.wireValue(callbackUrl));
    return HeygenvideoParamUtils.compact(raw);
  }



  /** Builder for {@link TextToVideoParams}. */
  public static final class Builder {
    private String model;
    private String prompt;
    private Integer durationSeconds;
    private String outputResolution;
    private String aspectRatio;
    private List<String> referenceImageUrls;
    private List<String> referenceVideoUrls;
    private List<String> referenceAudioUrls;
    private Long seed;
    private String callbackUrl;

    private Builder() {}

    /** Sets the model slug using a typed model value. */
    public Builder model(TextToVideoModel value) {
      this.model = java.util.Objects.requireNonNull(value, "model").value();
      return this;
    }

    /** Sets the model slug using a string value. */
    public Builder model(String value) {
      this.model = value;
      return this;
    }


    /** Sets the text prompt. */
    public Builder prompt(String value) {
      this.prompt = value;
      return this;
    }

    /** Sets the duration in seconds. */
    public Builder durationSeconds(int value) {
      this.durationSeconds = value;
      return this;
    }

    /** Sets the output resolution. */
    public Builder outputResolution(String value) {
      this.outputResolution = value;
      return this;
    }

    /** Sets the output aspect ratio. */
    public Builder aspectRatio(String value) {
      this.aspectRatio = value;
      return this;
    }

    /** Sets the reference image URLs. */
    public Builder referenceImageUrls(List<String> value) {
      this.referenceImageUrls = value;
      return this;
    }

    /** Sets the reference video URLs. */
    public Builder referenceVideoUrls(List<String> value) {
      this.referenceVideoUrls = value;
      return this;
    }

    /** Sets the reference audio URLs. */
    public Builder referenceAudioUrls(List<String> value) {
      this.referenceAudioUrls = value;
      return this;
    }

    /** Sets the random seed. */
    public Builder seed(long value) {
      this.seed = value;
      return this;
    }

    /** Sets the webhook URL for task completion notifications. */
    public Builder callbackUrl(String value) {
      this.callbackUrl = value;
      return this;
    }

    /** Builds immutable text to video parameters. */
    public TextToVideoParams build() {
      return new TextToVideoParams(this);
    }
  }
}
