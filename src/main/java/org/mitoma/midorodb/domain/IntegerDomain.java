package org.mitoma.midorodb.domain;

public abstract class IntegerDomain {
  private final Integer value;

  public IntegerDomain(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}
