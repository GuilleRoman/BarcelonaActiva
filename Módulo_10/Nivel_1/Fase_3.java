package Nivel_1;

import Nivel_1.Fase_2.MethodReference;
import Nivel_1.Fase_2.NumeroPi;

public class Fase_3 {
	interface AlReves{  
	     abstract String reverse(String e);  
	}
	public static class MethodReference{
		static String reverse="";
		public static String delReves(String e) {
			for(int i =e.length()-1;i>= 0; i--) {
				reverse = reverse + e.charAt(i);
			}
			return reverse;
		}
		public static void main(String[] args) {   
	        AlReves turn = MethodReference::delReves; 
	        System.out.println(turn.reverse("Albacete"));  
	    }  
	}
}
