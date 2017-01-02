package org.mitoma.midorodb.entity;

import java.time.LocalDateTime;

import org.mitoma.midorodb.listener.BaseEntityListener;
import org.seasar.doma.Entity;
import org.seasar.doma.Version;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Data;

@Entity(naming = NamingType.SNAKE_LOWER_CASE, listener = BaseEntityListener.class)
@Data
public abstract class BaseEntity {

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @Version
  private long lockVersion;

}
