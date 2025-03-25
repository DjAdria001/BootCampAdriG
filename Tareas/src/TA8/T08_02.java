package TA8;
import java.util.Scanner;
public class T08_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T08_02_Password pass = new T08_02_Password();
		System.out.println("Inserte la longitud de la contraseña: ");
		Scanner scanner = new Scanner(System.in);
		int longitud = scanner.nextInt();
		pass.GenPass(longitud);
	
	}

}
