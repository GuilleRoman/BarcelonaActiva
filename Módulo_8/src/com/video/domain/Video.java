package com.video.domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Video {
	private String URL;
	private String title;
	private List<Tag> tags = new ArrayList<Tag>();
	
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
}
