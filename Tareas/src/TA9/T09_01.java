package TA9;

public class T09_01 {

	public static void main(String[] args) {
		T09_01_Electrodomestico electrodomestico = new T09_01_Electrodomestico();
		System.out.println("Electrodomestico por defecto:" + "\nPrecio base: " + electrodomestico.precioBase
				+ "\nColor: " + electrodomestico.color + "\nConsumo energetico: " + electrodomestico.consumoEnergetico
				+ "\nPeso: " + electrodomestico.peso + "\nPrecio Final: "
				+ electrodomestico.precioFinal(electrodomestico.consumoEnergetico, electrodomestico.peso));
		System.out.println("-------------------------------------------------");
		T09_01_Electrodomestico electrodomestico1 = new T09_01_Electrodomestico(200.0, "rojo", 'B', 53.0);
		System.out.println("Electrodomestico 1:" + "\nPrecio base: " + electrodomestico1.precioBase + "\nColor: "
				+ electrodomestico.color + "\nConsumo energetico: " + electrodomestico.consumoEnergetico + "\nPeso: "
				+ electrodomestico1.peso + "\nPrecio Final: "
				+ electrodomestico1.precioFinal(electrodomestico.consumoEnergetico, electrodomestico1.peso));
		System.out.println("-------------------------------------------------");
		T09_01_Electrodomestico electrodomestico2 = new T09_01_Electrodomestico(350.0, "azul", 'A', 83.0);
		System.out.println("Electrodomestico 2:" + "\nPrecio base: " + electrodomestico2.precioBase + "\nColor: "
				+ electrodomestico2.color + "\nConsumo energetico: " + electrodomestico2.consumoEnergetico + "\nPeso: "
				+ electrodomestico2.peso + "\nPrecio Final: "
				+ electrodomestico2.precioFinal(electrodomestico2.consumoEnergetico, electrodomestico2.peso));
	}

}
