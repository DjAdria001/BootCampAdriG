package TA6;

import javax.swing.JOptionPane;

public class T06_10 {

	public static void main(String[] args) {
		String tamaño = JOptionPane.showInputDialog("Inserta el tamaño del array: ");
		int tamañoNum = Integer.parseInt(tamaño);
		int num[] = new int[tamañoNum];
		
		

	}
	public static int ValorRand() {
		int RandomNum = (int) (Math.random() * 10);
		for (int Div = 2; Div <= (RandomNum - 1); Div++) {
			if (RandomNum % Div == 0 || RandomNum == 1) {
        		System.out.println(RandomNum +" No es un numero primo -->" + RandomNum+ "/" +Div);
				
			}
		}
		return ;
	}
}
