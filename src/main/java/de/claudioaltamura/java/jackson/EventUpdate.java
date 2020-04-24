package de.claudioaltamura.java.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("update")
public class EventUpdate implements Event {

  @Positive private final long id;
  @Nullable private final Long timestamp;
  @NotNull private final String oldName;
  @NotNull private final String newName;

  @JsonCreator
  public EventUpdate(
      @JsonProperty("id") long id,
      @JsonProperty("timestamp") Long timestamp,
      @JsonProperty("oldName") String oldName,
      @JsonProperty("newName") String newName) {
    this.id = id;
    this.timestamp = timestamp;
    this.oldName = oldName;
    this.newName = newName;
  }
}
