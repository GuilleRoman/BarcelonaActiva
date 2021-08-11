package com.video.view;

import com.video.domain.User;

public class AppVideo {
	public static void main(String[] args) throws Exception {
		User user1 = new User();
		user1.createVideo("youtube.com", "titulo de incognito");
		user1.getMyVideos();
	}
}
