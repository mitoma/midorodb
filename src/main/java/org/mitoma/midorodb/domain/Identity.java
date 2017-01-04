package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

@XmlJavaTypeAdapter(IdentityXmlAdapter.class)
@Domain(valueType = Long.class)
public class Identity<T> extends LongDomain {

  public Identity(Long value) {
    super(value);
  }

}
