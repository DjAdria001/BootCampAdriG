package TA9_05;

public class Profesor extends Persona {
	
	private String Materia;
	
	public Profesor(String nombre, String apellido, Integer edad, String sexo, String Materia, boolean asistencia) {
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Edad = edad;
		this.Sexo = sexo;
		this.Materia = Materia;
		this.Asistencia = ConfirmarAsistencia();
	}


	public String getMateria() {
		return Materia;
	}


	public void setMateria(String materia) {
		this.Materia = materia;
	}

	
	public boolean ConfirmarAsistencia() {
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
