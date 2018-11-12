package laboratorium;

import static laboratorium.InputStream.integerInputStream;
import static laboratorium.InputStream.stringInputScanner;

public class Firm {
  public String name;
  public String adress;
  public int nip;

  public Firm() {
    name = this.getName();
    adress = this.getAdress();
    nip = this.getNip();
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

}

