package com.linagora.james.mailets.json;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ClassificationGuessDeserializationTest {

    public static final ClassificationGuess CLASSIFICATION_GUESS = ClassificationGuess.builder()
        .mailboxId("cfe49390-f391-11e6-88e7-ddd22b16a7b9")
        .mailboxName("JAMES")
        .confidence(50.07615280151367)
        .build();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void jsonDeserializationShouldWork() throws Exception {
        String guess =
            "{" +
            "    \"mailboxId\":\"cfe49390-f391-11e6-88e7-ddd22b16a7b9\"," +
            "    \"mailboxName\":\"JAMES\"," +
            "    \"confidence\":50.07615280151367}" +
            "}";

        ClassificationGuess classificationGuess = objectMapper.readValue(guess, ClassificationGuess.class);

        assertThat(classificationGuess).isEqualTo(CLASSIFICATION_GUESS);
    }

    @Test
    public void jsonSerializationShouldWork() throws Exception {
        String json = objectMapper.writeValueAsString(CLASSIFICATION_GUESS);

        assertThatJson(json).isEqualTo("{" +
            "    \"mailboxId\":\"cfe49390-f391-11e6-88e7-ddd22b16a7b9\"," +
            "    \"mailboxName\":\"JAMES\"," +
            "    \"confidence\":50.07615280151367}" +
            "}");
    }

    @Test
    public void shouldImplementBeanContract() throws Exception {
        EqualsVerifier.forClass(ClassificationGuess.class).verify();
    }

}
