package TA9;

public class T09_01_Electrodomestico {
	protected Double precioBase;
	protected String color;
	protected char consumoEnergetico;
	protected Double peso;

	public T09_01_Electrodomestico() {
		this.precioBase = 100.0;
		this.color = "blanco";
		this.consumoEnergetico = 'F';
		this.peso = 5.0;
	}

	public T09_01_Electrodomestico(Double precioBase, String color, char consumoEnergetico, Double peso) {
		this.precioBase = precioBase;
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso;
	}
	

	public String comprobarColor(String color) {
		boolean colorValido = false;
		do{
			color.toLowerCase();
			switch (color) {
		case "blanco":
			colorValido = true;
			return "blanco";
		case "negro":
			colorValido = true;
			return "negro";
		case "rojo":
			colorValido = true;
			return "rojo";
		case "azul":
			colorValido = true;
			return "azul";
		case "gris":
			colorValido = true;
			return "gris";
		default:
			System.out.println("Color no valido");
			break;
		}}while(!colorValido);
		return color;

	}

	public char comprobarConsumoEnergetico(char letra) {
		
		do {
			switch (letra) {
			case 'A', 'a':
				return 'A';
			case 'B', 'b':
				return 'B';
			case 'C', 'c':
				return 'C';
			case 'D','d':
				return 'D';
			case 'E','e':
				return 'E';
			case 'F','f':
				return 'F';
			default:
				System.out.println("Valor no valido");
			}
		} while (letra != 'A' || letra != 'B' || letra != 'C' || letra != 'D' || letra != 'E' || letra != 'F');
		return letra;

	}

	public Double precioFinal(char consumoEnergetico, Double peso) {
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
		return precioBase;
	}
}