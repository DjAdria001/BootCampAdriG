package TA8;

public class T08_04 {

	public static void main(String[] args) {
		T08_04_Serie serieDefecto = new T08_04_Serie();
		System.out.println("Serie por defecto: " + "\nTitulo: " + serieDefecto.titulo + "\nNumero de temporadas: "
				+ serieDefecto.numTemporadas + "\nEntregado: " + serieDefecto.entregado + "\nGenero: "
				+ serieDefecto.Genero + "\nCreador: " + serieDefecto.creador);
		System.out.println("");
		T08_04_Serie serie1 = new T08_04_Serie("Invencible", serieDefecto.numTemporadas, serieDefecto.entregado, serieDefecto.Genero, "Robert Kirkman y Ryan Ottley");
		System.out.println("Serie 1: " + "\nTitulo: " + serie1.titulo + "\nNumero de temporadas: "
				+ serie1.numTemporadas + "\nEntregado: " + serie1.entregado + "\nGenero: " + serie1.Genero
				+ "\nCreador: " + serie1.creador);
		System.out.println("");
		T08_04_Serie serie2 = new T08_04_Serie("South Park", 25, serieDefecto.entregado, "Comedia", "Trey Parker y Matt Stone");
		System.out.println("Serie 2: " + "\nTitulo: " + serie2.titulo + "\nNumero de temporadas: "
				+ serie2.numTemporadas + "\nEntregado: " + serie2.entregado + "\nGenero: " + serie2.Genero
				+ "\nCreador: " + serie2.creador);
		
	}

}
