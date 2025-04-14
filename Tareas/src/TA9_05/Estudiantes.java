package TA9_05;

public class Estudiantes {
	private String Nombre;
	private String Apellido;
	private Integer Edad;
	private String Sexo;
	private Double Calificacion;
	private String Asistencia;

	
	public Estudiantes(String nombre, String apellido, Integer edad, String sexo, Double calificacion) {
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Edad = edad;
		this.Sexo = sexo;
		this.Calificacion = calificacion;
	}
	public String ConfirmarAsistencia() {
		String asistenciaValida = null;
		int random = (int) (Math.random() * 100) + 1;
		if (random > 50) {
			asistenciaValida = "Asitencia Confirmada";
		} else if (random <= 50) {
			asistenciaValida = "Asistencia No Confirmada";
		}
		
		return asistenciaValida;
	}
	public double Calificacion(double calificacion) {
		if (calificacion < 0 || calificacion > 10) {
			System.out.println("Calificacion no valida");
			return -1;
		}
		return calificacion;
	}
}
