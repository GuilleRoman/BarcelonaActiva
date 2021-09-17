package Nivel_1;

public class Fase_2 {
	interface NumeroPi{  
	     abstract double getPiValue();  
	}  
	public static class MethodReference {  
	    public static double elPi(){  
	        
			return 3.1415;  
	    }  
	    public static void main(String[] args) {  
	        NumeroPi pi = MethodReference::elPi;
	        System.out.println(pi.getPiValue());  
	    }  
	}  
}
