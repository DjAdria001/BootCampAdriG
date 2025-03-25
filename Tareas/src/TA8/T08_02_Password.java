package TA8;

public class T08_02_Password {
	Integer Longitud;
	String Contraseña;

	public T08_02_Password() {
		this.Longitud = 8;
		this.Contraseña = "";
	}

	public String GenPass(int longitud2) {
		this.Longitud = longitud2;
		StringBuilder pass = new StringBuilder();
		String caracteres = "abcdefghijklmnopqrstuvwxyz" 
		+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		for (int i = 0; i < this.Longitud; i++) {
			int randomIndex = (int) (Math.random() * caracteres.length());
			pass.append(caracteres.charAt(randomIndex));
		}
		this.Contraseña = pass.toString();
		System.out.println("La contraseña generada es: " + this.Contraseña);
		return Contraseña;
	}
}
