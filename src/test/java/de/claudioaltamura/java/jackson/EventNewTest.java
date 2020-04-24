package de.claudioaltamura.java.jackson;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventNewTest {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Test
  @DisplayName("deserialize all properties")
  void deserializeWithAllProperties() throws JsonProcessingException {
    String json = "{\"type\": \"new\", \"id\":1, \"timestamp\":1, \"name\": \"Peter\" }";

    EventNew eventNew = objectMapper.readValue(json, EventNew.class);

    assertThat(eventNew).isEqualTo(new EventNew(1L, 1L, "Peter"));
  }

  @Test
  @DisplayName("deserialize all required properties")
  void deserializeWithOutNonRequiredProperty() throws JsonProcessingException {
    String json = "{\"type\": \"new\", \"id\":1, \"name\": \"Peter\" }";

    EventNew eventNew = objectMapper.readValue(json, EventNew.class);

    assertThat(eventNew).isEqualTo(new EventNew(1L, null, "Peter"));
  }

  @Test
  @DisplayName("deserialize with unknown properties")
  void deserializeWithUnknownProperty() throws JsonProcessingException {
    String json =
        "{\"type\": \"new\", \"id\":1, \"timestamp\":1,  \"name\": \"Peter\", \"age\": 5}";

    Throwable thrown = catchThrowable(() -> objectMapper.readValue(json, EventNew.class));

    assertThat(thrown)
        .isInstanceOf(UnrecognizedPropertyException.class)
        .hasMessageContaining("Unrecognized field");
  }
}
