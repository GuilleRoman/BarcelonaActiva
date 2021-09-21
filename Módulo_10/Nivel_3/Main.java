package Nivel_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Alumno> lista = Alumno.getAlumnos();
		// EJERCICIO 1, MUESTRA POR PANTALLA NOMBRE Y EDAD
		System.out.println("----------------EJERCICIO 1----------------");
		lista.stream().collect(Collectors.toList()).forEach( v-> System.out.println( v.getNombre() +" " + v.getEdad()));
		
		// EJERCICIO 2, Filtrar la lista para  todos los alumnos  que el  nombre comensa  por "a", asigna- lo  a un  otro  lista y  muestra  por pantalla la nueva lista ( todo con  lambdas)  
		System.out.println("----------------EJERCICIO 2----------------");
		Main main = new Main();
		main.listaPorLaA(lista).stream().collect(Collectors.toList()).forEach(v -> System.out.println(v.getNombre()+" " + v.getEdad()));
		
		System.out.println("----------------EJERCICIO 3----------------");
		lista.stream().filter(v-> v.getNota()>= 5).collect(Collectors.toList()).forEach(v -> System.out.println(v.getNombre()+" " + v.getNota()));
		
		System.out.println("----------------EJERCICIO 4----------------");
		
		lista.stream().filter(v-> v.getNota()>= 5 && !v.getCurso().matches("PHP")).collect(Collectors.toList()).forEach(v -> System.out.println(v.getNombre()+" " + v.getCurso()));
		
		System.out.println("----------------EJERCICIO 5----------------");
		lista.stream().filter(v-> v.getEdad()>= 18 && v.getCurso().matches("Java")).collect(Collectors.toList()).forEach(v -> System.out.println(v.getNombre()+" " + v.getCurso()));
	}
	
	public List<Alumno> listaPorLaA(List<Alumno> f){
		List<Alumno> nuevaLista = new ArrayList<Alumno>();
		f.stream().filter(v-> v.getNombre().startsWith("A")).forEach(v -> nuevaLista.add(v));
		
		return nuevaLista;
	}

}
