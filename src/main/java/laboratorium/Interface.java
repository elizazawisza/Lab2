package laboratorium;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static laboratorium.InputStream.integerInputStream;
import static laboratorium.InputStream.stringInputScanner;

public class Interface {
  public Interface() {
  }

  static void init() {
    ArrayList<Invoice> invoices = new ArrayList<>();
    int option = 3;
    String nazwa;
    while (true) {
      System.out.println("Jeśli chcesz wystawić fakturę wybierz 1, \n"
              + "jeśli chcesz wyświetlić fakturę wybierz 2, \n"
              + "jeśli chcesz zakończyć działanie programu wybierz 3\n");
      try {
        option = integerInputStream(stringInputScanner());
      } catch (InputMismatchException e) {
        System.out.println("Wartość musi być liczba z zakresu 1-3");
      }
      switch (option) {
        case 1:
          Invoice in = new Invoice();
          invoices.add(in);
          break;
        case 2:
          nazwa = stringInputScanner();
          for( Invoice invoice : invoices) {
              if(nazwa==invoice.name)
                invoice.show();
          }
          break;
        case 3:
            break;
        default:
      }
    }
  }
}
