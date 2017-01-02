package org.mitoma.midorodb.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.mitoma.midorodb.domain.Code;
import org.mitoma.midorodb.domain.Label;
import org.mitoma.midorodb.entity.Table;
import org.mitoma.midorodb.entity.column.CommonColumnMeta;
import org.mitoma.midorodb.entity.column.IntegerColumnMeta;

public class TableBuilder {

  private Label<Table> name;
  private Code<Table> code = Code.of(UUID.randomUUID().toString());

  private List<CommonColumnMeta> columnMetas = new ArrayList<>();
  private List<IntegerColumnMeta> integerColumnMetas = new ArrayList<>();

  public TableBuilder name(Label<Table> name) {
    this.name = name;
    return this;
  }

  public TableBuilder code(Code<Table> code) {
    this.code = code;
    return this;
  }

  public TableBuilder column(CommonColumnMeta columnMeta, IntegerColumnMeta IntegerColumnMeta) {
    columnMetas.add(columnMeta);
    integerColumnMetas.add(IntegerColumnMeta);
    return this;
  }
  
  
}
