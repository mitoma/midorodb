package org.mitoma.midorodb.entity;

import java.io.IOException;
import java.util.List;

import org.mitoma.midorodb.entity.column.ColumnMeta;
import org.mitoma.midorodb.entity.column.DetailColumnVisitor;
import org.mitoma.midorodb.entity.column.IntegerColumnMeta;
import org.mitoma.midorodb.entity.column.TextColumnMeta;

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
    generator.writeNumberField("id", tableMeta.getId().getValue());
    generator.writeStringField("label", tableMeta.getLabel().getValue());
    generator.writeStringField("code", tableMeta.getCode().getValue());
    {
      generator.writeArrayFieldStart("columns");
      List<ColumnMeta> columnMetas = tableDefinition.getColumnMetas();
      for (ColumnMeta columnMeta : columnMetas) {
        generator.writeStartObject();
        generator.writeNumberField("id", columnMeta.getCommon().getId().getValue());
        generator.writeStringField("label", columnMeta.getCommon().getLabel().getValue());
        generator.writeStringField("code", columnMeta.getCommon().getCode().getValue());
        columnMeta.getDetail().accept(new DetailColumnVisitor<Void>() {

          @Override
          public Void visit(IntegerColumnMeta integerColumnMeta) {
            try {
              generator.writeNumberField("min", integerColumnMeta.getMin().getValue());
              generator.writeNumberField("max", integerColumnMeta.getMax().getValue());
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            return null;
          }

          @Override
          public Void visit(TextColumnMeta textColumnMeta) {
            try {
              generator.writeNumberField("min_length", textColumnMeta.getMinLength());
              generator.writeNumberField("max_length", textColumnMeta.getMaxLength());
              generator.writeStringField("text_pattern", textColumnMeta.getTextPattern());
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            return null;
          }
        });
        generator.writeEndObject();
      }
      generator.writeEndArray();
    }
    generator.writeEndObject();


  }
}
