package hh3.sof.WatchlistApp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh3.sof.WatchlistApp.domain.Genre;
import hh3.sof.WatchlistApp.domain.GenreRepository;
import hh3.sof.WatchlistApp.domain.Movie;
import hh3.sof.WatchlistApp.domain.MovieRepository;
import hh3.sof.WatchlistApp.domain.User;
import hh3.sof.WatchlistApp.domain.UserRepository;

@SpringBootApplication
public class WatchlistAppApplication {
	
	// lisätään loggeriattribuutti
	private static final Logger log = LoggerFactory.getLogger(WatchlistAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WatchlistAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(MovieRepository movieRepository, GenreRepository genreRepository, UserRepository userRepository) {
		return (args) -> {
			
			log.info("save a couple of categories");
			Genre genre1 = new Genre("Crime");
			genreRepository.save(genre1);
			Genre genre2 = new Genre("Action");
			genreRepository.save(genre2);

			
			log.info("save some movies");
			movieRepository.save(new Movie("The Godfather", 1972, 9.2, genre1));
			movieRepository.save(new Movie("The Dark Knight", 2008, 9.0, genre2));
			
			// create users admin:admin user:user
			User user1 = new User("user", "$2a$10$8Wu7FHusJi6EtTOt17VEfeuqC69JMxu7xUeRc.ujklfpgNGTKSKqW", "USER");
			User user2 = new User("admin", "$2a$10$z1404MyI4d2qOra5bujm3uzOXSQTrz5E0iLAyAmy1IdtvQVE7EZuq", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			
			
			
			log.info("fetch all movies");
			for (Movie movie : movieRepository.findAll()) {
				log.info(movie.toString());
			}
			
		
		};

}
}
