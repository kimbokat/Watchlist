package hh3.sof.WatchlistApp.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hh3.sof.WatchlistApp.domain.Movie;
import hh3.sof.WatchlistApp.domain.MovieRepository;

@RestController
@CrossOrigin
public class MovieRestController {

	@Autowired
	private MovieRepository movieRepository;

	@GetMapping("/movies")
	public List<Movie> getMovies() {
		return (List<Movie>) movieRepository.findAll();
	}

	@GetMapping("/movies/{id}")
	public Optional<Movie> findMovieId(@PathVariable("id") Long movieId) {
		return movieRepository.findById(movieId);
	}

	@PostMapping("/movies")
	public Movie save(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}

}
