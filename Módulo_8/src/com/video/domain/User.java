package com.video.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class User {
	

	private String name;
	private String lastName;
	private String password;
	private String registred;
	private List<Video> myVideos=  new ArrayList<Video>();;
	
	public User(String name, String lastName, String password, String registred) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.registred = registred;
	}
	public User() throws Exception {
		super();
		this.name = JOptionPane.showInputDialog(null, "Introduce name");
		this.lastName = JOptionPane.showInputDialog(null, "Introduce last name");
		this.password = JOptionPane.showInputDialog(null, "Introduce password");
		this.registred = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		if(this.name.isBlank()|| this.lastName.isBlank()|| this.password.isBlank()|| this.registred.isBlank())
			throw new Exception();
	}
	
	public void createVideo(String URL, String title) throws Exception {
		Video video = new Video( URL,  title);
		myVideos.add(video);
		if(URL.isBlank()|| title.isBlank()|| this.registred.isBlank())
			throw new Exception();
	}
	
	public String getMyVideos() {
		String lista="";
		for(Video v:myVideos) {
			lista= lista +" "+ v.getTitle()+" "+v.getURL()+" "+v.getTags().toString();
			System.out.println(lista);
		}
		return lista;
	}
	

	public void addVideo(Video e) {
		this.myVideos.add(e);
	}
	
}
