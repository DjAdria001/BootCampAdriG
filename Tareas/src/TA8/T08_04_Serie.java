package TA8;

public class T08_04_Serie {
	String titulo;
	int numTemporadas;
	boolean entregado;
	String Genero;
	String creador;
	
	public T08_04_Serie() {
		this.titulo = "Sin titulo";
		this.numTemporadas=3;
		this.entregado=false;
		this.Genero="Sin genero";
		this.creador="Sin creador";
	}

	public T08_04_Serie(String titulo, int numTemporadas, boolean entregado, String Genero, String creador) {
		this.titulo = titulo;
		this.numTemporadas = numTemporadas;	
		this.entregado = entregado;
		this.Genero = Genero;
		this.creador = creador;


	}
		
}
