package Nivel_2;



import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Matriz implements Funcional{

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] myArray = new String[3][2];
		myArray[0][0] = "1";
		myArray[0][1] = "Ala";
		myArray[1][0] = "Castillo";
		myArray[1][1] = "256";
		myArray[2][0] = "1111";
		myArray[2][1] = "Elemento";
		
		String[] miArray = new String[7];
		miArray[0]= "1";
		miArray[1]= "Ala";
		miArray[2]="Castillo";
		miArray[3]="256";
		miArray[4]="1111";
		miArray[5]="Elemento";
		miArray[6]="Jefazo";
		
		
		List<String> miLista = Arrays.asList(miArray);
		// Ejercicio 1 longitud (de més curta a més llarga)
		System.out.println("----------EJERCICIO 1----------");
		miLista.stream().sorted(Comparator.comparing(v-> v.length())).forEach(System.out::println);;
		
		/*En array2d
		System.out.println("De Longitud menor a mayor");
		compararStringsMenorMayor(myArray);*/
		
		// Ejercicio 2 longitud (de més llarga a més curta)
		System.out.println("----------EJERCICIO 2----------");
		miLista.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
		

		
		/*En array2d
		System.out.println("De Longitud mayor a menor");
		compararStringsMayorMenor(myArray);*/
		
		// Ejercicio 3 ordenar alfabéticamente por el  primer  carácter
		System.out.println("----------EJERCICIO 3----------");
		miLista.stream().sorted(Comparator.comparing(v -> v.charAt(0))).forEach(System.out::println);
		
		//En array2d
		//compararStringsPrimerCaracter(myArray);
		
		// Ejercicio 4 Las  cadenas  que  contienen  "e" primero, todo lo demás en  segundo lugar . De  momento ,  coloque  el  código directamente  a la lambda.   
		System.out.println("----------EJERCICIO 4----------");
		miLista.stream().sorted(Comparator.comparing(v-> v.toString().contains("e")).reversed()).forEach(System.out::println);
		
		// En array2d
		//contieneE(myArray);
		
		//Ejercicio 5 Modifica  todos los elementos  de la  matriz  para  cambiar los caracteres  "a" a "4"     
		System.out.println("----------EJERCICIO 5----------");
		miLista.stream().map(v-> v.replace('a', '4')).forEach(System.out::println);
		
		// Ejercicio 6 Mostrar sólo los elementos  que  sean  100%  numéricos . ( Todo  y que  esté guardados como strings )  
		
		System.out.println("----------EJERCICIO 6----------");
		miLista.stream().filter(v-> v.matches("\\d+")).forEach(System.out::println);
		
		// Ejercicio 7 Crea una Functional Interface que contenga un método abstracto operacion (), que devuelva un valor float; 
		//inyecta en la interfaz creada mediante una lambda el cuerpo del método, de modo que puedas transformar la operación a una suma, resta, multiplicación y división. 
		System.out.println("----------EJERCICIO 7----------");
		System.out.println("----------MULTIPLICACIÓN----------");
		Funcional operaciones = (v) -> v * 5;
		System.out.println(operaciones.operacion(5));
		System.out.println("----------DIVISIÓN----------");
		operaciones = (v) -> v / 5;
		System.out.println(operaciones.operacion(5));
		System.out.println("----------SUMA----------");
		operaciones = (v) -> v+ 5;
		System.out.println(operaciones.operacion(5));
		System.out.println("----------RESTA----------");
		operaciones = (v) -> v - 5;
		System.out.println(operaciones.operacion(5));
	}

	@Override
	public float operacion(float w) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
	
	
	
	
	// Métodos sobre array 2D
//	public static String[][] compareLengthMayor(String[][] e, int col) {
//		
//		Arrays.sort(e, (b, c) -> (b[col].length() < c[col].length()) ? 1 : -1);
//		
//		return e;
//	}
//public static String[][] compareLengthMenor(String[][] e, int col) {
//		
//		Arrays.sort(e, (b, c) -> (b[col].length() < c[col].length()) ? -1 : 1);
//		
//		return e;
//	}
//	
//
//	public static void compararStringsMayorMenor(String[][] e){
//		
//
//		System.out.println(Arrays.deepToString(Matriz.compareLengthMayor(e, 1)));
//		;
//		
//	}
//	public static void compararStringsMenorMayor(String[][] e){
//		
//
//		
//		System.out.println(Arrays.deepToString(Matriz.compareLengthMenor(e, 0)));
//		;
//		
//	}
//	public static void compararStringsPrimerCaracter(String[][]e) {
//		Arrays.sort(e, (str1, str2) -> str1[0].charAt(0) - str2[1].charAt(0));
//		System.out.println(Arrays.deepToString(e));
//		}
//	
//	public static void contieneE(String[][]e) {
//		Arrays.sort(e, (str1, str2) -> str1[0].contains("e") || str2[1].contains("e")? 1: -1);
//		System.out.println(Arrays.deepToString(e));
//		
//		}
		
	}
	


