package com.rocket.view;
import com.rocket.domain.*;
public class AppRocket {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Rocket rocket1= new Rocket("32WESSDS", 3);
		Rocket rocket2= new Rocket("LDSFJA32", 6);
		System.out.println("Rocket id: "+rocket1.getCodigo()+ 
				"\nPotencia máxima: "+rocket1.getPropulsores());
		System.out.println("Rocket id: "+rocket2.getCodigo()+ 
				"\nPotencia máxima: "+rocket2.getPropulsores());
	}

}
