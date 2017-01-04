package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CodeXmlAdapter<T> extends XmlAdapter<String, Code<T>> {

  @Override
  public Code<T> unmarshal(String v) throws Exception {
    return new Code<>(v);
  }

  @Override
  public String marshal(Code<T> v) throws Exception {
    return v.getValue();
  }
}
