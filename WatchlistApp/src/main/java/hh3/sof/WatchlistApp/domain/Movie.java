package hh3.sof.WatchlistApp.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;

@EntityScan
public class Movie {

	private Long id;
	private String name;
	@Column(name = "publishing_year")
	private int year;
	private double rating;
	
	public Movie() {}

	public Movie(Long id, String name, int year, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", year=" + year + ", rating=" + rating;
	}
	
	
	
	
	
	
	
}
