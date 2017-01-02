package org.mitoma.midorodb.listener;

import java.time.LocalDateTime;

import org.mitoma.midorodb.entity.BaseEntity;
import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

public class BaseEntityListener<T extends BaseEntity> implements EntityListener<T> {

  @Override
  public void preInsert(T entity, PreInsertContext<T> context) {
    LocalDateTime now = LocalDateTime.now();
    entity.setCreatedAt(now);
    entity.setUpdatedAt(now);
  }

  @Override
  public void preUpdate(T entity, PreUpdateContext<T> context) {
    entity.setUpdatedAt(LocalDateTime.now());
  }
}
