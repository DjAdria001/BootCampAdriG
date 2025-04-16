package TA9_05;

public class Estudiantes {
	private String Nombre;
	private String Apellido;
	private Integer Edad;
	private String Sexo;
	private Double Calificacion;
	private boolean Asistencia;

	
	public Estudiantes(String nombre, String apellido, Integer edad, String sexo, Double calificacion, boolean asistencia) {
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Edad = edad;
		this.Sexo = sexo;
		this.Calificacion = calificacion;

	}
	public String getNombre() {
		return Nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public Integer getEdad() {
		return Edad;
	}

	public String getSexo() {
		return Sexo;
	}

	public Double getCalificacion() {
		return Calificacion;
	}

	public boolean getAsistencia() {
		return Asistencia;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.Apellido = apellido;
	}

	public void setEdad(Integer edad) {
		this.Edad = edad;
	}

	public void setSexo(String sexo) {
		this.Sexo = sexo;
	}

	public void setMateria(double calificacion) {
		this.Calificacion = calificacion;
	}

	public void setAsistencia(boolean asistencia) {
		this.Asistencia = ConfirmarAsistencia();
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
	public double Calificacion(double calificacion) {
		if (calificacion < 0 || calificacion > 10) {
			System.out.println("Calificacion no valida");
			return -1;
		}
		return calificacion;
	}
}
