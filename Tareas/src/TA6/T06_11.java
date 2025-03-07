package TA6;

import javax.swing.JOptionPane;

public class T06_11 {

 public static void main(String[] args) {
  // Solicita al usuario el número de filas y columnas para la matriz
  String Filas = JOptionPane.showInputDialog("Inserte el numero de filas de la matriz: ");
  String Columnas = JOptionPane.showInputDialog("Inserte el numero de columnas de la matriz: ");
  int Largo = Integer.parseInt(Filas);
  int Alto = Integer.parseInt(Columnas);

  // Inicializa dos matrices con las dimensiones especificadas
  int array[][] = new int[Largo][Alto];
  int array2[][] = new int[Largo][Alto];

  // Llena la primera matriz con valores aleatorios
  int i = 0;
  while (i < Largo) {
   int j = 0;
   while (j < Alto) {
    array[i][j] = ValorRand();
    j++;
   }
   i++;
  }

  // Copia los valores de la primera matriz a la segunda matriz
  for (i = 0; i < Largo; i++) {
   for (int j = 0; j < Alto; j++) {
    array2[i][j] = array[i][j];
   }
  }

  // Muestra la primera matriz
  System.out.println("Array 1");
  Mostrar(array, Largo, Alto);

  // Muestra la segunda matriz
  System.out.println("Array 2");
  Mostrar(array2, Largo, Alto);

  // Inicializa una tercera matriz para almacenar el resultado de la multiplicación
  int[][] array3 = new int[Largo][Alto];
  System.out.println("Array 3");

  // Multiplica las dos primeras matrices y almacena el resultado en la tercera matriz
  array3 = multipliArrays(array, array2, array3, Largo, Alto);
 }

 // Genera un número aleatorio entre 0 y 9
 public static int ValorRand() {
  int RandomNum = (int) (Math.random() * 10);
  return RandomNum;
 }

 // Muestra el contenido de una matriz
 public static int Mostrar(int[][] num, int Longitud, int Altitud) {
  for (int i = 0; i < Longitud; i++) {
   for (int j = 0; j < Altitud; j++) {
    System.out.print(num[i][j] + " ");
   }
   System.out.println();
  }
  return 0;
 }

 // Multiplica dos matrices y almacena el resultado en una tercera matriz
 public static int[][] multipliArrays(int Array1[][], int Array2[][], int Array3[][], int Filas, int Columnas) {
  for (int i = 0; i < Filas; i++) {
   for (int j = 0; j < Columnas; j++) {
    Array3[i][j] = Array1[i][j] * Array2[i][j];
    System.out.print(Array3[i][j] + " ");
   }
   System.out.println();
  }
  return Array3;
 }
}