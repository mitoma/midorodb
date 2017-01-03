package org.mitoma.midorodb.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mitoma.midorodb.entity.TableDefinition;
import org.mitoma.midorodb.entity.TableMeta;
import org.mitoma.midorodb.entity.column.ColumnMeta;
import org.mitoma.midorodb.entity.column.CommonColumnMeta;
import org.mitoma.midorodb.entity.column.IntegerColumnMeta;
import org.mitoma.midorodb.entity.column.TextColumnMeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableDefinitionServiceTest {

  @Autowired
  TableDefinitionService sut;

  @Test
  public void testLoad() {
    sut.load();


  }

  @Test
  public void testCreate() {
    int currentSize = sut.load().size();

    List<ColumnMeta> columnMetas = new ArrayList<>();
    columnMetas.add(new ColumnMeta(new CommonColumnMeta(), new IntegerColumnMeta()));
    columnMetas.add(new ColumnMeta(new CommonColumnMeta(), new TextColumnMeta()));

    TableDefinition tableDefinition = new TableDefinition(new TableMeta(), columnMetas);
    sut.create(tableDefinition);

    assertThat(sut.load().size(), is(currentSize + 1));
  }

}
