package org.mitoma.midorodb.entity;

import java.util.List;

import org.mitoma.midorodb.entity.column.ColumnMeta;

import lombok.Value;

@Value
public class TableDefinition {

  private TableMeta tableMeta;

  private List<ColumnMeta> columnMetas;
}
