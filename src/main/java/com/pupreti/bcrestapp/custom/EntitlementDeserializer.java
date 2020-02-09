package com.pupreti.bcrestapp.custom;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.pupreti.bcrestapp.model.Entitlement;

import java.io.IOException;

public class EntitlementDeserializer extends StdDeserializer<Entitlement> {

    public EntitlementDeserializer() {
        this(null);
    }

    public EntitlementDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Entitlement deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
//        JsonNode node = jp.getCodec().readTree(jp);
//        int id = (Integer) ((IntNode) node.get("id")).numberValue();
//        String itemName = node.get("itemName").asText();
//        int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();

//        return new Item(id, itemName, new User(userId, null));
        return null;
    }
}
