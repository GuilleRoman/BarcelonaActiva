package com.video.domain;

public class Tag {
	private String tag;

	public Tag(String tag) throws Exception{
		super();
		this.tag = tag;
		if(tag.isBlank())
			throw new Exception();
	}
	
	
}
