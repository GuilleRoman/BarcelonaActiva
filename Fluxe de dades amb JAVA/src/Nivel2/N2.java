package Nivel2;

import java.util.Scanner;

public class N2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int filas=5;
		int columnas=3;
		int[][] notas= new int[filas][columnas];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<filas;i++) {
			for(int j=0;j<columnas;j++) {
				System.out.println("Introduce la nota "+i+" para el alumno en posici�n "+j);
				notas[i][j]=sc.nextInt();
				
			}
			
		}
		int suma=0;
		int alumno=1;
		for(int i=0; i<filas;i++) {
			for(int j=0;j<columnas;j++) {
				System.out.println("Posici�n "+"["+i+"]"+"["+j+"] "+notas[i][j]);
				System.out.println("---------------");
				suma=suma+notas[i][j];
				if(j==columnas-1) {
					if((suma/3)<=4) {
						System.out.println("El alumno "+alumno+" ha suspendido con un: "+ suma/3);
					}else {
						System.out.println("El alumno "+alumno+" ha aprobado con un: "+ suma/3);
					}
					
					suma=0;
					alumno++;
				}
				
				
			}
		}
		
		
	}

}
