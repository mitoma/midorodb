package org.mitoma.midorodb.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.seasar.doma.Domain;

import lombok.Value;

@XmlJavaTypeAdapter(CodeXmlAdapter.class)
@Domain(valueType = String.class, factoryMethod = "of")
@Value(staticConstructor = "of")
public class Code<T> {

  String value;

}
