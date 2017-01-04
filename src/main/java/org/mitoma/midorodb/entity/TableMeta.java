package org.mitoma.midorodb.entity;

import org.mitoma.midorodb.domain.Code;
import org.mitoma.midorodb.domain.Identity;
import org.mitoma.midorodb.domain.Label;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "table_metas")
@Data
@EqualsAndHashCode(callSuper = true)
public class TableMeta extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(sequence = "table_metas_id_seq")
  private Identity<TableMeta> id;

  private Code<TableMeta> code;

  private Label<TableMeta> label;

}
