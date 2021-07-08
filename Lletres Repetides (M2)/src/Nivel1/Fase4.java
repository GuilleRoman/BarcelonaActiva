package Nivel1;

import java.util.ArrayList;
import java.util.List;

public class Fase4 {
	public static void main (String[] args) {
		
	List<Character> nom= new ArrayList<Character>();
	char[] letras={'G','u','i','l','l','e','r','m','o'};
		for(char c:letras) {
		nom.add(c);
	}
	List<Character> cognom= new ArrayList<Character>();
	char[] letras1= {'R','o','m','a','n'};
	for(char d:letras1) {
		cognom.add(d);
		}
	List<Character> fullName= new ArrayList<Character>();
	fullName.addAll(nom);
	fullName.add(' ');
	fullName.addAll(cognom);
	System.out.print(fullName);
	}
	
	
	}



