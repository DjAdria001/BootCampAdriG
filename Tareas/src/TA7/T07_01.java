package TA7;

import java.util.ArrayList;

public class T07_01 {
	public static void main(String[] args) {
		ArrayList<String> lista=new ArrayList<>();
		lista.add("a");
		lista.add("b");
		lista.add("c");
		lista.add("d");
		lista.add("e");
//		lista.size();
		for(Object o:lista) {
			System.out.print(o+" ");
			
		}System.out.println(lista.size());
	}
}
