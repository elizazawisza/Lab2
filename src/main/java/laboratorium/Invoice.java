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
    System.out.println(name);
    System.out.println(adress);
    System.out.println(nip);
    for(Element element : elements){
      System.out.println(element.item);
      System.out.println(element.price);
      System.out.println(element.quantity);
      System.out.println(element.tax);
      System.out.println(element.amount);
    }
    System.out.println(totalAmount);
  }

  public void save(){
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String invoice = gson.toJson();

  }
}
