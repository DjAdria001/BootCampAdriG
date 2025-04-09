
package TA9_06;

public class Movie {
	private String title;
	private int duration;
	private int minAge;
	private String director;
	private double price;

	public Movie(String title, int duration, int minAge, String director, double price) {
		this.title = title;
		this.duration = duration;
		this.minAge = minAge;
		this.director = director;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getDuration() {
		return duration;
	}

	public int getMinAge() {
		return minAge;
	}

	public String getDirector() {
		return director;
	}

	public double getPrice() {
		return price;
	}
}
