package TA9_05;

public class Profesor {
	private String Nombre;
	private String Apellido;
	private Integer Edad;
	private String Sexo;
	private String Materia;
	private String Asistencia;
	
	public Profesor(String nombre, String apellido, Integer edad, String sexo, String Materia) {
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Edad = edad;
		this.Sexo = sexo;
		this.Materia = Materia;
	}

	public String ConfirmarAsistencia() {
		String asistenciaValida = null;
		int random = (int) (Math.random() * 100) + 1;
		if (random > 20) {
			asistenciaValida = "Asitencia Confirmada";
		} else if (random <= 20) {
			asistenciaValida = "Asistencia No Confirmada";
		}
		
		return asistenciaValida;
	}

}
