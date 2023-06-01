package dpaulsoria;

/**
 * Clase que representa unas vacaciones.
 */
public class Vacation {
  private double base;
  private String destination;
  private double duration;
  private double numberTravelers;

  /**
   * Crea un objeto Vacation con el destino, duración y cantidad de viajeros especificados.
   *
   * @param destination     el destino del viaje.
   * @param duration        la duración del viaje en días.
   * @param numberTravelers la cantidad de viajeros.
   */
  public Vacation(String destination, double duration, double numberTravelers) {
    this.base = 1000;
    this.destination = destination;
    this.duration = duration;
    this.numberTravelers = numberTravelers;
  }

  /**
   * Calcula el costo total de las vacaciones.
   *
   * @return el costo total de las vacaciones, o -1 si el número de viajeros es mayor o igual a 80.
   */
  public double calculateVacation() {
    if (numberTravelers < 80) {
      double totalWithDestination = calculateDestination(base, destination);
      double totalWithNumTravelers = calcNumTrav(totalWithDestination, numberTravelers);
      double totalWithDuration = calcDur(totalWithNumTravelers, duration, numberTravelers);
      return totalWithDuration;
    } else {
      return -1;
    }
  }

  /**
   * Calcula el costo adicional según el destino seleccionado.
   *
   * @param base        el costo base actual.
   * @param destination el destino seleccionado.
   * @return el costo total con el adicional del destino.
   */
  private double calculateDestination(double base, String destination) {
    if (destination.equals("Paris")) {
      return base + 500;
    } else if (destination.equals("New York City")) {
      return base + 600;
    }
    return base;
  }

  /**
   * Calcula el costo adicional según la cantidad de viajeros.
   *
   * @param base           el costo base actual.
   * @param numberTravelers la cantidad de viajeros.
   * @return el costo total con el adicional de la cantidad de viajeros.
   */
  private double calcNumTrav(double base, double numberTravelers) {
    if (numberTravelers > 4 && duration < 10) {
      return (base + base * 0.1);
    } else if (numberTravelers > 20) {
      return (base + base * 0.2);
    }
    return base;
  }

  /**
   * Calcula el costo adicional según la duración del viaje.
   *
   * @param base           el costo base actual.
   * @param duration       la duración del viaje en días.
   * @param numberTravelers la cantidad de viajeros.
   * @return el costo total con el adicional de la duración del viaje.
   */
  private double calcDur(double base, double duration, double numberTravelers) {
    if (duration < 7) {
      return (base + 200);
    } else if (duration > 30 || numberTravelers == 2) {
      return (base - 200);
    }
    return base;
  }

  public Double getBase() {
    return base;
  }

  public void setBase(Double base) {
    this.base = base;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public Double getDuration() {
    return duration;
  }

  public void setDuration(Double duration) {
    this.duration = duration;
  }

  public Double getNumberTravelers() {
    return numberTravelers;
  }

  public void setNumberTravelers(Double numberTravelers) {
    this.numberTravelers = numberTravelers;
  }
}
