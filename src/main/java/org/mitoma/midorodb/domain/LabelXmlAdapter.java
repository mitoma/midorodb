package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LabelXmlAdapter<T> extends XmlAdapter<String, Label<T>> {

  @Override
  public Label<T> unmarshal(String v) throws Exception {
    return new Label<>(v);
  }

  @Override
  public String marshal(Label<T> v) throws Exception {
    return v.getValue();
  }
}
