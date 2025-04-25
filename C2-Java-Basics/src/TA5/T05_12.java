package TA5;
public class T05_12 {

	public static void main(String[] args) {

		String password = "Contra123";
		String pass;
		int i = 0;
		boolean acertado = false;
		while (i < 3 && !acertado) {
			pass = javax.swing.JOptionPane.showInputDialog("Introduce la contraseña");
			if (pass.equals(password)) {
				acertado = true;
				javax.swing.JOptionPane.showMessageDialog(null, "Enhorabuena");
			}
			i++;
		}

	}

}
