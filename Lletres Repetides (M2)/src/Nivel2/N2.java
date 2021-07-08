package Nivel2;

import java.util.Scanner;

public class N2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limite = 10;
		String impresos="";
		
		for (int i=1; i<=limite;i++) {
			
			impresos= impresos+String.valueOf(i);
			System.out.println(impresos);
		}
			
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce altura: ");
        int altura=sc.nextInt();
        String c= "*";
        for (int i=altura; i>=0;i--) {
        	for (int j=0;j<altura-i;j++) {
        		System.out.print(" ");
        	}
        	for(int k=0;k<(i*2)-1;k++) {
        		System.out.print(c);
        	}
        	System.out.println();
        }
        
		
	}
			                        
		  
}
		
		



