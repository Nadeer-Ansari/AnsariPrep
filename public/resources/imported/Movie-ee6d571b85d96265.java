package io_programming;

import java.io.Serializable;

public class Movie implements Serializable{
	private String title;
	private String genre;
	private int yearOfRelease;
	//private static int movieCount;
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public Movie(String title, String genre, int yearOfRelease) {
		super();
		this.title = title;
		this.genre = genre;
		this.yearOfRelease = yearOfRelease;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getYearOfRelease() {
		return yearOfRelease;
	}
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", genre=" + genre + ", yearOfRelease=" + yearOfRelease + "]";
	}

}
