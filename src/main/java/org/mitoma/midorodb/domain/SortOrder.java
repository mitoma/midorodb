package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

@XmlJavaTypeAdapter(SortOrderXmlAdapter.class)
@Domain(valueType = Integer.class)
public class SortOrder extends IntegerDomain {

  public SortOrder(Integer value) {
    super(value);
  }
}
