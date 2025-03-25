package TA8;

public class T08_01 {
	public static void main(String[] args) {

		T08_01_Empleados ArrayPersonas[] = new T08_01_Empleados[6];

		ArrayPersonas[0] = new T08_01_Empleados("Juan", "Pérez", 25, "H", "12345678A", 70.0, 1.75);
		ArrayPersonas[1] = new T08_01_Empleados("Ana", "García", 30, "M", "87654321B", 60.0, 1.65);
	}
}
//		System.out.println("Nombre: " + ArrayPersonas[0].Nombre + ", Apellidos: " + ArrayPersonas[0].Apellidos
//				+ ", Edad: " + ArrayPersonas[0].Edad + ", Sexo: " + ArrayPersonas[0].Sexo + ", DNI: "
//				+ ArrayPersonas[0].DNI + ", Peso: " + ArrayPersonas[0].Peso + ", Altura: " + ArrayPersonas[0].Altura);
//		System.out.println("Nombre: " + ArrayPersonas[1].Nombre + ", Apellidos: " + ArrayPersonas[1].Apellidos
//				+ ", Edad: " + ArrayPersonas[1].Edad + ", Sexo: " + ArrayPersonas[1].Sexo + ", DNI: "
//				+ ArrayPersonas[1].DNI + ", Peso: " + ArrayPersonas[1].Peso + ", Altura: " + ArrayPersonas[1].Altura);