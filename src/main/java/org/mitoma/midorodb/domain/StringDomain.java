package org.mitoma.midorodb.domain;

public abstract class StringDomain {
  protected final String value;

  public StringDomain(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
