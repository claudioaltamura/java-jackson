package de.claudioaltamura.java.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.Value;

@Value
@JsonTypeName("new")
public class EventNew implements Event {

  @Positive private final long id;
  @Nullable private final Long timestamp;
  @NotBlank private final String name;

  @JsonCreator
  public EventNew(
      @JsonProperty("id") long id,
      @JsonProperty("timestamp") Long timestamp,
      @JsonProperty("name") String name) {
    this.id = id;
    this.timestamp = timestamp;
    this.name = name;
  }
}
