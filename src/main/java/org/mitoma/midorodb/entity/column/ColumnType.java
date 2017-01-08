package org.mitoma.midorodb.entity.column;

public enum ColumnType {

  INTEGER, TEXT;

  public static ColumnType getByDetailColumnMeta(DetailColumnMeta detailColumnMeta) {
    return detailColumnMeta.accept(new DetailColumnVisitor<ColumnType>() {

      @Override
      public ColumnType visit(IntegerColumnMeta integerColumnMeta) {
        return INTEGER;
      }

      @Override
      public ColumnType visit(TextColumnMeta textColumnMeta) {
        return TEXT;
      }
    });
  }

}
