package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

import lombok.Value;

@XmlJavaTypeAdapter(IdentityXmlAdapter.class)
@Domain(valueType = Long.class, factoryMethod = "of")
@Value(staticConstructor = "of")
public class Identity<T> {

  private final long value;
}
