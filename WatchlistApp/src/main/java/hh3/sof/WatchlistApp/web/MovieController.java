package hh3.sof.WatchlistApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import hh3.sof.WatchlistApp.domain.GenreRepository;
import hh3.sof.WatchlistApp.domain.Movie;
import hh3.sof.WatchlistApp.domain.MovieRepository;

@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@GetMapping({"/movielist", "/"})
	public String listMovies(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "movielist";
	}
	
	@GetMapping("/addmovie")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		model.addAttribute("genres", genreRepository.findAll());
		return "addmovie";
	}	
		

	@PostMapping("/save")
	public String saveMovie(Movie movie) {
		movieRepository.save(movie);
		return "redirect:movielist";
	}
	
	@GetMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")  
	public String editMovie(@PathVariable("id") Long movieId, Model model) {
	    model.addAttribute("movie", movieRepository.findById(movieId));
	    model.addAttribute("genres", genreRepository.findAll());
	    return "editmovie";
	}
	
	@GetMapping(value = "/delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteMovie(@PathVariable("id") Long movieId, Model model) { 
		movieRepository.deleteById(movieId);
		return "redirect:../movielist";
	
	}
	
		
		
	}
	
	
	

