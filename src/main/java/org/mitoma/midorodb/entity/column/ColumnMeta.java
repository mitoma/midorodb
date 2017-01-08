package org.mitoma.midorodb.entity.column;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Value;

@Value
@JsonSerialize(using = ColumnMetaSerializer.class)
public class ColumnMeta {
  private CommonColumnMeta common;
  @JsonTypeInfo(property = "type", use = JsonTypeInfo.Id.NAME)
  private DetailColumnMeta detail;
}
