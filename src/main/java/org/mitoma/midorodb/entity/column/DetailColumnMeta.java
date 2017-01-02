package org.mitoma.midorodb.entity.column;

import org.mitoma.midorodb.domain.Identity;

public interface DetailColumnMeta {

  <R> R accept(DetailColumnVisitor<R> visitor);

  void setCommonColumnMetaId(Identity<CommonColumnMeta> commonColumnMetaId);

  Identity<CommonColumnMeta> getCommonColumnMetaId();

}
