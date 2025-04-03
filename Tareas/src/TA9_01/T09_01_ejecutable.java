
package TA9_01;

public class T09_01_ejecutable extends T09_01_Electrodomestico {
	public static void main(String[] args) {
		// Array de electrodomesticos(lavadoras y televisiones incluidas)
		T09_01_Electrodomestico[] electrodomesticos = new T09_01_Electrodomestico[10];

		// Objetos
		T09_01_Electrodomestico electrodomestico1 = new T09_01_Electrodomestico(200.0, "rojo", 'B', 53.0);
		T09_01_Electrodomestico electrodomestico2 = new T09_01_Electrodomestico(350.0, "azul", 'A', 83.0);
		T09_01_Electrodomestico electrodomestico3 = new T09_01_Electrodomestico(150.0, "blanco", 'D', 25.0);
		T09_01_Electrodomestico electrodomestico4 = new T09_01_Electrodomestico(300.0, "gris", 'C', 70.0);

		T09_01_Electrodomestico lavadora1 = new T09_01_Lavadora(300.0, "gris", 'A', 70.0, 10.0);
		T09_01_Electrodomestico lavadora2 = new T09_01_Lavadora(350.0, "azul", 'C', 90.0, 55.0);
		T09_01_Electrodomestico lavadora3 = new T09_01_Lavadora(150.0, "rojo", 'D', 75.0, 25.0);

		T09_01_Electrodomestico television1 = new T09_01_Television(220.0, "gris", 'B', 45.0, 25, true);
		T09_01_Electrodomestico television2 = new T09_01_Television(350.0, "azul", 'C', 90.0, 40, true);
		T09_01_Electrodomestico television3 = new T09_01_Television(150.0, "rojo", 'D', 75.0, 30, false);

		// Asignar objetos al array
		electrodomesticos[0] = electrodomestico1;
		electrodomesticos[1] = electrodomestico2;
		electrodomesticos[2] = electrodomestico3;
		electrodomesticos[3] = electrodomestico4;
		electrodomesticos[4] = lavadora1;
		electrodomesticos[5] = lavadora2;
		electrodomesticos[6] = lavadora3;
		electrodomesticos[7] = television1;
		electrodomesticos[8] = television2;
		electrodomesticos[9] = television3;

		// Totalizadores
		Double PrecioTotalElectrodomesticos = 0.0;
		Double PrecioTotalLavadoras = 0.0;
		Double PrecioTotalTelevisores = 0.0;
		// Calcular el precio total de cada tipo de electrodoméstico
		for (T09_01_Electrodomestico electrodomestico : electrodomesticos) {
			if (electrodomestico instanceof T09_01_Lavadora) {
				PrecioTotalLavadoras += electrodomestico.precioFinal(electrodomestico.consumoEnergetico,
						electrodomestico.peso);
			} else if (electrodomestico instanceof T09_01_Television) {
				PrecioTotalTelevisores += electrodomestico.precioFinal(electrodomestico.consumoEnergetico,
						electrodomestico.peso);
			}
			PrecioTotalElectrodomesticos += electrodomestico.precioFinal(electrodomestico.consumoEnergetico,
					electrodomestico.peso);
		}

		// Mostrar los resultados
		System.out.println("Precio total de electrodomésticos: " + PrecioTotalElectrodomesticos);
		System.out.println("Precio total de lavadoras: " + PrecioTotalLavadoras);
		System.out.println("Precio total de televisores: " + PrecioTotalTelevisores);
	}
	public Double precioFinalElectrodomestico(char consumoEnergetico, Double peso) {
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

	public Double precioFinalLavadora(char consumoEnergetico, Double peso, Double carga) {
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

	public Double precioFinalTelevision(char consumoEnergetico, Double peso, double Resolucion, boolean TDT) {
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
