package dpaulsoria;

import java.util.Scanner;

/**
 * Clase principal que contiene el método de inicio del programa.
 */
public class Main {

  /**
   * Punto de entrada principal del programa.
   *
   * @param args Los argumentos de línea de comandos pasados al programa.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese su destino");
    String destination = scanner.nextLine();
    System.out.println("Ingrese la cantidad de pasajeros");
    int numberTravelers = scanner.nextInt();
    System.out.println("Ingrese la duración del viaje");
    int duration = scanner.nextInt();
    System.out.println("destino: " + destination);
    Vacation vacation = new Vacation(destination, duration, numberTravelers);
    double total = vacation.calculateVacation();

    if (total == -1) {
      System.out.println("Number of Travelers are not allowed");
    } else {
      System.out.println("Total cost is: " + total);
    }
    
    scanner.close();
  }
}
