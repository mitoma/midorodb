package org.mitoma.midorodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mitoma.midorodb.domain.Identity;
import org.mitoma.midorodb.entity.TableDefinition;
import org.mitoma.midorodb.entity.TableMeta;
import org.mitoma.midorodb.entity.column.ColumnMeta;
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
    List<Identity<TableMeta>> tableMetaIds =
        tableMetas.stream().map(TableMeta::getId).collect(Collectors.toList());

    List<CommonColumnMeta> commonColumnMetas =
        tableDefinitionRepository.selectAllCommonColumnMetas(tableMetaIds);
    List<Identity<CommonColumnMeta>> commonColumnMetaIds =
        commonColumnMetas.stream().map(CommonColumnMeta::getId).collect(Collectors.toList());

    List<IntegerColumnMeta> integerColumnMetas =
        tableDefinitionRepository.selectAllIntegerColumnMetas(commonColumnMetaIds);
    List<TextColumnMeta> textColumnMetas =
        tableDefinitionRepository.selectAllTextColumnMetas(commonColumnMetaIds);

    List<DetailColumnMeta> detailColumnMetas = new ArrayList<>();
    detailColumnMetas.addAll(integerColumnMetas);
    detailColumnMetas.addAll(textColumnMetas);

    return tableMetas.stream().map(tableMeta -> {
      List<ColumnMeta> columnMetas = commonColumnMetas.stream()
          .filter(commonColumnMeta -> commonColumnMeta.getTableMetaId().equals(tableMeta.getId()))
          .map(c -> {
            DetailColumnMeta detailColumnMeta =
                detailColumnMetas.stream().filter(d -> d.getCommonColumnMetaId().equals(c.getId()))
                    .findFirst().orElseThrow(() -> new RuntimeException());
            return new ColumnMeta(c, detailColumnMeta);
          }).collect(Collectors.toList());
      return new TableDefinition(tableMeta, columnMetas);
    }).collect(Collectors.toList());
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
