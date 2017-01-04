package org.mitoma.midorodb.domain;

import lombok.ToString;

@ToString
public abstract class LongDomain {
  private final Long value;

  public LongDomain(Long value) {
    this.value = value;
  }

  public Long getValue() {
    return value;
  }
}
