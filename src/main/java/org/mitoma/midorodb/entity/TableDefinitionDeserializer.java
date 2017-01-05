package org.mitoma.midorodb.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class TableDefinitionDeserializer extends StdDeserializer<TableDefinition> {

  public TableDefinitionDeserializer() {
    this(null);
  }

  protected TableDefinitionDeserializer(Class<?> vc) {
    super(vc);
  }

  private static final long serialVersionUID = 1L;

  @Override
  public TableDefinition deserialize(JsonParser parser, DeserializationContext context)
      throws IOException, JsonProcessingException {

    return null;
  }

}
