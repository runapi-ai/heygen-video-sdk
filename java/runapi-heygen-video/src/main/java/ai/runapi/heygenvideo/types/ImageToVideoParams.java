package ai.runapi.heygenvideo.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Parameters for image to video operations. */
public final class ImageToVideoParams {
  private final String model;
  private final String prompt;
  private final String firstFrameImageUrl;
  private final Integer durationSeconds;
  private final String outputResolution;
  private final Long seed;
  private final String callbackUrl;

  private ImageToVideoParams(Builder builder) {
    this.model = builder.model;
    this.prompt = builder.prompt;
    this.firstFrameImageUrl = builder.firstFrameImageUrl;
    this.durationSeconds = builder.durationSeconds;
    this.outputResolution = builder.outputResolution;
    this.seed = builder.seed;
    this.callbackUrl = builder.callbackUrl;
  }

  /** Creates a new ImageToVideoParams builder. */
  public static Builder builder() {
    return new Builder();
  }

  /** Returns the RunAPI action key for this request. */
  public String action() {
    return "heygen-video/image-to-video";
  }

  /** Converts these parameters to the JSON request body shape. */
  public Map<String, Object> toMap() {
    Map<String, Object> raw = new LinkedHashMap<String, Object>();
    raw.put("model", HeygenvideoParamUtils.wireValue(model));
    raw.put("prompt", HeygenvideoParamUtils.wireValue(prompt));
    raw.put("first_frame_image_url", HeygenvideoParamUtils.wireValue(firstFrameImageUrl));
    raw.put("duration_seconds", HeygenvideoParamUtils.wireValue(durationSeconds));
    raw.put("output_resolution", HeygenvideoParamUtils.wireValue(outputResolution));
    raw.put("seed", HeygenvideoParamUtils.wireValue(seed));
    raw.put("callback_url", HeygenvideoParamUtils.wireValue(callbackUrl));
    return HeygenvideoParamUtils.compact(raw);
  }



  /** Builder for {@link ImageToVideoParams}. */
  public static final class Builder {
    private String model;
    private String prompt;
    private String firstFrameImageUrl;
    private Integer durationSeconds;
    private String outputResolution;
    private Long seed;
    private String callbackUrl;

    private Builder() {}

    /** Sets the model slug using a typed model value. */
    public Builder model(ImageToVideoModel value) {
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

    /** Sets the first frame image URL. */
    public Builder firstFrameImageUrl(String value) {
      this.firstFrameImageUrl = value;
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

    /** Builds immutable image to video parameters. */
    public ImageToVideoParams build() {
      return new ImageToVideoParams(this);
    }
  }
}
