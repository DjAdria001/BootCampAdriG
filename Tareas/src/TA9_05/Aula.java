package TA9_05;

public class Aula {
	private Integer id;
	private Integer numeroMax;
	private String Materia;
	private Boolean Projector;

	public Aula(Integer id, Integer numeroMax, String materia, Boolean projector) {
		this.id = id;
		this.numeroMax = numeroMax;
		this.Materia = materia;
		this.Projector = projector;
	}

	public Integer getId() {
		return id;
	}

	public Integer getNumeroMax() {
		return numeroMax;
	}

	public String getMateria() {
		return Materia;
	}

	public Boolean getProjector() {
		return Projector;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	public void setNumeroMax(Integer numeroMax) {
		this.numeroMax = numeroMax;
	}

	public void setMateria(String materia) {
		this.Materia = materia;
	}

	public void setProjector(Boolean projector) {
		this.Projector = projector;
	}

	public Boolean puedeDarseClase() {
		return this.numeroMax > 0 && this.Projector;
	}



	




	
}
