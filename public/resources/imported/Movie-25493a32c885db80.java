package collections_framework;

public class Movie implements Comparable<Movie>{
	private String title;
	private int duration;//Minutes
	public Movie() {
		// TODO Auto-generated constructor stub
	}
	public Movie(String title, int duration) {
		super();
		this.title = title;
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", duration=" + duration + "]";
	}
	@Override
	public int compareTo(Movie movie2) {
		// This method is used to provide default sorting algorithm
		//to sort Movie objects.
		//It is sorting based upon title in ascending order.
		String title1 = title;//this.title; => First Title
		String title2 = movie2.title;// Second Title
		int comparison = title1.compareTo(title2);
		return comparison;
	}
	

}
