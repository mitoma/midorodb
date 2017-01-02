package org.mitoma.midorodb.entity.column;

import lombok.Value;

@Value
public class ColumnMeta {
  private CommonColumnMeta common;
  private DetailColumnMeta detail;
}
