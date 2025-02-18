package TA5;

public class T05_1 {

	public static void main(String[] args) {

		int A = 20, B = 20;

		if (A < B) {
			System.out.println(B + " es mayor que " + A);
		}
		// si A es menor que B manda mensaje indicandolo
		else if (B < A) {
			System.out.println(A + " es mayor que " + B);
		}
		// si no, comprueba si A es mayor que B y manda el mensaje
		// en caso positivo
		else if (A == B) {
			System.out.println(A + " es igual a " + B);
		}
		// si no, comprueba si son iguales para enviar el mensaje
		// indicandolo

	}

}
