package TA05;

import javax.swing.JOptionPane;

public class T05_11 {

	public static void main(String[] args) {
		String dia = JOptionPane.showInputDialog("Introduce un dia de la semana:");
		dia = dia.toLowerCase();
		switch (dia) {
		case "lunes":
			JOptionPane.showMessageDialog(null, "El lunes es dia laboral");
			break;
		case "martes":
			JOptionPane.showMessageDialog(null, "El martes es dia laboral");
			break;
		case "miercoles":
			JOptionPane.showMessageDialog(null, "El miercoles es dia laboral");
			break;
		case "jueves":
			JOptionPane.showMessageDialog(null, "El jueves es dia laboral");
			break;
		case "viernes":
			JOptionPane.showMessageDialog(null, "El viernes es dia laboral");
			break;
		case "sabado":
			JOptionPane.showMessageDialog(null, "El sabado no es dia laboral");
			break;
		case "domingo":
			JOptionPane.showMessageDialog(null, "El domingo no es dia laboral");
			break;
		}
	}

}
