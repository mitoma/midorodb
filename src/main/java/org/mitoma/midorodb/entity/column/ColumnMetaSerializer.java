package org.mitoma.midorodb.entity.column;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ColumnMetaSerializer extends StdSerializer<ColumnMeta> {

  private static final long serialVersionUID = 5756652981777391099L;

  public ColumnMetaSerializer() {
    this(null);
  }

  protected ColumnMetaSerializer(Class<ColumnMeta> t) {
    super(t);
  }

  @Override
  public void serialize(ColumnMeta columnMeta, JsonGenerator generator, SerializerProvider provider)
      throws IOException {
    generator.writeStartObject();
    //    generator.writeNumberField("id", columnMeta.getCommon().getId().getValue());
    generator.writeStringField("label", columnMeta.getCommon().getLabel().getValue());
    generator.writeStringField("code", columnMeta.getCommon().getCode().getValue());
    generator.writeObjectField("type", ColumnType.getByDetailColumnMeta(columnMeta.getDetail()));

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
}
