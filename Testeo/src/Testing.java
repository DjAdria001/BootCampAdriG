import javax.swing.JOptionPane;
public class Testing {
	
	public static void main(String[] args) {
		String InsNum = JOptionPane.showInputDialog("Inserte un Numero: ");
        int num = Integer.parseUnsignedInt(InsNum);
        boolean primo = true;
		if (num == 1) {
			System.out.println(num + " es un numero primo ");
		}
        for (int Div=2; Div<=(num-1);Div++){
        	if(num%Div==0) {
        		
//        		System.out.println(num +" No es un numero primo -->" + num+ "/" +Div);
        		break;
        	}else {
//        		System.out.println(num + " es un numero primo ");
        	}
			

        }
	}
}