package laboratorium;

import java.util.ArrayList;
import java.util.Scanner;

import static laboratorium.InputStream.integerInputStream;
import static laboratorium.InputStream.stringInputScanner;


public class Invoice {
  public String name;
  private String adress;
  private int nip;
  private ArrayList<Element> elements = new ArrayList<>();

  public Invoice() {
    name = this.getName();
    adress = this.getAdress();
    nip = this.getNip();
    elements = this.getArray();
  }

  private String getName() {
    System.out.println("Podaj nazwę firmy");
    String tmpName = stringInputScanner();
    return tmpName;
  }

  private String getAdress() {
    System.out.println("Podaj adres firmy");
    String tmpAdress = stringInputScanner();
    return tmpAdress;
  }

  private int getNip() {
    System.out.println("Podaj NIP firmy");
    int tmpNip = integerInputStream(stringInputScanner());
    return tmpNip;
  }

  private ArrayList<Element> getArray() {
    boolean addElements = true;
    Element element = new Element();
    this.elements.add(element);
    while (addElements) {
      System.out.println("Jeśli chcesz dodać więcej elementów wybierz n. "
              + "\nJeśli chcesz zakończyć wybierz q");
      Scanner scanner = new Scanner(System.in);
      String answer = scanner.next();
      if (answer.charAt(0) == 'n') {
        element = new Element();
        this.elements.add(element);
      } else {
        addElements = false;
      }
    }
    return elements;
  }
}
