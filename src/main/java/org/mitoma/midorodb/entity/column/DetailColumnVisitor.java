package org.mitoma.midorodb.entity.column;

public interface DetailColumnVisitor<R> {
  R visit(IntegerColumnMeta integerColumnMeta);

  R visit(TextColumnMeta textColumnMeta);
}
