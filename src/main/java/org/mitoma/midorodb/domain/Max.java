package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

import lombok.Value;

@XmlJavaTypeAdapter(MaxXmlAdapter.class)
@Domain(valueType = Long.class)
@Value
public class Max<T> {
  Long value;
}
