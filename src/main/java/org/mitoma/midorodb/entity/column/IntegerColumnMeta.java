package org.mitoma.midorodb.entity.column;

import org.mitoma.midorodb.domain.Identity;
import org.mitoma.midorodb.entity.BaseEntity;
import org.seasar.doma.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class IntegerColumnMeta extends BaseEntity implements DetailColumnMeta {

  private Identity<CommonColumnMeta> commonColumnMetaId;

  @Override
  public <R> R accept(DetailColumnVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
