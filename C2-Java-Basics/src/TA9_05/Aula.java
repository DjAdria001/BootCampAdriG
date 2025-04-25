
package TA9_05;

import java.util.List;

public class Aula {
	private String materia;
	private Profesor profesor;
	private List<Estudiantes> alumnos;

	public Aula(String materia, Profesor profesor, List<Estudiantes> alumnos) {
		this.materia = materia;
		this.profesor = profesor;
		this.alumnos = alumnos;

	}

	public String getMateria() {
		return materia;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public List<Estudiantes> getAlumnos() {
		return alumnos;
	}

	public boolean puedeDarseClase() {

		if (!Profesor.ConfirmarAsistencia()) {
			return false;
		}

		if (!profesor.getMateria().equalsIgnoreCase(materia)) {
			return false;
		}

		if (alumnos.size() < 6) {
			return false;
		}
		return true;
	}

	public void mostrarAprobados() {
		int hombresAprobados = 0;
		int mujeresAprobadas = 0;
		for (Estudiantes estudiante : alumnos) {
			if (estudiante.getCalificacion() >= 5.5) {
				if (estudiante.getSexo().equalsIgnoreCase("Hombre")) {
					hombresAprobados++;
				} else if (estudiante.getSexo().equalsIgnoreCase("Mujer")) {
					mujeresAprobadas++;
				}
			}
		}

		System.out.println("Hombres aprobados: " + hombresAprobados);
		System.out.println("Mujeres aprobadas: " + mujeresAprobadas);
	}

	public Integer ContarPresentes(Estudiantes[] estudiantes) {
		int contador = 0;
		for (Estudiantes estudiante : estudiantes) {
			if (estudiante.getAsistencia()) {
				contador++;
			}
		}
		return contador;
	}

}
