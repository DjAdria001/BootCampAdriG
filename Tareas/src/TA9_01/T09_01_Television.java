package TA9_01;

public class T09_01_Television extends T09_01_Electrodomestico {
	protected double Resolucion;
	protected boolean TDT;

	public T09_01_Television() {
		this.Resolucion = 20;
		this.TDT = false;
	}

	public T09_01_Television(Double precioBase, String color, char consumoEnergetico, Double peso, double Resolucion,
			boolean TDT) {
		this.precioBase = precioBase;
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso;
		this.Resolucion = Resolucion;
		this.TDT = TDT;
	}

	public Double precioFinal(char consumoEnergetico, Double peso, double Resolucion, boolean TDT) {

		switch (consumoEnergetico) {
		case 'A':
			precioBase += 100;
			break;
		case 'B':
			precioBase += 80;
			break;
		case 'C':
			precioBase += 60;
			break;
		case 'D':
			precioBase += 50;
			break;
		case 'E':
			precioBase += 30;
			break;
		case 'F':
			precioBase += 10;
			break;
		}
		if (peso < 19) {
			precioBase += 10;
		} else if (peso >= 19 && peso < 49) {
			precioBase += 50;
		} else if (peso >= 49 && peso < 79) {
			precioBase += 80;
		} else if (peso >= 79) {
			precioBase += 100;
		}
		if (Resolucion > 40) {
			precioBase += precioBase * 0.3;
		} else if (Resolucion <= 30) {
			precioBase += 0;
		}
		if (TDT == true) {
			precioBase += 50;
		}

		return precioBase;
	}
}
