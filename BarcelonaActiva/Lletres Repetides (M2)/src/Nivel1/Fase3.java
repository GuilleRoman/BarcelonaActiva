package Nivel1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> nom= new ArrayList<Character>();
		char[] letras= {'G','u','i','l','l','e','r','m','o'};
		for(char c:letras) {
			nom.add(c);
		}
		HashMap<Character,Integer> map= new HashMap<Character,Integer>();
		int counter=1;
		for (char c:nom) {
			if(map.containsKey(c)) {
				counter++;
			}
			map.put(c, counter);
			counter=1;
			
		}
			for(char v:map.keySet()) {
			System.out.println("Clave: "+ v+ " Valor: "+map.get(v));
		}
	}			
}
