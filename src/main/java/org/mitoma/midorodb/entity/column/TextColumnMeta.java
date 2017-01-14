package org.mitoma.midorodb.entity.column;

import org.mitoma.midorodb.domain.Identity;
import org.mitoma.midorodb.entity.BaseEntity;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "text_column_metas")
@Data
@EqualsAndHashCode(callSuper = true)
public class TextColumnMeta extends BaseEntity implements DetailColumnMeta {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(sequence = "text_column_metas_id_seq")
  private Identity<TextColumnMeta> id;

  private Identity<CommonColumnMeta> commonColumnMetaId;

  private long minLength;

  private long maxLength;

  private String textPattern;

  @Override
  public <R> R accept(DetailColumnVisitor<R> visitor) {
    return visitor.visit(this);
  }

  @Override
  public String columnType() {
    return "text";
  }
}
