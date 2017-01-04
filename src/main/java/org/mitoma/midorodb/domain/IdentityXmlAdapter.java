package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IdentityXmlAdapter<T> extends XmlAdapter<Long, Identity<T>> {

  @Override
  public Identity<T> unmarshal(Long v) throws Exception {
    return new Identity<>(v);
  }

  @Override
  public Long marshal(Identity<T> v) throws Exception {
    return v.getValue();
  }
}
