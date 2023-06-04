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

import hh3.sof.WatchlistApp.domain.Genre;
import hh3.sof.WatchlistApp.domain.GenreRepository;

@RestController
@CrossOrigin
public class GenreRestController {
	
	@Autowired
	private GenreRepository genreRepository;
	
	
	@GetMapping("/genres")
	public List<Genre> getGenres() {
		return (List<Genre>) genreRepository.findAll();
	}
	
	
	@GetMapping("/genres/{id}")
	public Optional<Genre> findGenreId(@PathVariable("id") Long genreId) {
		return genreRepository.findById(genreId);
	}
	
	@PostMapping("/genres")
	public Genre save(@RequestBody Genre genre) {
		return genreRepository.save(genre);
	}
	
	

}
