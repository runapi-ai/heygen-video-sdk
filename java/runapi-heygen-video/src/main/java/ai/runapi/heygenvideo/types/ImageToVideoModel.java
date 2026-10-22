package ai.runapi.heygenvideo.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/** Model slug for image to video operations. */
public final class ImageToVideoModel extends HeygenvideoValue {
  /** heygen-video model slug. */
  public static final ImageToVideoModel HEYGEN_VIDEO = new ImageToVideoModel("heygen-video-1");

  /** Creates a model value from a literal model slug. */
  @JsonCreator
  public ImageToVideoModel(String value) {
    super(value);
  }
}
