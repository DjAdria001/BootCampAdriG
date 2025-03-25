package TA8;

public class T08_01_Empleados {

	String Nombre;
	String Apellidos;
	Integer Edad;
	String Sexo;
	String DNI;
	Double Peso;
	Double Altura;

	public T08_01_Empleados() {
		this.Nombre = "";
		this.Apellidos = "";
		this.Edad = 0;
		this.Sexo = "H";
		this.Peso = 0.0;
		this.Altura = 0.0;
	}

	public T08_01_Empleados(String nombre, String apellidos, Integer edad, String sexo, String dni, Double peso,
			Double altura) {
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.Edad = edad;
		this.Sexo = sexo;
		this.DNI = dni;
		this.Peso = peso;
		this.Altura = altura;
	}

}
