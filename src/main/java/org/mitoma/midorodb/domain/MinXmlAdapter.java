package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MinXmlAdapter<T> extends XmlAdapter<Long, Min<T>> {

  @Override
  public Min<T> unmarshal(Long v) throws Exception {
    return new Min<>(v);
  }

  @Override
  public Long marshal(Min<T> v) throws Exception {
    return v.getValue();
  }
}
