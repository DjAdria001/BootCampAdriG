package TA4;

public class T04_5 {

	public static void main(String[] args) {
		int A=5, B=10, C=15, D=20;
		int B1=B; //Esta b guarda el valor para prevenir que el resultado de D=B no sea D=C
		B=C;
		C=A;
		A=D;
		D=B1;
		System.out.println("A es: "+ A);
		System.out.println("B es: "+ B);
		System.out.println("C es: "+ C);
		System.out.println("D es: "+ D);
	}

}
