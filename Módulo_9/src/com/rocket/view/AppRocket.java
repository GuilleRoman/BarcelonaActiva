package com.rocket.view;
import javax.swing.*;
import com.rocket.domain.*;

import com.rocket.domain.*;
public class AppRocket {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Rocket rocket1= new Rocket("32WESSDS", 3);
		
		Rocket rocket2= new Rocket("LDSFJA32", 6);
		controlPanel marco1= new controlPanel(rocket1);
		rocket1.setLamina(marco1.getLamina());
		controlPanel marco2= new controlPanel(rocket2);
		rocket2.setLamina(marco2.getLamina());	
		marco1.setVisible(true);
		marco2.setVisible(true);

		
	}	
}
