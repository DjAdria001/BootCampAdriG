package TA9_05;

public class Profesor {
	private String Nombre;
	private String Apellido;
	private Integer Edad;
	private String Sexo;
	private String Materia;
	private boolean Asistencia;
	
	public Profesor(String nombre, String apellido, Integer edad, String sexo, String Materia, boolean asistencia) {
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Edad = edad;
		this.Sexo = sexo;
		this.Materia = Materia;
		this.Asistencia = ConfirmarAsistencia();
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

	public String getMateria() {
		return Materia;
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

	public void setMateria(String materia) {
		this.Materia = materia;
	}

	public void setAsistencia(boolean asistencia) {
		this.Asistencia = asistencia;
	}
	
	public static boolean ConfirmarAsistencia() {
		boolean asistenciaValida = false;
		int random = (int) (Math.random() * 100) + 1;
		if (random > 20) {
			asistenciaValida = true;
		} else if (random <= 20) {
			asistenciaValida = false;
		}
		
		return asistenciaValida;
	}

}
