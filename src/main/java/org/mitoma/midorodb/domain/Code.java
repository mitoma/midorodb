package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

@XmlJavaTypeAdapter(CodeXmlAdapter.class)
@Domain(valueType = String.class)
public class Code<T> extends StringDomain {

  public Code(String value) {
    super(value);
  }
}
