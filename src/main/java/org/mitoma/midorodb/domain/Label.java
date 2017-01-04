package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

@XmlJavaTypeAdapter(LabelXmlAdapter.class)
@Domain(valueType = String.class)
public class Label<T> extends StringDomain {

  public Label(String value) {
    super(value);
  }

}
