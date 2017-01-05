package org.mitoma.midorodb.controller;

import java.util.List;

import org.mitoma.midorodb.domain.Code;
import org.mitoma.midorodb.domain.Label;
import org.mitoma.midorodb.entity.Table;
import org.mitoma.midorodb.entity.TableDefinition;
import org.mitoma.midorodb.service.TableDefinitionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TableController {

  private final TableDefinitionService tableDefinitionService;

  @GetMapping(path = "/tables")
  public List<TableDefinition> index() {
    return tableDefinitionService.load();
  }

  @PutMapping(path = "/tables")
  public Table addTable() {
    Table table = new Table();
    table.setLabel(new Label<Table>("テスト"));
    table.setName(new Code<Table>("太郎"));

    return table;
  }

}
