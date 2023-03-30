package hh3.sof.WatchlistApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MovieController {
	
	@GetMapping("movielist")
	public String listMovies(Model model) {
		model.addAttribute("movies", repository.findAll());
	}
	
}
