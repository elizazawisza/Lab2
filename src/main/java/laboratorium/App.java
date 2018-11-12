package laboratorium;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Główna klasa odpowiedzialna za pobieranie danych do wystawienia faktury.
 */
public class App {
  public static void main(String[] args) {
    System.out.println("PROGRAM DO WYSTAWIANIA FAKTUR");
    boolean work = true;
    ArrayList<String> firms = new ArrayList<>();
    ArrayList<ArrayList<Invoice>> invoiceId = new ArrayList<>();
    int index;
    int number = 0;
    int option = 3;
    Scanner sc = new Scanner(System.in);
    while (work) {
      System.out.println("Jeśli chcesz wystawić fakturę wybierz 1, \n"
              + "jeśli chcesz wyświetlić fakturę wybierz 2, \n"
              + "jeśli chcesz zakończyć działanie programu wybierz 3\n");
      try {
        option = sc.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Wartość musi być liczba z zakresu 1-3");
        sc.next();
      }
      if (option == 3) {
        break;
      }
      switch (option) {
        case 1:
          Invoice in = new Invoice();
          if (firms.contains(in.name)) {
            index = firms.indexOf(in.name);
            invoiceId.add(new ArrayList<Invoice>());
            invoiceId.get(index).add(in);
          } else {
            firms.add(in.name);
            invoiceId.add(new ArrayList<Invoice>());
            invoiceId.get(invoiceId.size() - 1).add(in);
          }
          break;
        case 2:
          for (int i = 0; i < firms.size(); i++) {
            System.out.println(i + "\t" + firms.get(i));
          }
          System.out.println("Podaj numer firmy, dla której chcesz wyświetlić fakturę");
          try {
            number = sc.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("Wartość musi być liczba z zakresu 0-" + firms.size());
            sc.next();
          }
          Gson gson = new GsonBuilder().setPrettyPrinting().create();
          String invoice = gson.toJson(invoiceId.get(number));
          System.out.println(invoice);
          break;
        default:
      }
    }
  }

}