package TA9_05;

public class Estudiantes extends Persona {

	private Double Calificacion;
	protected boolean Asistencia;

	public Estudiantes(String nombre, String apellido, Integer edad, String sexo, Double calificacion,
			boolean asistencia) {
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Edad = edad;
		this.Sexo = sexo;
		this.Calificacion = calificacion;
		this.Asistencia = ConfirmarAsistencia();

	}

	public Double getCalificacion() {
		return Calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.Calificacion = calificacion;
	}

	public boolean getAsistencia() {
		return Asistencia;
	}

	public void setAsistencia(boolean asistencia) {
		this.Asistencia = asistencia;
	}

	public static boolean ConfirmarAsistencia() {
		boolean asistenciaValida = false;
		int random = (int) (Math.random() * 100) + 1;
		if (random > 50) {
			asistenciaValida = true;
		} else if (random <= 50) {
			asistenciaValida = false;
		}

		return asistenciaValida;
	}

//	public static Integer ContarPresentes(List<Estudiantes> alumnos) {
//		int contador = 0;
//		for (Estudiantes estudiante : alumnos) {
//			if (estudiante.getAsistencia()) {
//				contador++;
//			}
//		}
//		return contador;
//	}

	public double Calificacion(double calificacion) {
		if (calificacion < 0 || calificacion > 10) {
			System.out.println("Calificacion no valida");
			return -1;
		}
		return calificacion;
	}
}
