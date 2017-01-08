package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

import lombok.Value;

@XmlJavaTypeAdapter(SortOrderXmlAdapter.class)
@Domain(valueType = Integer.class)
@Value
public class SortOrder {
  Integer value;
}
