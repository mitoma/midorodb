package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SortOrderXmlAdapter extends XmlAdapter<Integer, SortOrder> {

  @Override
  public SortOrder unmarshal(Integer v) throws Exception {
    return new SortOrder(v);
  }

  @Override
  public Integer marshal(SortOrder v) throws Exception {
    return v.getValue();
  }
}
