package TA9_01;

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
		System.out.println("-------------------------------------------------");
		T09_01_Lavadora lavadora = new T09_01_Lavadora();
		System.out.println("Lavadora por defecto:" + "\nPrecio base: " + lavadora.precioBase + "\nColor: "
				+ lavadora.color + "\nConsumo energetico: " + lavadora.consumoEnergetico + "\nPeso: " + lavadora.peso
				+ "\nCarga: " + lavadora.carga + "\nPrecio Final: "
				+ lavadora.precioFinal(lavadora.consumoEnergetico, lavadora.peso));
		System.out.println("-------------------------------------------------");
		T09_01_Lavadora lavadora1 = new T09_01_Lavadora(300.0, "gris", 'A', 70.0, 10.0);
		System.out.println("Lavadora 1:" + "\nPrecio base: " + lavadora1.precioBase + "\nColor: " + lavadora.color
				+ "\nConsumo energetico: " + lavadora.consumoEnergetico + "\nPeso: " + lavadora1.peso + "\nCarga: "
				+ lavadora.carga + "\nPrecio Final: "
				+ lavadora1.precioFinal(lavadora.consumoEnergetico, lavadora1.peso, lavadora.carga));
		System.out.println("-------------------------------------------------");
		T09_01_Lavadora lavadora2 = new T09_01_Lavadora(350.0, "azul", 'C', 90.0, 55.0);
		System.out.println("Lavadora 2:" + "\nPrecio base: " + lavadora2.precioBase + "\nColor: " + lavadora2.color
				+ "\nConsumo energetico: " + lavadora2.consumoEnergetico + "\nPeso: " + lavadora2.peso + "\nCarga: "
				+ lavadora2.carga + "\nPrecio Final: "
				+ lavadora2.precioFinal(lavadora2.consumoEnergetico, lavadora2.peso, lavadora2.carga));
		System.out.println("-------------------------------------------------");
		T09_01_Television television =new T09_01_Television();
		System.out.println("Television por defecto:"+ "\nPrecio base: " + television.precioBase + "\nColor: "
				+ television.color + "\nConsumo energetico: " + television.consumoEnergetico + "\nPeso: " + television.peso
				 +"\nResolucion:"+television.Resolucion+"\nSintonizador TDT:"+television.TDT +"\nPrecio Final: "
				+ television.precioFinal(television.consumoEnergetico, television.peso,television.Resolucion, television.TDT));
		System.out.println("-------------------------------------------------");
		T09_01_Television television1 =new T09_01_Television(220.0, "gris", 'B', 45.0, 25,true);
		System.out.println("Television 1:"+ "\nPrecio base: " + television1.precioBase + "\nColor: "
				+ television.color + "\nConsumo energetico: " + television.consumoEnergetico + "\nPeso: " + television1.peso
				 +"\nResolucion:"+television.Resolucion+"\nSintonizador TDT:"+television.TDT +"\nPrecio Final: "
				+ television1.precioFinal(television.consumoEnergetico, television1.peso,television.Resolucion, television.TDT));
		System.out.println("-------------------------------------------------");
		T09_01_Television television2 =new T09_01_Television(350.0, "azul", 'C', 90.0, 40,true);
		System.out.println("Television 2:"+ "\nPrecio base: " + television2.precioBase + "\nColor: "
				+ television2.color + "\nConsumo energetico: " + television2.consumoEnergetico + "\nPeso: " + television2.peso
				 +"\nResolucion:"+television2.Resolucion+"\nSintonizador TDT:"+television2.TDT +"\nPrecio Final: "
				+ television2.precioFinal(television2.consumoEnergetico, television2.peso,television2.Resolucion, television2.TDT));
		System.out.println("-------------------------------------------------");
				
		
	}

}

