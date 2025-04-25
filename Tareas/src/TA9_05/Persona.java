package TA9_05;

public abstract class Persona {
	protected String Nombre;
	protected String Apellido;
	protected Integer Edad;
	protected String Sexo;
	protected boolean Asistencia;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public Integer getEdad() {
		return Edad;
	}
	public void setEdad(Integer edad) {
		Edad = edad;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public boolean isAsistencia() {
		return Asistencia;
	}
	public void setAsistencia(boolean asistencia) {
		Asistencia = asistencia;
	}
	
	public abstract boolean ConfirmarAsistencia();
	
	
}
