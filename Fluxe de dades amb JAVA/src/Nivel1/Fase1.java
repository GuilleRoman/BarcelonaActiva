package Nivel1;

import java.util.Scanner;

public class Fase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce 6 nombres de ciudades");
		
		String ciudad1= sc.next();
		String ciudad2= sc.next();
		String ciudad3= sc.next();
		String ciudad4= sc.next();
		String ciudad5= sc.next();
		String ciudad6= sc.next();
		
		System.out.println("Las ciudades introducidas son: "+ciudad1+ ", "+ciudad2+
				", "+ciudad3+", "+ciudad4+", "+ciudad5+" y "+ciudad6);
		
	}

}
