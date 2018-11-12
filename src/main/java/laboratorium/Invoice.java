package laboratorium;

import java.util.ArrayList;
import java.util.Scanner;


public class Invoice {
  public String name;
  public String adress;
  public int nip;
  private ArrayList<Element> elements = new ArrayList<>();
  private double totalAmount;

  public Invoice() {
    Firm f = new Firm();
    name = f.name;
    adress = f.adress;
    nip = f.nip;
    elements = this.getArray();
    totalAmount = this.getTotalAmount();
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

  private double getTotalAmount() {
    double total = 0;
    for (int i = 0; i < elements.size(); i++) {
      total += elements.get(i).amount;
    }
    return total;
  }
}
