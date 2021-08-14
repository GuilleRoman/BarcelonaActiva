package com.video.view;

import java.util.concurrent.TimeUnit;

import com.video.application.VideoController;
import com.video.domain.User;

public class AppVideo {
	
	public static void main(String[] args) throws Exception {
		User user1 = new User();
		user1.createVideo("youtube.com", "titulo de incognito");
		VideoController controller = new VideoController(user1.getVideo());
		controller.play();
		Thread.sleep(5000);
		user1.getMyVideos();
		user1.getVideoStatus();
		user1.getStatusPlay();
		controller.pause();
		user1.getStatusPlay();
		
		
		
		controller.stop();
		user1.getStatusPlay();
		
	}
}
