package Nivel1;

import java.util.ArrayList;
import java.util.List;

public class Fase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> nom= new ArrayList<Character>();
		char[] letras= {'G','u','i','l','l','e','r','m','o'};
		for(char c:letras) {
			nom.add(c);
			if(c == 'a'||c == 'e'||c == 'i'||c == 'o'||c == 'u') {
				System.out.println(c+ " Es una vocal");
			}else {
				System.out.println(c+ " Es una consonante");
			}
		}
		System.out.println(nom);
		
		

	}
	
}