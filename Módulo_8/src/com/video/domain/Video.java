package com.video.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Video {
	

	private String URL;
	private String title;
	private List<Tag> tags = new ArrayList<Tag>();
	private String status;
	final Timestamp dateUploaded = new Timestamp( System.currentTimeMillis());
	private int duration;
	private String statusPlay;
	private int currentTime=0;
	
	
	
	
	public int getDuration() {
		return duration;
	}
	public void setDuration(int e) {
		duration=e;
	}
	public int getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(int a) {
		currentTime=a;
	}
	public String getStatusPlay() {
		return statusPlay;
	}
	public void setStatusPlay(String s) {
		statusPlay = s;
	}
	public Timestamp getDateUploaded() {
		System.out.println(this.dateUploaded);
		return dateUploaded;
	}
	public String getStatus() {
		return status;
	}
	public String getURL() {
		return URL;
	}
	public String getTitle() {
		return title;
	}
	public List<Tag> getTags() {
		return this.tags;
	}
	
	public Video(String uRL, String title) throws Exception{
		super();
		URL = uRL;
		this.title = title;
		
		Tag tag1= new Tag(JOptionPane.showInputDialog(null, "Introduce tag name"));
		tags.add(tag1);
		duration = Integer.parseInt( JOptionPane.showInputDialog(null, "Introduce duration in seconds"));
		boolean loop = true;
		while(loop){
			String keepTagging = JOptionPane.showInputDialog(null, "¿Would you like to add more tags?");
			if(keepTagging.equalsIgnoreCase("Yes")) {
				Tag tag2= new Tag(JOptionPane.showInputDialog(null, "Introduce tag name"));
				tags.add(tag2);
			}else {
				break;
			}
		}
		
	}
	public int getTimeElapsed() {
		Timestamp stopTime = new Timestamp( System.currentTimeMillis());
		@SuppressWarnings("deprecation")
		int elapsedTime = stopTime.getSeconds()- dateUploaded.getSeconds();
		if(elapsedTime <1) {
			this.status= "Uploading";
		}else if(elapsedTime >3){
			this.status= "Public";
		}else {
			this.status= "Verifying";
		}
		System.out.println(this.status);
		return elapsedTime;
	} 
}
