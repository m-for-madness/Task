package Classes;

import java.util.Scanner;

public class Movie {
	// name of movie
	private String title;
	private Time duration;
	
	
	
	
	
	public Movie(String title, Time duration) {
		this.title = title;
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Name of movie : " + this.title + "\n"+"Movie lasts :"+this.duration;
	}
	
	
}
