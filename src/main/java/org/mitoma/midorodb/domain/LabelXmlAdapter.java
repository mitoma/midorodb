package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LabelXmlAdapter extends XmlAdapter<String, Label> {

  @Override
  public Label unmarshal(String v) throws Exception {
    return Label.of(v);
  }

  @Override
  public String marshal(Label v) throws Exception {
    return v.getValue();
  }
}