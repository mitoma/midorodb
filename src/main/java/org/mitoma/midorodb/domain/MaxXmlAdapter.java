package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MaxXmlAdapter<T> extends XmlAdapter<Long, Max<T>> {

  @Override
  public Max<T> unmarshal(Long v) throws Exception {
    return new Max<>(v);
  }

  @Override
  public Long marshal(Max<T> v) throws Exception {
    return v.getValue();
  }
}
