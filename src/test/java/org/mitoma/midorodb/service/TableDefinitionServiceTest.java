package org.mitoma.midorodb.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mitoma.midorodb.domain.Code;
import org.mitoma.midorodb.domain.Label;
import org.mitoma.midorodb.domain.Max;
import org.mitoma.midorodb.domain.Min;
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
    CommonColumnMeta common1 = new CommonColumnMeta();
    common1.setCode(new Code<>("colCode1"));
    common1.setLabel(new Label<>("colLabel1"));

    CommonColumnMeta common2 = new CommonColumnMeta();
    common2.setCode(new Code<>("colCode2"));
    common2.setLabel(new Label<>("colLabel2"));

    IntegerColumnMeta iMeta = new IntegerColumnMeta();
    iMeta.setMin(new Min<>(6L));
    iMeta.setMax(new Max<>(10L));

    columnMetas.add(new ColumnMeta(common1, iMeta));
    TextColumnMeta tMeta = new TextColumnMeta();
    tMeta.setMinLength(10);
    tMeta.setMaxLength(10000);
    tMeta.setTextPattern(".*");

    columnMetas.add(new ColumnMeta(common2, tMeta));

    TableMeta tableMeta = new TableMeta();
    tableMeta.setCode(new Code<>("tblCode"));
    tableMeta.setLabel(new Label<>("tblLabel"));


    TableDefinition tableDefinition = new TableDefinition(tableMeta, columnMetas);
    sut.create(tableDefinition);

    assertThat(sut.load().size(), is(currentSize + 1));
  }

}
