import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in);
		
		System.out.println(" -- Bienvenido a JAVA 1.21 -- ");
		System.out.print("Introduce tu nombre:");
		
		String name = sc.nextLine();
		sc.close();
		
		System.out.println("Hola " + name. toUpperCase());


	}

}
