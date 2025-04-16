
package TA9_04;

public class Raices {
	private double a;
	private double b;
	private double c;

	// Constructor
	public Raices(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	// Getters
	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}

	public double getC() {
		return c;
	}

	// Método para calcular el discriminante
	public double getDiscriminante() {
		return (Math.pow(b, 2)) - (4 * a * c);
	}

	// Método para verificar si tiene dos soluciones
	public boolean tieneRaices() {
		
		return getDiscriminante() > 0;
	}

	// Método para verificar si tiene una única solución
	public boolean tieneRaiz() {
		return getDiscriminante() == 0;
	}

	// Método para calcular y mostrar las soluciones
	public void calcular() {
		double discriminante = getDiscriminante();
		if (discriminante < 0) {
			System.out.println("No existen soluciones reales.");
		} else if (tieneRaices()) {
			obtenerRaices();
		} else if (tieneRaiz()) {
			obtenerRaiz();
		}
	}

	// Método para obtener e imprimir las dos soluciones
	public void obtenerRaices() {
		double discriminante = Math.sqrt(getDiscriminante());
		double solucion1 = (-b + discriminante) / (2 * a);
		double solucion2 = (-b - discriminante) / (2 * a);
		System.out.println("Las dos soluciones son: " + solucion1 + " y " + solucion2);
	}

	// Método para obtener e imprimir la única solución
	public void obtenerRaiz() {
		double solucion = -b / (2 * a);
		System.out.println("La única solución es: " + solucion);
	}
}
