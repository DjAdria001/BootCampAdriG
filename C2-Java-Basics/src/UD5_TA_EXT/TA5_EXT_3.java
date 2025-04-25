package UD5_TA_EXT;
import javax.swing.JOptionPane;
public class TA5_EXT_3 {

	public static void main(String[] args) {
		String InsNum = JOptionPane.showInputDialog("Inserte un Numero: ");
		int num = Integer.parseUnsignedInt(InsNum);
		JOptionPane.showMessageDialog(null, "La tabla de multiplicar del "+num+" es:\n"+
							                num+" x 1 = "+(num*1)+"\n"+
							                num+" x 2 = "+(num*2)+"\n"+
							                num+" x 3 = "+(num*3)+"\n"+
							                num+" x 4 = "+(num*4)+"\n"+
							                num+" x 5 = "+(num*5)+"\n"+
							                num+" x 6 = "+(num*6)+"\n"+
							                num+" x 7 = "+(num*7)+"\n"+
							                num+" x 8 = "+(num*8)+"\n"+
							                num+" x 9 = "+(num*9)+"\n"+
							                num+" x 10 = "+(num*10)+"\n");
	}

}
