package Nivel_3;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
	private String nombre;
	private int edad;
	private String curso;
	private int nota;
	
	public Alumno(String nom, String c, int e, int n) {
		nombre=nom;
		curso=c;
		edad = e;
		nota = n;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public static List<Alumno> getAlumnos(){
		List<Alumno> misAlumnos = new ArrayList<Alumno>();
		Alumno alumno1 = new Alumno("Javier", "Java", 17, 4);
		Alumno alumno2 = new Alumno("Fran", "PHP", 25, 3);
		Alumno alumno3 = new Alumno("Pedro", "FrontEnd", 25, 8);
		Alumno alumno4 = new Alumno("Damian", "React", 25, 6);
		Alumno alumno5 = new Alumno("German", "DataScience", 25, 5);
		Alumno alumno6 = new Alumno("Eva", "Java", 25, 1);
		Alumno alumno7 = new Alumno("Juana", "Python", 25, 9);
		Alumno alumno8 = new Alumno("Laia", "Angular", 25, 10);
		Alumno alumno9 = new Alumno("Ana", "Movil", 25, 2);
		Alumno alumno10 = new Alumno("Leyre", "Java", 25, 7);
		misAlumnos.add(alumno1);
		misAlumnos.add(alumno2);
		misAlumnos.add(alumno3);
		misAlumnos.add(alumno4);
		misAlumnos.add(alumno5);
		misAlumnos.add(alumno6);
		misAlumnos.add(alumno7);
		misAlumnos.add(alumno8);
		misAlumnos.add(alumno9);
		misAlumnos.add(alumno10);
		
		return misAlumnos;
	}
}
