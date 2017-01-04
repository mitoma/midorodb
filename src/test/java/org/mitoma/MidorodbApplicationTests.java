package org.mitoma;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mitoma.midorodb.MidorodbApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MidorodbApplication.class)
public class MidorodbApplicationTests {

  @Test
  public void contextLoads() {
    // dummy
    assertTrue(true);
  }

}
