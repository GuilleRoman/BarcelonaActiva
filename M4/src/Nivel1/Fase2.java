package Nivel1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int euro=1;
		int dosE=2;
		int cincoE=5;
		int diezE=10;
		int veinteE=20;
		int cincuentaE=50;
		int cienE=100;
		int doscientosE=200;
		int quinientosE=500;
		String[] platos= new String[10];
		int[] precios= new int[10];
		Scanner sc= new Scanner(System.in);
		ArrayList<String> eleccion = new ArrayList<String>();
		HashMap<String,Integer> precioPlatos= new HashMap<String, Integer>();
		precioPlatos.put("Buffalina", 12);
		precioPlatos.put("4 Fromaggi", 12);
		precioPlatos.put("Pino Danielle", 18);
		precioPlatos.put("Margherita", 9);
		precioPlatos.put("Prosciutto", 10);
		precioPlatos.put("Parmiggiana", 11);
		precioPlatos.put("Al Tonno", 13);
		precioPlatos.put("Carbonara", 11);
		precioPlatos.put("Massimo Troise", 17);
		precioPlatos.put("Ortolana", 12);
		int counter = 0;
		for(Map.Entry<String,Integer> entry:precioPlatos.entrySet()) {
			platos[counter]= entry.getKey();
			precios[counter]=entry.getValue();
			counter++;
		}
		System.out.println("Elige comida de entre estas opciones:");
		for(int i=0; i<platos.length;i++) {
			System.out.println("Plato: "+platos[i]+" precio: "+ precios[i]);
		}
		
		
		eleccion.add(sc.nextLine());
		System.out.println("�Quieres a�adir alg�n plato m�s? 1:si, 2: no");
		int a�adir = sc.nextInt();
		
		
		while(a�adir==1) {
			System.out.println("�Qu� deseas a�adir a tu pedido?: ");
			eleccion.add(sc.next());
			System.out.println("�Quieres a�adir alg�n plato m�s? 1:si, 2: no");
			a�adir=sc.nextInt();
		}
		
		System.out.println("Gracias por su pedido");
		
	}

}
