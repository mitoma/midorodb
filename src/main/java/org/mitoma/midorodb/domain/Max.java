package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

@XmlJavaTypeAdapter(MaxXmlAdapter.class)
@Domain(valueType = Long.class)
public class Max<T> extends LongDomain {

  public Max(Long value) {
    super(value);
  }
}
