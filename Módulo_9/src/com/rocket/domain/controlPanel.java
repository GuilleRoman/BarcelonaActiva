package com.rocket.domain;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class controlPanel extends JFrame{
Rocket rocket;
Lamina lamina;		
		public controlPanel(Rocket r) throws Exception  {
			
			setBounds(400,200, 500, 500);
			this.lamina = new Lamina(r);
			setTitle("Panel de Control del Rocket: "+ r.getCodigo());
			add(lamina);
			
			
		}
		public Lamina getLamina() {
			return this.lamina;
		}
		private static final long serialVersionUID = 1L;
		
	}
	class Lamina extends JPanel implements ActionListener{
		Rocket rocket;
		public Lamina2 laminaTest= new Lamina2();
		
		public JTextArea cuadroInfo= new JTextArea();
		
		public  JScrollPane scroll = new JScrollPane(cuadroInfo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JLabel infoPanel= new JLabel("Controle los valores del Rocket");
		
		
		public Lamina(Rocket f) throws Exception {
			this.rocket=f;
//			rocket1= new Rocket("32WESSDS", 3);
			setLayout(new BorderLayout());

			add((infoPanel),BorderLayout.NORTH);
			add((scroll),BorderLayout.CENTER);

			add((laminaTest), BorderLayout.SOUTH);
			laminaTest.botonAcelerar.addActionListener(this);
			laminaTest.botonFrenar.addActionListener(this);
			laminaTest.cambiarVelocidad.addActionListener(this);
			laminaTest.cambiarAceleracion.addActionListener(this);
		}
		private static final long serialVersionUID = 1L;
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource()==laminaTest.botonAcelerar) {
				this.rocket.acelerar();
			}else if(e.getSource()==laminaTest.botonFrenar){
				this.rocket.frenar();
			}else if(e.getSource()==laminaTest.cambiarVelocidad) {
				int text = Integer.parseInt(laminaTest.nuevaVelocidad.getText());
				this.rocket.setVelocidad(text);
				
			}else if(e.getSource()==laminaTest.cambiarAceleracion) {
				int aceleracion= Integer.parseInt(laminaTest.nuevaAceleracion.getText());
				this.rocket.setVelocidadAceleracion(aceleracion);
			}
		}
	}
		

		
		
	
	class Lamina2 extends JPanel{
		
		private static final long serialVersionUID = 232254242927974488L;
		
		JButton botonAcelerar = new JButton("Acelerar");
		JTextField nuevaVelocidad= new JTextField("Velocidad objetivo");
		JButton botonFrenar = new JButton("Frenar");
		JButton cambiarVelocidad = new JButton("Cambiar Velocidad");
		JButton cambiarAceleracion= new JButton("Cambiar Aceleración");
		JTextField nuevaAceleracion= new JTextField("Aceleración");
		public Lamina2() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			add(botonAcelerar);
			add(botonFrenar);
			add(cambiarVelocidad);
			add(nuevaVelocidad);
			add(cambiarAceleracion);
			add(nuevaAceleracion);
		}
		
		
	}

