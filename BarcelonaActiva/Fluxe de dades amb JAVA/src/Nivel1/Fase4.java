package Nivel1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fase4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ciudad1= "Berlin";
		String ciudad2= "Madrid";
		String ciudad3= "Lisboa";
		String ciudad4= "Barcelona";
		String ciudad5= "Roma";
		String ciudad6= "Napoles";
		
		char[] array1= new char[ciudad1.length()];
		char[]array2= new char[ciudad2.length()];
		char[]array3= new char[ciudad3.length()];
		char[]array4= new char[ciudad4.length()];
		char[]array5= new char[ciudad5.length()];
		char[]array6= new char[ciudad6.length()];		
		construirArray(ciudad1,array1);
		construirArray(ciudad2,array2);
		construirArray(ciudad3,array3);
		construirArray(ciudad4,array4);
		construirArray(ciudad5,array5);
		construirArray(ciudad6,array6);
		System.out.println("Las ciudades introducidas son: "+ciudad1+ ", "+ciudad2+
				", "+ciudad3+", "+ciudad4+", "+ciudad5+" y "+ciudad6);
		ArrayList<String> arrayCiutats = new ArrayList<String>();
		arrayCiutats.add(ciudad1);
		arrayCiutats.add(ciudad2);
		arrayCiutats.add(ciudad3);
		arrayCiutats.add(ciudad4);
		arrayCiutats.add(ciudad5);
		arrayCiutats.add(ciudad6);
		
		System.out.println("Las ciudades por orden alfabético son:");
		Collections.sort(arrayCiutats);
		for(String c:arrayCiutats) {
			String reemplazo= c.replaceAll("a", "4");
			System.out.println(reemplazo);
		}
		
		
		mostrarArray(array1);
		mostrarArray(array2);
		mostrarArray(array3);
		mostrarArray(array4);
		mostrarArray(array5);
		mostrarArray(array6);
		}
			public static void construirArray(String ciutat, char[] c) {
		
					
						for (int i = 0; i < ciutat.length(); i++) {
							c[i] = ciutat.charAt(i);
						}
		
	}
			public static void mostrarArray(char[] a) {
				for (char c:a) {
					System.out.print(c);
				}
				System.out.print("------");
				for (int i= a.length-1;i>=0;i--) {
					System.out.print(a[i]);
					
				}
				System.out.println();
			}

		
}
