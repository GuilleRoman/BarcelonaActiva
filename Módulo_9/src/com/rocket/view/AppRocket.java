package com.rocket.view;
import com.rocket.domain.*;
public class AppRocket {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Rocket rocket1= new Rocket("12345678", 3);
		Rocket rocket2= new Rocket("87654321", 6);
		System.out.println("Rocket id: "+rocket1.getCodigo()+ " tiene "+rocket1.getNumPropulsores()+ " propulsores ");
		System.out.println("Rocket id: "+rocket2.getCodigo()+ " tiene "+rocket2.getNumPropulsores()+ " propulsores ");
	}

}
