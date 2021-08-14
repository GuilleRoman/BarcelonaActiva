package com.video.application;

import com.video.domain.Tag;
import com.video.domain.User;
import com.video.domain.Video;

public class VideoController implements Runnable{
	Video video;
	Runnable runnable;
	Thread thread;
	int time=0;
	public VideoController(Video v) {
		this.video=v;
		runnable= this;
		thread= new Thread(runnable);
	}
	public VideoController() {
		
	}
	public Video getVideo() {
		return video;
	}
	public Thread getThread() {
		return thread;
	}
	
	@Override
	public void run() {
		
		while(!this.thread.isInterrupted()) {
			this.getVideo().setCurrentTime(time);
			System.out.println("Playing video... current second:"+this.getVideo().getCurrentTime());
		time++;
		this.getVideo().setStatusPlay("Playing");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			Thread.currentThread().interrupt();
			
		}
			
		
		if(time==this.getVideo().getDuration()) {
			System.out.println("El video ha llegado al final");
			}
		}
		
	}
	public void play() {
		if(this.thread.isInterrupted()) {
			
		}
		this.thread.start();
	}
	public void pause() {
		
		this.thread.interrupt();
		this.video.setStatusPlay("Paused");
		//Thread.currentThread().interrupt();
		System.out.println("The video was paused at: "+this.getVideo().getCurrentTime());
		
	}
	@SuppressWarnings("deprecation")
	public void stop() {
		this.video.setStatusPlay("Stopped");
		System.out.println("The video was stopped at: "+this.getVideo().getCurrentTime());
		this.time=0;
		this.getVideo().setCurrentTime(0);
		this.thread.interrupt();
		
	}
	

}
