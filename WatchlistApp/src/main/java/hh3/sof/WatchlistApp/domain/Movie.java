package hh3.sof.WatchlistApp.domain;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@Column(name = "publishing_year")
	private int year;
	private double rating;
	
	@ManyToOne
	@JsonIgnoreProperties("movies")
	@JoinColumn(name = "genreid")
	private Genre genre;
	
	public Movie() {}

	public Movie(String title, int year, double rating, Genre genre) {
		super();
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.genre = genre;
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	

	@Override
	public String toString() {
		if (this.genre != null)
		return "id=" + id + ", title=" + title + ", year=" + year + ", rating=" + rating + this.getGenre();
		else
			return "id=" + id + ", title=" + title + ", year=" + year + ", rating=" + rating;
	}

	
	
	
	
	
	
	
}
