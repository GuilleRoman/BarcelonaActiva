package com.rocket.domain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class controlPanel extends JFrame{

		
		public controlPanel() throws Exception  {
			
			setBounds(400,200, 500, 500);
			Lamina lamina = new Lamina();
			setTitle("Panel de Control del Rocket: "+ lamina.rocket1.getCodigo());
			add(lamina);
			
			
		}
		private static final long serialVersionUID = 1L;
		
	}
	class Lamina extends JPanel implements ActionListener{
		Rocket rocket1;
		public static Lamina2 laminaTest= new Lamina2();
		
		public static JTextArea cuadroInfo= new JTextArea();
		
		public static JScrollPane scroll = new JScrollPane(cuadroInfo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel infoPanel= new JLabel("Controle los valores del Rocket");
		
		
		public Lamina() throws Exception {
			rocket1= new Rocket("32WESSDS", 3);
			setLayout(new BorderLayout());

			add((infoPanel),BorderLayout.NORTH);
			add((scroll),BorderLayout.CENTER);

			add((laminaTest), BorderLayout.SOUTH);
			laminaTest.botonAcelerar.addActionListener(this);
			laminaTest.botonFrenar.addActionListener(this);
			
		}
		private static final long serialVersionUID = 1L;
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource()==laminaTest.botonAcelerar) {
				this.rocket1.acelerar();
			}else if(e.getSource()==laminaTest.botonFrenar){
				this.rocket1.frenar();
			}
		}
	}
		

		
		
	
	class Lamina2 extends JPanel{
		
		private static final long serialVersionUID = 232254242927974488L;
		
		JButton botonAcelerar = new JButton("Acelerar");
		
		JButton botonFrenar = new JButton("Frenar");
		JButton cambiarVelocidad = new JButton("Cambiar Velocidad");
		public Lamina2() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			add(botonAcelerar);
			add(botonFrenar);
			add(cambiarVelocidad);
			
		}
		
		
	}

