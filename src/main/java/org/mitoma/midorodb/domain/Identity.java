package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

import lombok.Value;

@XmlJavaTypeAdapter(IdentityXmlAdapter.class)
@Domain(valueType = Long.class)
@Value
public class Identity<T> {
  Long value;
}
