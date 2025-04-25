package TA09_01;

public class T09_01_Lavadora extends T09_01_Electrodomestico {

	protected Double carga;

	public T09_01_Lavadora() {

		this.carga = 5.0;
	}

	public T09_01_Lavadora(Double precioBase, String color, char consumoEnergetico, Double peso, Double carga) {
		this.precioBase = precioBase;
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso;
		this.carga = carga;
	}

	public Double getCarga(double carga) {
		return carga;
	}

	public Double precioFinal(char consumoEnergetico, Double peso, Double carga) {

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
		if (carga > 30) {
			precioBase += 50;
		} else if (carga <= 30) {
			precioBase += 0;
		}

		return precioBase;
	}

}
