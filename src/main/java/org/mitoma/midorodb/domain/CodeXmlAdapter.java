package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CodeXmlAdapter extends XmlAdapter<String, Code> {

  @Override
  public Code unmarshal(String v) throws Exception {
    return Code.of(v);
  }

  @Override
  public String marshal(Code v) throws Exception {
    return v.getValue();
  }
}