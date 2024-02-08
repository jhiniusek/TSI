package api.components.REST.API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class RestApiApplication {

	@Autowired
	private ActorRepository actorRepo;
	private FilmRepository filmRepo;
	private CountryRepository countryRepo;
	private CityRepository cityRepo;
	private AddressRepository addressRepo;

	public RestApiApplication(ActorRepository actorRepo, FilmRepository filmRepo, CountryRepository countryRepo, CityRepository cityRepo, AddressRepository addressRepo){
		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.countryRepo = countryRepo;
		this.cityRepo = cityRepo;
		this.addressRepo = addressRepo;
	}

	//GETTING RECORDS FROM TABLES
	@GetMapping("allActors")
	public List<String> getAllActors() throws JsonProcessingException {

		List<Actor> objectActors = actorRepo.findAll();
		List<String> actors = new ArrayList<String>();

		for(Actor actor : objectActors){
			actors.add(new ObjectMapper().writerWithView(JsonViews.Actor.class).writeValueAsString(actor));
		}
		return actors;
	}

	@GetMapping("actor/searchById/{id}")
	public String getActorByID(@PathVariable("id") int actorID) throws JsonProcessingException {
		Actor x = actorRepo.findById(actorID).get();
		return new ObjectMapper().writerWithView(JsonViews.Actor.class).writeValueAsString(x);
	}

	@GetMapping("actor/searchByName/{name}")
	public List<String> getActorByName(@PathVariable("name") String actorName) throws JsonProcessingException {
		List<Actor> objectActors = actorRepo.findAll();
		List<String> actors = new ArrayList<String>();

		for(Actor x : objectActors){
			if(x.getFirstName().toLowerCase().contains(actorName.toLowerCase())){
				actors.add(new ObjectMapper().writerWithView(JsonViews.Actor.class).writeValueAsString(x));
			}
		}
		return actors;
	}

	@GetMapping("allFilms")
	public List<String> getAllFilms() throws JsonProcessingException {
		List<Film> objectFilms = filmRepo.findAll();
		List<String> films = new ArrayList<String>();

		for(Film film : objectFilms){
			films.add(new ObjectMapper().writerWithView(JsonViews.Film.class).writeValueAsString(film));
		}
		return films;
	}

	@GetMapping("film/searchById/{id}")
	public String getFilmByID(@PathVariable("id") int filmID) throws JsonProcessingException {
		Film x = filmRepo.findById(filmID).get();
		return new ObjectMapper().writerWithView(JsonViews.Film.class).writeValueAsString(x);
	}

	@GetMapping("film/searchByTitle/{title}")
	public List<String> getFilmsByTitle(@PathVariable("title") String filmTitle) throws JsonProcessingException {
		List<Film> objectFilms = filmRepo.findAll();
		List<String> films = new ArrayList<String>();

		for(Film x : objectFilms){
			if(x.getTitle().toLowerCase().contains(filmTitle.toLowerCase())){
				films.add(new ObjectMapper().writerWithView(JsonViews.Film.class).writeValueAsString(x));
			}
		}
		return films;
	}

	@GetMapping("allCountries")
	public Iterable<Country> getAllCountries() {
		return countryRepo.findAll();
	}

	@GetMapping("allCities")
	public Iterable<City> getAllCities() {
		return cityRepo.findAll();
	}
	@GetMapping("allAddresses")
	public Iterable<Address> getAllAddresses() {
		return addressRepo.findAll();
	}

	// EDIT ACTORS
	@PostMapping(value = "addActor", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Actor addActor(@RequestBody Actor actor){
		return actorRepo.save(actor);
	}

	@DeleteMapping("removeActor/{id}")
	public String removeActor(@PathVariable("id") int actorID){
		if(actorRepo.existsById(actorID)){
			actorRepo.deleteById(actorID);
			return "Actor " + actorID + " removed.";
		}
		else{
			return "Actor with ID " + actorID + " not found.";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
