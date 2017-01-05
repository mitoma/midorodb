package org.mitoma.midorodb.entity.column;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Value;

@Value
public class ColumnMeta {
  private CommonColumnMeta common;
  @JsonTypeInfo(property = "type", use = JsonTypeInfo.Id.NAME)
  private DetailColumnMeta detail;
}
