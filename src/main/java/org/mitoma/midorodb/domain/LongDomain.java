package org.mitoma.midorodb.domain;

public abstract class LongDomain {
  private final Long value;

  public LongDomain(Long value) {
    this.value = value;
  }

  public Long getValue() {
    return value;
  }
}
