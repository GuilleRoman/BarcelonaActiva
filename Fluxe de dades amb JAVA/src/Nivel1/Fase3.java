package Nivel1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Fase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Introduce 6 nombres de ciudades");
		
		String ciudad1= "Berlin";
		String ciudad2= "Madrid";
		String ciudad3= "Lisboa";
		String ciudad4= "Barcelona";
		String ciudad5= "Roma";
		String ciudad6= "Napoles";
		
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
		
	}

}
