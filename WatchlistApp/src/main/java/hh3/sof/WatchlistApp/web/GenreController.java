package hh3.sof.WatchlistApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh3.sof.WatchlistApp.domain.Genre;
import hh3.sof.WatchlistApp.domain.GenreRepository;

@Controller
public class GenreController {

	@Autowired
	private GenreRepository genreRepository;

	@GetMapping("/genrelist")
	public String genreList(Model model) {
		model.addAttribute("genres", genreRepository.findAll());
		return "genrelist";

	}

	@GetMapping("/addgenre")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}

	@GetMapping(value = "/editgenre/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editGenre(@PathVariable("id") Long genreId, Model model) {
		model.addAttribute("genre", genreRepository.findById(genreId));
		return "editgenre";
	}

	@PostMapping("/savegenre")
	public String save(Genre genre) {
		genreRepository.save(genre);
		return "redirect:genrelist";
	}

	@GetMapping(value = "/deletegenre/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook(@PathVariable("id") Long genreId, Model model) {
		genreRepository.deleteById(genreId);
		return "redirect:../genrelist";
	}
}
