package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IdentityXmlAdapter extends XmlAdapter<Long, Identity<?>> {

  @Override
  public Identity<?> unmarshal(Long v) throws Exception {
    return Identity.of(v);
  }

  @Override
  public Long marshal(Identity<?> v) throws Exception {
    return v.getValue();
  }
}
