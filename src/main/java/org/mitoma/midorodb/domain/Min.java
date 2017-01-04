package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

@XmlJavaTypeAdapter(MinXmlAdapter.class)
@Domain(valueType = Long.class)
public class Min<T> extends LongDomain {

  public Min(Long value) {
    super(value);
  }

}
