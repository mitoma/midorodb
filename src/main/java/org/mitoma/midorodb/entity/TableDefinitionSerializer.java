package org.mitoma.midorodb.entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class TableDefinitionSerializer extends StdSerializer<TableDefinition> {

  private static final long serialVersionUID = 5756652981777391099L;

  public TableDefinitionSerializer() {
    this(null);
  }

  protected TableDefinitionSerializer(Class<TableDefinition> t) {
    super(t);
  }

  @Override
  public void serialize(TableDefinition tableDefinition, JsonGenerator generator,
      SerializerProvider provider) throws IOException {
    TableMeta tableMeta = tableDefinition.getTableMeta();
    generator.writeStartObject();
    {
      generator.writeNumberField("id", tableMeta.getId().getValue());
      generator.writeStringField("label", tableMeta.getLabel().getValue());
      generator.writeStringField("code", tableMeta.getCode().getValue());
      generator.writeObjectField("columns", tableDefinition.getColumnMetas());
    }
    generator.writeEndObject();


  }
}
