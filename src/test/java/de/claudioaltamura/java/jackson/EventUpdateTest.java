package de.claudioaltamura.java.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventUpdateTest {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Test
  @DisplayName("deserialize with unknown properties")
  void deserializeWithUnknownProperty() throws JsonProcessingException {
    String json =
        "{\"type\": \"update\", \"id\":1, \"timestamp\":1, \"oldName\": \"Peter\", \"newName\": \"Peter Angelo\", \"age\": 5}";

    EventUpdate eventUpdate = objectMapper.readValue(json, EventUpdate.class);

    assertThat(eventUpdate).isEqualTo(new EventUpdate(1L, 1L, "Peter", "Peter Angelo"));
  }
}
