package TA08;

import java.util.Scanner;

public class T08_03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T08_03_Electrodomestico electrodomestico = new T08_03_Electrodomestico();
		System.out.println("Electrodomestico por defecto:" + "\nPrecio base: " + electrodomestico.getPrecioBase()
				+ "\nColor: " + electrodomestico.color + "\nConsumo energetico: " + electrodomestico.consumoEnergetico
				+ "\nPeso: " + electrodomestico.peso);
		
		System.out.println("Introduce el precio base:");
		Double precioBase1 = scanner.nextDouble();
		System.out.println("Introduce el peso:");
		Double peso1 = scanner.nextDouble();
		
		T08_03_Electrodomestico electrodomestico1 = new T08_03_Electrodomestico(precioBase1, electrodomestico.color,
				electrodomestico.consumoEnergetico, peso1);
		System.out.println("Electrodomestico 1:" + "\nPrecio base: " + electrodomestico1.getPrecioBase() + "\nColor: "
				+ electrodomestico1.color + "\nConsumo energetico: " + electrodomestico1.consumoEnergetico + "\nPeso: "
				+ electrodomestico1.peso);

		System.out.println("Introduce el precio base:");
		Double precioBase = scanner.nextDouble();

		System.out.println("Introduce el color:");
		scanner.nextLine();
		String color = scanner.nextLine();
		color = ColorTrue(color.toLowerCase());

		System.out.println("Introduce el consumo energetico:");
		String consumoEnergetico = scanner.nextLine();
		consumoEnergetico = ConsumoTrue(consumoEnergetico.toUpperCase());

		System.out.println("Introduce el peso:");
		Double peso = scanner.nextDouble();

		T08_03_Electrodomestico electrodomestico2 = new T08_03_Electrodomestico(precioBase, color, consumoEnergetico,
				peso);
		System.out.println("");
		System.out.println("Electrodomestico 2" + "\nPrecio base: " + electrodomestico2.getPrecioBase()
				+ "\nColor: " + electrodomestico2.color + "\nConsumo energetico: " + electrodomestico2.consumoEnergetico
				+ "\nPeso: " + electrodomestico2.peso);

		scanner.close();

	}

	public static String ColorTrue(String color) {
		boolean colorValido = false;
		do {
			switch (color) {
			case "blanco":
				return color;
			case "negro":
				return color;
			case "rojo":
				return color;
			case "azul":
				return color;
			case "gris":
				return color;
			default:
				System.out.println("Color no valido. Introduce un color valido:");
				Scanner scanner = new Scanner(System.in);
				color = scanner.nextLine().toLowerCase();
				break;
			}
		} while (!colorValido);
		return color;
	}

	public static String ConsumoTrue(String consumo) {
		boolean consumoValido = false;
		do {
			switch (consumo) {
			case "A":
				return consumo;
			case "B":
				return consumo;
			case "C":
				return consumo;
			case "D":
				return consumo;
			case "E":
				return consumo;
			case "F":
				return consumo;
			default:
				System.out.println("Consumo no valido. Introduce un consumo valido:");
				Scanner scanner = new Scanner(System.in);
				consumo = scanner.nextLine().toUpperCase();
				break;
			}
		} while (!consumoValido);
		return consumo;
	}

}
