
package TA6;

import javax.swing.JOptionPane;

public class T06_12 {

  public static void main(String[] args) {
    // Solicita al usuario el número de filas y columnas para la matriz
    String Filas = JOptionPane.showInputDialog("Inserte el numero de filas de la matriz: ");
    String Columnas = JOptionPane.showInputDialog("Inserte el numero de columnas de la matriz: ");
    String cifra = "";

    // Inicializa la matriz con las dimensiones especificadas por el usuario
    int array[][] = new int[Integer.parseInt(Filas)][Integer.parseInt(Columnas)];
    int i = 0;

    // Filtro para que el usuario introduzca un número mayor que 0 y menos de 10, 
    // es decir, un número de una cifra
    do {
      cifra = JOptionPane.showInputDialog("Inserte la cifra final deseada: ");
    } while (Integer.parseInt(cifra) < 0 || Integer.parseInt(cifra) > 9);

    // Llena la matriz con valores aleatorios
    while (i < Integer.parseInt(Filas)) {
      int j = 0;
      while (j < Integer.parseInt(Columnas)) {
        array[i][j] = ValorRand();
        j++;
      }
      i++;
    }

    // Copia los valores de la primera matriz a una segunda matriz
    int[][] array2 = new int[array.length][array[0].length];
    for (i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        array2[i][j] = array[i][j];
      }
      System.out.println();
    }

    // Muestra los valores de la primera matriz
    System.out.println("Array 1");
    Mostrar1(array, array.length, array[0].length, i);

    // Muestra los valores de la segunda matriz que cumplen con la condición de la cifra final
    System.out.println("Array 2");
    mostrar2(array, array.length, array[0].length, Integer.parseInt(cifra));
  }

  // Genera un número aleatorio entre 0 y 299
  public static int ValorRand() {
    int RandomNum = (int) (Math.random() * 300);
    return RandomNum;
  }

  // Muestra los valores de una matriz
  public static int Mostrar1(int[][] num, int Longitud, int Longitud2, int i2) {
    for (int i = 0; i < Longitud; i++) {
      for (int j = 0; j < Longitud2; j++) {
        System.out.print(num[i][j] + " ");
      }
      System.out.println();
    }
    return 0;
  }

  // Muestra los valores de una matriz que cumplen con la condición de la cifra final
  public static void mostrar2(int[][] num, int longitud, int longitud2, int cifra) {
    for (int i = 0; i < longitud; i++) {
      for (int j = 0; j < longitud2; j++) {
        if (num[i][j] % 10 == cifra) {
          System.out.println("El valor de num[" + i + "][" + j + "] es " + num[i][j]);
        } 
//        else {
//          System.out.println("no hay ningun " + cifra);
//        }
      }
    }
  }
}
