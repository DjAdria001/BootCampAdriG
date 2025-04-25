package TA9_02;

public class Entregable{
	private boolean entregado;

	public Entregable() {
		this.entregado = false;
	}

	public Entregable(boolean entregado) {
		this.entregado = entregado;
	}

	public void entregar() {
		this.entregado = true;
	}

	public void devolver() {
		this.entregado = false;
	}

	public boolean isEntregado() {
		return entregado;
	}
	
	public void compareTo(Entregable otro) {
		if (this.entregado && otro.entregado) {
			System.out.println("Ambos objetos están entregados.");
		} else if (this.entregado) {
			System.out.println("Este objeto está entregado.");
		} else if (otro.entregado) {
			System.out.println("El otro objeto está entregado.");
		} else {
			System.out.println("Ninguno de los objetos está entregado.");
		}
	}
}
