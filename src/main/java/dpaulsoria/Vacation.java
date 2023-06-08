package dpaulsoria;

/**
 * Clase que representa unas vacaciones.
 */
public class Vacation {
  private final double costoBase;
  private final String destino;
  private final double duracion;
  private final double cantidadViajeros;
  private final double odd;

  /**
   * Crea un objeto Vacation con el destino, duración y cantidad de viajeros especificados.
   *
   * @param destino          el destino del viaje.
   * @param duracion         la duración del viaje en días.
   * @param cantidadViajeros la cantidad de viajeros.
   * @param odd              el valor adicional para el costo.
   */
  public Vacation(String destino, double duracion, double cantidadViajeros, double odd) {
    this.costoBase = 1000;
    this.destino = destino;
    this.duracion = duracion;
    this.cantidadViajeros = cantidadViajeros;
    this.odd = odd;
  }

  /**
   * Calcula el costo total de las vacaciones.
   *
   * @return el costo total de las vacaciones, o -1 si el número de viajeros es mayor o igual a 80.
   */
  public double calcularCostoVacaciones() {
    if (cantidadViajeros < 80) {
      double totalConDestino = calcularCostoDestino(costoBase, destino);
      double tcv = calcularCostoViajeros(totalConDestino, cantidadViajeros);
      double totalConDuracion = calcularCostoDuracion(tcv, duracion, cantidadViajeros);
      double totalOdd = calcularCostoOdd(totalConDuracion, odd);
      return totalOdd;
    } else {
      return -1;
    }
  }

  /**
   * Calcula el costo adicional según el destino seleccionado.
   *
   * @param costoBase el costo base actual.
   * @param destino   el destino seleccionado.
   * @return el costo total con el adicional del destino.
   */
  private double calcularCostoDestino(double costoBase, String destino) {
    if ("París".equals(destino)) {
      return costoBase + 500;
    } else if ("Nueva York".equals(destino)) {
      return costoBase + 600;
    }
    return costoBase;
  }

  /**
   * Calcula el costo adicional según la cantidad de viajeros.
   *
   * @param costoBase        el costo base actual.
   * @param cantidadViajeros la cantidad de viajeros.
   * @return el costo total con el adicional de la cantidad de viajeros.
   */
  private double calcularCostoViajeros(double costoBase, double cantidadViajeros) {
    if (cantidadViajeros > 4 && duracion < 10) {
      return costoBase + costoBase * 0.1;
    } else if (cantidadViajeros > 20) {
      return costoBase + costoBase * 0.2;
    }
    return costoBase;
  }

  /**
   * Calcula el costo adicional según la duración del viaje.
   *
   * @param costoBase        el costo base actual.
   * @param duracion         la duración del viaje en días.
   * @param cantidadViajeros la cantidad de viajeros.
   * @return el costo total con el adicional de la duración del viaje.
   */
  private double calcularCostoDuracion(double costoBase, double duracion, double cantidadViajeros) {
    if (duracion < 7) {
      return costoBase + 200;
    } else if (duracion > 30 || cantidadViajeros == 2) {
      return costoBase - 200;
    }
    return costoBase;
  }

  /**
   * Calcula el costo adicional según el valor adicional especificado.
   *
   * @param costoBase el costo base actual.
   * @param odd       el valor adicional especificado.
   * @return el costo total con el adicional especificado.
   */
  private double calcularCostoOdd(double costoBase, double odd) {
    if (odd == 1) {
      return costoBase + 200;
    } else if (odd == 2) {
      return costoBase + 150;
    } else if (odd == 3) {
      return costoBase + 100;
    } else {
      return costoBase;
    }
  }
}
