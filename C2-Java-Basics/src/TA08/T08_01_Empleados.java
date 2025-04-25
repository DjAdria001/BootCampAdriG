package TA08;

public class T08_01_Empleados {
	
	String Nombre;
	String Apellidos;
	int Edad;
	String Sexo;
	String DNI;
	double Peso;
	double Altura;

	// Constructor por defecto
	public T08_01_Empleados() {
		this.Nombre = "";
		this.Apellidos = "";
		this.Edad = 0;
		this.Sexo = "H";
		this.Peso = 0.0;
		this.Altura = 0.0;
	}

	// Constructor con parámetros
	public T08_01_Empleados(String nombre, String apellidos, int edad, String sexo, String dni, double peso,
			double altura) {
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.Edad = edad;
		this.Sexo = sexo;
		this.DNI = dni;
		this.Peso = peso;
		this.Altura = altura;
	}
}
