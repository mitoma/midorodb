package org.mitoma.midorodb.entity.column;

import org.mitoma.midorodb.domain.Code;
import org.mitoma.midorodb.domain.Identity;
import org.mitoma.midorodb.domain.Label;
import org.mitoma.midorodb.domain.SortOrder;
import org.mitoma.midorodb.entity.BaseEntity;
import org.mitoma.midorodb.entity.TableMeta;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "common_column_metas")
@Data
@EqualsAndHashCode(callSuper = true)
public class CommonColumnMeta extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(sequence = "common_column_metas_id_seq")
  private Identity<CommonColumnMeta> id;

  private Identity<TableMeta> tableMetaId;

  private Code<TableMeta> code;

  private Label<TableMeta> label;

  @Column(name = "sort_order")
  private SortOrder sortOrder;

}
