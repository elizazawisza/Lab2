package laboratorium;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;


public class InputStreamTest {

  @Test
  public void invalidIntegerInput() {
    String data = "Komputer"+"\n-284"+"\n2"+"\nsadksakjd"+"\n17" +"\n4";
    System.setIn(new ByteArrayInputStream(data.getBytes()));
    OutputStream output = new ByteArrayOutputStream();
    PrintStream print = new PrintStream(output);
    System.setOut(print);
    new Element();
    assertTrue(((ByteArrayOutputStream) output).toString().contains("Wartość musi być naturalna liczba dodatnia\n"));
  }

}
