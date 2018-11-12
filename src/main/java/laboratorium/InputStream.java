package laboratorium;

import java.util.Scanner;

public class InputStream {
  private static Scanner sc = new Scanner(System.in);

  public static String stringInputScanner() {
    return sc.nextLine();
  }

  public static int integerInputStream(String input) {
    boolean loop = true;
    int data = 0;
    while (loop) {
      try {
        data = Integer.parseInt(input);
        if (data < 0) {
          message();
          input = stringInputScanner();
        } else {
          loop = false;
        }
      } catch (NumberFormatException e2) {
        message();
        input = stringInputScanner();
      }
    }
    return data;
  }

  public static void message() {
    System.out.print("Wartość musi być naturalna liczba dodatnia\n");
  }
}
