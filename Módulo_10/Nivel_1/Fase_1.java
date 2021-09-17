package Nivel_1;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.function.*;
public class Fase_1 {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ejercicio 1
		List<String> nombres= Arrays.asList("Guille", "Ana","Pedro","Jose", "Jesus", "Alberto");
		Stream<String> stream = nombres.stream().filter(s -> s.charAt(0)== 'A').limit(1);
		stream.forEach(System.out::println);
		
		// Ejercicio 2
		List<Integer> numeros= Arrays.asList(1,2,3,5,7,4,8);
		Consumer<Integer> action = i -> {
			
		    if(i % 2 == 0) {
		        System.out.print("y" + i+", ");
		        
		    } else {
		        System.out.print("o" + i+", ");
		    
		    }
		  
		};
		numeros.stream().forEach(action);
		
		// Ejercicio 3
		System.out.println("\n"+nombres.stream().filter(s -> s.contains("o"))
				.collect(Collectors.toList()));
		
		// Ejercicio 4
		System.out.println("\n"+nombres.stream().filter(s -> s.length() > 5 && s.contains("o") )
				.collect(Collectors.toList()));
		
		// Ejercicio 5
		List<String> meses = Arrays.asList("\nEnero", "Febrero","Marzo","Abril",
				"Mayo", "Junio", "Julio", "Agosto", "Septiembre","Octubre",
				"Noviembre", "Diciembre");
		meses.stream().forEach(v -> System.out.println(v));
		
		// Ejercicio 6
		
		meses.forEach(System.out::println);
		
	}

}
