package org.mitoma.midorodb.entity;

import org.mitoma.midorodb.domain.Code;
import org.mitoma.midorodb.domain.Identity;
import org.mitoma.midorodb.domain.Label;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.OriginalStates;
import org.seasar.doma.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Table extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(sequence = "midoro_table_id_seq")
  private Identity<Table> id;

  private Code<Table> name;

  private Label<Table> label;

  @OriginalStates
  private Table origin;
}
