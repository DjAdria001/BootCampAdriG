package TA08;

public class T08_03_Electrodomestico {
	Double precioBase;
	String color;
	String consumoEnergetico;
	Double peso;

	public T08_03_Electrodomestico() {
		this.precioBase = 100.0;
		this.color = "blanco";
		this.consumoEnergetico = "F";
		this.peso = 5.0;
	}

	  public T08_03_Electrodomestico(double precioBase, String color, String consumoEnergetico, double peso) {
	        this.precioBase = precioBase;
	        this.color = color;
	        this.consumoEnergetico = consumoEnergetico;
	        this.peso = peso;
	    }

	public Double getPrecioBase() {
		return precioBase;
	}
}
