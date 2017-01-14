package org.mitoma.midorodb.entity.column;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ColumnMetaDeserializer extends StdSerializer<ColumnMeta> {

  private static final long serialVersionUID = 5756652981777391099L;

  public ColumnMetaDeserializer() {
    this(null);
  }

  protected ColumnMetaDeserializer(Class<ColumnMeta> t) {
    super(t);
  }

  @Override
  public void serialize(ColumnMeta columnMeta, JsonGenerator generator, SerializerProvider provider)
      throws IOException {
    generator.writeStartObject();

    CommonColumnMeta common = columnMeta.getCommon();
    DetailColumnMeta detail = columnMeta.getDetail();

    generator.writeStringField("label", common.getLabel().getValue());
    generator.writeStringField("code", common.getCode().getValue());
    generator.writeStringField("type", detail.columnType());

    detail.accept(new DetailColumnVisitor<Void>() {

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
