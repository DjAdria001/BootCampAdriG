package TA10_02;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		try {
			JOptionPane.showMessageDialog(null, "Mensaje de ejemplo");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}

	}

}
