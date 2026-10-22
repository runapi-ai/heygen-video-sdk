package ai.runapi.heygenvideo.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/** Model slug for text to video operations. */
public final class TextToVideoModel extends HeygenvideoValue {
  /** heygen-video model slug. */
  public static final TextToVideoModel HEYGEN_VIDEO = new TextToVideoModel("heygen-video-1");

  /** Creates a model value from a literal model slug. */
  @JsonCreator
  public TextToVideoModel(String value) {
    super(value);
  }
}
