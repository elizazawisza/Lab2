package laboratorium;

import static laboratorium.InputStream.integerInputStream;
import static laboratorium.InputStream.stringInputScanner;

public class Element {
  public String item;
  public int price;
  public int tax;
  public int quantity;
  public double amount;

  public Element() {
    item = setItem();
    price = setPrice();
    quantity = setQuanity();
    tax = setTax();
    amount = setAmount(price, quantity, tax);
  }

  public String setItem() {
    System.out.println("Podaj pozycję faktury");
    return stringInputScanner();
  }

  public int setPrice() {
    System.out.println("Podaj cenę jednostkową");
    return integerInputStream(stringInputScanner());
  }

  public int setQuanity() {
    System.out.println("Podaj ilość");
    return integerInputStream(stringInputScanner());

  }

  public int setTax() {
    System.out.println("Podaj wartość podatku");
    return integerInputStream(stringInputScanner());

  }

  public static double setAmount(int price, int quantity, int tax) {
    return (double)Math.round((price * quantity) * (1 + tax * 0.01) * 100) / 100;
  }

}
