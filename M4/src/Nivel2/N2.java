package Nivel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class N2 {

	public static void main(String[] args) throws Exception {
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
		
		for(int i=0;i<eleccion.size();i++) {
			if(!Arrays.asList(platos).contains(eleccion.get(i))) {
				 throw new Exception("No existe ese plato");
			}
		}	
		System.out.println("?Quieres a?adir alg?n plato m?s? 1:si, 2: no");
		String a?adir = sc.nextLine();
		if(!a?adir.equalsIgnoreCase("1")||!a?adir.equalsIgnoreCase("0")) {
			throw new Exception("Introduce un n?mero v?lido (0 ? 1)");
		}
		
		while(a?adir.equalsIgnoreCase("1")) {
			
			System.out.println("?Qu? deseas a?adir a tu pedido?: ");
			eleccion.add(sc.nextLine());
			for(int i=0;i<eleccion.size();i++) {
				if(!Arrays.asList(platos).contains(eleccion.get(i))) {
					 throw new Exception("No existe ese plato");
				}
			}
			System.out.println();
			System.out.println("?Quieres a?adir alg?n plato m?s? 1:si, 2: no");
			a?adir=sc.nextLine();
				if(!a?adir.equalsIgnoreCase("1")||!a?adir.equalsIgnoreCase("0")) {
					throw new Exception("Introduce un n?mero v?lido (0 ? 1)");
				}
		}
		
		System.out.println("Gracias por su pedido");
		System.out.println("---------------------");
		
		int	precioTotal=0;
		for(int i=0;i<eleccion.size();i++) {
			if(Arrays.asList(platos).contains(eleccion.get(i))) {
			precioTotal=precioTotal+precios[i];
			}else {
				System.out.println("El plato introducido no existe\n");
			}
		}
		System.out.println("El precio total es: "+precioTotal+ "?");
		System.out.println("Los billetes a entregar son:");
		doscientosE= precioTotal/200;
		System.out.println(doscientosE+" billetes de 200");
		precioTotal= precioTotal%200;
		cienE=precioTotal/100;
		System.out.println(cienE+" billetes de 100");
		precioTotal= precioTotal%100;
		cincuentaE=precioTotal/50;
		System.out.println(cincuentaE+" billetes de 50");
		precioTotal= precioTotal%50;
		veinteE=precioTotal/20;
		System.out.println(veinteE+" billetes de 20");
		precioTotal= precioTotal%20;
		diezE=precioTotal/10;
		System.out.println(diezE+" billetes de 10");
		precioTotal= precioTotal%10;
		cincoE=precioTotal/5;
		System.out.println(cincoE+" billetes de 5");
		precioTotal= precioTotal%5;
		dosE=precioTotal/2;
		System.out.println(dosE+" monedas de 2");
		precioTotal= precioTotal%2;
		euro=precioTotal/1;
		System.out.println(euro+" monedas de 1");
		System.out.println();
		System.out.println("Gracias por su visita");
	}

}
