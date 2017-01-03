package org.mitoma.midorodb.repository;

import java.util.List;

import org.mitoma.midorodb.domain.Identity;
import org.mitoma.midorodb.entity.TableMeta;
import org.mitoma.midorodb.entity.column.CommonColumnMeta;
import org.mitoma.midorodb.entity.column.IntegerColumnMeta;
import org.mitoma.midorodb.entity.column.TextColumnMeta;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface TableDefinitionRepository {

  @Insert
  int insert(TableMeta table);

  @Insert
  int insert(CommonColumnMeta columnMeta);

  @Insert
  int insert(IntegerColumnMeta columnMeta);

  @Insert
  int insert(TextColumnMeta columnMeta);

  @Select
  List<TableMeta> selectAllTableMetas();

  @Select
  List<CommonColumnMeta> selectAllCommonColumnMetas(List<Identity<TableMeta>> tableMetaIds);

  @Select
  List<IntegerColumnMeta> selectAllIntegerColumnMetas(
      List<Identity<CommonColumnMeta>> commonColumnMetaIds);

  @Select
  List<TextColumnMeta> selectAllTextColumnMetas(
      List<Identity<CommonColumnMeta>> commonColumnMetaIds);

}
