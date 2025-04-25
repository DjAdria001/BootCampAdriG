package TA5;

public class T05_09 {

	public static void main(String[] args) {
		System.out.println("Numeros divisibles entre 2: ");
		int num = 1;
		while ((num <= 100)) {
			if ((num % 2) == 0) {
				System.out.print(num + " ");
				num++;
			} else {
				num++;
			}

		}
		System.out.println(" ");
		System.out.println("Numeros divisibles entre 3: ");
		int num2 = 1;
		while ((num2 <= 100)) {
			if ((num2 % 3) == 0) {
				System.out.print(num2 + " ");
				num2++;
			} else {
				num2++;
			}
		}

	}

}
