package Lab2;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ElementTest {
  @Test
  public void checkSetAmount(){
    assertEquals(Element.setAmount(100, 10, 23), 1230.0);
  }
}
