package com.video.view;

import java.util.concurrent.TimeUnit;

import com.video.domain.User;

public class AppVideo {
	public static void main(String[] args) throws Exception {
		User user1 = new User();
		user1.createVideo("youtube.com", "titulo de incognito");
		TimeUnit.SECONDS.sleep(2);
		user1.getMyVideos();
		user1.getVideoStatus();
		
	}
}
