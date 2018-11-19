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
    Interface.init();
  }

}