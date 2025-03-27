package TA8;

public class T08_01 {
	public static void main(String[] args) {

		T08_01_Empleados InfoEmpleados[] = new T08_01_Empleados[6];

        // Crear una instancia con valores por defecto
        InfoEmpleados[0] = new T08_01_Empleados();
		InfoEmpleados[1] = new T08_01_Empleados("Ana", "García", 30, "M", "12345678A", 50.0, 1.65);
		InfoEmpleados[2] = new T08_01_Empleados("Pepe", "Viyuela", 61, "H", "87654321B", 60.0, 1.75);
        // Mostrar los valores por defecto
        System.out.println("Nombre: " + InfoEmpleados[0].Nombre + ", Apellidos: " + InfoEmpleados[0].Apellidos
                + ", Edad: " + InfoEmpleados[0].Edad + ", Sexo: " + InfoEmpleados[0].Sexo + ", DNI: "
                + InfoEmpleados[0].DNI + ", Peso: " + InfoEmpleados[0].Peso + ", Altura: " + InfoEmpleados[0].Altura);

        // Crear y mostrar otra instancia con valores específicos
       
        System.out.println("Nombre: " + InfoEmpleados[1].Nombre + ", Apellidos: " + InfoEmpleados[1].Apellidos
                + ", Edad: " + InfoEmpleados[1].Edad + ", Sexo: " + InfoEmpleados[1].Sexo + ", DNI: "
                + InfoEmpleados[0].DNI + ", Peso: " + InfoEmpleados[0].Peso + ", Altura: " + InfoEmpleados[0].Altura);
        System.out.println("Nombre: " + InfoEmpleados[2].Nombre + ", Apellidos: " + InfoEmpleados[2].Apellidos
                + ", Edad: " + InfoEmpleados[2].Edad + ", Sexo: " + InfoEmpleados[2].Sexo + ", DNI: "
                + InfoEmpleados[2].DNI + ", Peso: " + InfoEmpleados[2].Peso + ", Altura: " + InfoEmpleados[2].Altura);
    }
}
