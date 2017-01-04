package org.mitoma.midorodb.controller;

import java.util.List;

import org.mitoma.midorodb.domain.Code;
import org.mitoma.midorodb.domain.Label;
import org.mitoma.midorodb.entity.Table;
import org.mitoma.midorodb.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableController {

  @Autowired
  private TableRepository tableRepository;

  @GetMapping(path = "/tables")
  public List<Table> index() {
    return tableRepository.selectAll();
  }

  @PutMapping(path = "/tables")
  public Table addTable() {
    Table table = new Table();
    table.setLabel(new Label<Table>("テスト"));
    table.setName(new Code<Table>("太郎"));

    tableRepository.insert(table);
    return table;
  }

}
