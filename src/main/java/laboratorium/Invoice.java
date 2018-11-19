package laboratorium;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import static laboratorium.InputStream.integerInputStream;
import static laboratorium.InputStream.stringInputScanner;


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
    Element element = new Element();
    this.elements.add(element);
    while (true) {
      System.out.println("Jeśli chcesz dodać więcej elementów wybierz n. "
              + "\nJeśli chcesz zakończyć wybierz q");
      if (stringInputScanner().charAt(0) == 'n') {
        element = new Element();
        this.elements.add(element);
      } else {
        break;
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

  public void show(){
    System.out.println("\n\nNazwa firmy: \t" + name);
    System.out.println("Adres firmy: \t" + adress);
    System.out.println("Nip firmy: \t\t" + nip);
    System.out.println("\n");
    for(Element element : elements){
      System.out.println("Nazwa produktu: \t" + element.item);
      System.out.println("Cena jednostkowa: \t" + element.price);
      System.out.println("Ilość: \t\t\t\t" + element.quantity);
      System.out.println("Wartość podatku: \t" + element.tax);
      System.out.println("Wartość całkowita: \t" + element.amount+"\n");
    }
    System.out.println("\nWartość całkowita: \t " + totalAmount + "\n\n");
  }

}
