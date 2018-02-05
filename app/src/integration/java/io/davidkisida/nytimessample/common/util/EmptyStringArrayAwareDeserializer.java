package io.davidkisida.nytimessample.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmptyStringArrayAwareDeserializer extends JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        List<String> values = new ArrayList<>();

        if (p.getCurrentToken() == JsonToken.START_ARRAY) {

            while (p.nextToken() != JsonToken.END_ARRAY) {
                values.add(p.getValueAsString());
            }
        }

        return values;
    }
}
