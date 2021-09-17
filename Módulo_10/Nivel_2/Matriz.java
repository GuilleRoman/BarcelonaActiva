package Nivel_2;



import java.util.*;
public class Matriz {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] myArray = new String[3][2];
		myArray[0][0] = "1";
		myArray[0][1] = "Ala";
//		myArray[0][2] = "3";
	
		myArray[1][0] = "Castillo";
		myArray[1][1] = "256";
//		myArray[1][2] = "75";
		
		myArray[2][0] = "1111";
		myArray[2][1] = "Elemento";
//		myArray[2][2] = "Matriz";
		
	
		
		// Ejercicio 1 longitud (de més curta a més llarga)
		System.out.println("De Longitud menor a mayor");
		compararStringsMenorMayor(myArray);
		
		// Ejercicio 2 longitud (de més llarga a més curta) 
		System.out.println("De Longitud mayor a menor");
		compararStringsMayorMenor(myArray);
		// Ejercicio 3
		Arrays.asList(myArray).stream().filter(o-> o.toString().charAt(0)).sorted());
		System.out.println(Arrays.deepToString(myArray));
	}

	
	public static String[][] compareLengthMayor(String[][] e, int col) {
		
		Arrays.sort(e, (b, c) -> (b[col].length() < c[col].length()) ? 1 : -1);
		
		return e;
	}
public static String[][] compareLengthMenor(String[][] e, int col) {
		
		Arrays.sort(e, (b, c) -> (b[col].length() < c[col].length()) ? -1 : 1);
		
		return e;
	}
	

	public static void compararStringsMayorMenor(String[][] e){
		

		System.out.println(Arrays.deepToString(Matriz.compareLengthMayor(e, 1)));
		;
		
	}
	public static void compararStringsMenorMayor(String[][] e){
		

		
		System.out.println(Arrays.deepToString(Matriz.compareLengthMenor(e, 0)));
		;
		
	}
	
}

