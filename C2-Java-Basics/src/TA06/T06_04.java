package TA06;

public class T06_04 {

	public static void main(String[] args) {
		String Numero = javax.swing.JOptionPane.showInputDialog("Intoduce un número para calcular el factorial: ");
        int Num = Integer.parseUnsignedInt(Numero);
        int factorial = calcFact(Num);
        javax.swing.JOptionPane.showMessageDialog(null, "El factorial es " + factorial);

	}

	public static int calcFact(int Num) {
		int factorial = 1;
		for (int i = 1; i <= Num; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}

}
