package hh3.sof.WatchlistApp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long genreid;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	@JsonIgnoreProperties("genre")
	private List<Movie> movies;

	public Genre() {
		super();
	}

	public Genre(String name) {
		super();
		this.name = name;

	}

	public Long getGenreid() {
		return genreid;
	}

	public void setGenreid(Long genreid) {
		this.genreid = genreid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Genre " + genreid + ", name=" + name;
	}

}
