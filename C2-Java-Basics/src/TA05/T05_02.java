package TA05;

import java.util.Scanner;

public class T05_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Escribe tu nombre:");
		String name = sc.nextLine();
		sc.close();

		System.out.println("Bienvenido " + name);

	}

}
