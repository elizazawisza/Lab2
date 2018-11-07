package Lab2;

import java.util.ArrayList;
import java.util.Scanner;

import static Lab2.InputStream.integerInputStream;
import static Lab2.InputStream.stringInputScanner;

public class Invoice {
  public String name;
  private String adress;
  private int nip;
  private ArrayList<Element> elements = new ArrayList<>();
  private double totalAmount;

  public Invoice() {
    name = this.getName();
    adress = this.getAdress();
    nip = this.getNip();
    elements = this.getArray();
    totalAmount = this.getTotalAmount();
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

  private double getTotalAmount(){
    double total = 0;
    for(int i = 0; i < elements.size(); i++){
      total+=elements.get(i).amount;
    }
    return total;
  }
}
