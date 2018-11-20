package laboratorium;

import static laboratorium.InputStream.integerInputStream;
import static laboratorium.InputStream.stringInputScanner;

import java.util.ArrayList;

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
      option = integerInputStream(stringInputScanner());
      switch (option) {
        case 1:
          Invoice in = new Invoice();
          invoices.add(in);
          break;
        case 2:
          System.out.println("Podaj nazwę firmy, dla której chcesz wyświetlić fakturę");
          nazwa = stringInputScanner();
          for (Invoice invoice : invoices) {
            if (nazwa.equals(invoice.name)) {
              invoice.show();
            }
          }
          break;
        case 3:
          break;
        default:
      }
    }
  }
}
