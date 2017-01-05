package org.mitoma.midorodb.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public abstract class LongDomain {
  private final Long value;

  public LongDomain(Long value) {
    this.value = value;
  }

  public Long getValue() {
    return value;
  }
}
