package org.mitoma.midorodb.entity.column;

import org.mitoma.midorodb.domain.Identity;
import org.mitoma.midorodb.entity.BaseEntity;
import org.mitoma.midorodb.entity.TableMeta;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CommonColumnMeta extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(sequence = "common_column_metas_seq")
  private Identity<CommonColumnMeta> id;

  private Identity<TableMeta> tableMetaId;

}
