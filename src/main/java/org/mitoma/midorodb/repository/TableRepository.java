package org.mitoma.midorodb.repository;

import java.util.List;

import org.mitoma.midorodb.entity.ColumnMeta;
import org.mitoma.midorodb.entity.Table;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

@ConfigAutowireable
@Dao
public interface TableRepository {

  @Select
  List<Table> selectAll();

  @Insert
  @Transactional
  int insert(Table table);


  @Insert
  @Transactional
  int insert(ColumnMeta columnMeta);

}
