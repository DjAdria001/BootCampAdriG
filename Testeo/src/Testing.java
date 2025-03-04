import javax.swing.JOptionPane;

public class Testing {

	public static void main(String[] args) {
//		String Pregunta = JOptionPane.showInputDialog(" ");
//		int PregNum = Integer.parseInt(Pregunta);
//		javax.swing.JOptionPane.showMessageDialog(null,"");
		
		int RandomNum = (int) (Math.random() * 10);
		for (int Div = 2; Div <= (RandomNum - 1); Div++) {
			if(RandomNum % Div == 0 || RandomNum == 1) {
				
			}
//			System.out.println("numero primo -->" + RandomNum);
		}
		}
}
