package TA9_04;

public class Raices {
	int a;
	int b;
	int c;
	



	public static double getDiscriminante(int a, int b, int c, double discriminante) {
		discriminante = (b ^ b) - (4 * a * c);
		return discriminante;
	}

	public static boolean tieneRaices(double discriminante) {
		return discriminante >= 0;
	}

	public static boolean tieneRaiz(double discriminante) {
        return discriminante == 0;
    }

	public static double calcular(double discriminante, int a, int b) {
		double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
		double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
		return x1;
	}

	public static void obtenerRaices(double discriminante, int a, int b) {
		double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
		double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
		System.out.println("Las raíces son: " + x1 + " y " + x2);
	}

	public static void obtenerRaiz(double discriminante, int a, int b) {
		double x = (-b + Math.sqrt(discriminante)) / (2 * a);
		System.out.println("La raíz única es: " + x);
	}
}