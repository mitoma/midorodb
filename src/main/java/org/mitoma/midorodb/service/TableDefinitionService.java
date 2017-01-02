package org.mitoma.midorodb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.mitoma.midorodb.domain.Identity;
import org.mitoma.midorodb.entity.TableDefinition;
import org.mitoma.midorodb.entity.TableMeta;
import org.mitoma.midorodb.entity.column.CommonColumnMeta;
import org.mitoma.midorodb.entity.column.DetailColumnMeta;
import org.mitoma.midorodb.entity.column.DetailColumnVisitor;
import org.mitoma.midorodb.entity.column.IntegerColumnMeta;
import org.mitoma.midorodb.entity.column.TextColumnMeta;
import org.mitoma.midorodb.repository.TableDefinitionRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TableDefinitionService {

  private final TableDefinitionRepository tableDefinitionRepository;

  public List<TableDefinition> load() {
    List<TableMeta> tableMetas = tableDefinitionRepository.selectAllTableMetas();
    List<CommonColumnMeta> commonColumnMetas = tableDefinitionRepository.selectAllCommonColumnMetas(
        tableMetas.stream().map(TableMeta::getId).collect(Collectors.toList()));
    List<Identity<CommonColumnMeta>> columnMetaIds =
        commonColumnMetas.stream().map(CommonColumnMeta::getId).collect(Collectors.toList());
    // ここから
    return null;
  }

  public void create(TableDefinition tableDefinition) {
    TableMeta tableMeta = tableDefinition.getTableMeta();
    tableDefinitionRepository.insert(tableMeta);
    tableDefinition.getColumnMetas().forEach(c -> {
      CommonColumnMeta common = c.getCommon();
      common.setTableMetaId(tableMeta.getId());

      tableDefinitionRepository.insert(common);
      DetailColumnMeta detail = c.getDetail();
      detail.setCommonColumnMetaId(common.getId());

      detail.accept(new DetailColumnVisitor<Integer>() {

        @Override
        public Integer visit(IntegerColumnMeta integerColumnMeta) {
          return tableDefinitionRepository.insert(integerColumnMeta);
        }

        @Override
        public Integer visit(TextColumnMeta textColumnMeta) {
          return tableDefinitionRepository.insert(textColumnMeta);
        }
      });
    });
  }
}
