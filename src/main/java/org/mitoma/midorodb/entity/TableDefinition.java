package org.mitoma.midorodb.entity;

import java.util.List;

import org.mitoma.midorodb.entity.column.ColumnMeta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Value;

@Value
@JsonSerialize(using = TableDefinitionSerializer.class)
public class TableDefinition {

  private TableMeta tableMeta;

  private List<ColumnMeta> columnMetas;
}
