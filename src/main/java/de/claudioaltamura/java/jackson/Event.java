package de.claudioaltamura.java.jackson;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = EventNew.class, name = "new"),
  @JsonSubTypes.Type(value = EventUpdate.class, name = "update"),
})
public interface Event {

  long getId();

  Long getTimestamp();
}
