package api.components.REST.API;
import api.components.REST.API.Actor.Actor;
import api.components.REST.API.Actor.ActorRepository;
import api.components.REST.API.Address.Address;
import api.components.REST.API.Address.AddressRepository;
import api.components.REST.API.Category.Category;
import api.components.REST.API.Category.CategoryRepository;
import api.components.REST.API.City.City;
import api.components.REST.API.City.CityRepository;
import api.components.REST.API.Country.Country;
import api.components.REST.API.Country.CountryRepository;
import api.components.REST.API.Film.Film;
import api.components.REST.API.Film.FilmRepository;
import api.components.REST.API.Relationships.Film_Actor;
import api.components.REST.API.Relationships.Film_ActorRepository;
import api.components.REST.API.Relationships.Film_CategoryRepository;
import api.components.REST.API.Relationships.RoleID;
import api.components.REST.API.Staff.Staff;
import api.components.REST.API.Staff.StaffRepository;
import api.components.REST.API.Store.Store;
import api.components.REST.API.Store.StoreRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class RestApiApplication {

	@Autowired
	private ActorRepository actorRepo;
	private FilmRepository filmRepo;
	private Film_ActorRepository film_actorRepo;
	private CategoryRepository categoryRepo;
	private Film_CategoryRepository film_categoryRepo;
	private CountryRepository countryRepo;
	private CityRepository cityRepo;
	private AddressRepository addressRepo;
	private StaffRepository staffRepo;
	private StoreRepository storeRepo;

	public RestApiApplication(ActorRepository actorRepo, FilmRepository filmRepo, Film_ActorRepository film_actorRepo,
							  CategoryRepository categoryRepo, Film_CategoryRepository film_categoryRepo,
							  CountryRepository countryRepo, CityRepository cityRepo, AddressRepository addressRepo,
							  StaffRepository staffRepo, StoreRepository storeRepo){
		this.actorRepo = actorRepo;
		this.filmRepo = filmRepo;
		this.film_actorRepo = film_actorRepo;
		this.categoryRepo = categoryRepo;
		this.film_categoryRepo = film_categoryRepo;
		this.countryRepo = countryRepo;
		this.cityRepo = cityRepo;
		this.addressRepo = addressRepo;
		this.staffRepo = staffRepo;
		this.storeRepo = storeRepo;
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

	@GetMapping("allCategories")
	public List<String> getAllCategories() throws JsonProcessingException {
		List<Category> objectCategories = categoryRepo.findAll();
		List<String> categories = new ArrayList<String>();

		for(Category category : objectCategories){
			categories.add(new ObjectMapper().writerWithView(JsonViews.Category.class).writeValueAsString(category));
		}
		return categories;
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

	@GetMapping("allStaff")
	public List<String> getAllStaff() throws JsonProcessingException {
		List<Staff> objectStaff = staffRepo.findAll();
		List<String> staffList = new ArrayList<String>();

		for(Staff staff : objectStaff){
			staffList.add(new ObjectMapper().writerWithView(JsonViews.Staff.class).writeValueAsString(staff));
		}
		return staffList;
	}
	@GetMapping("allStores")
	public List<String> getAllStores() throws JsonProcessingException {
		List<Store> objectStores = storeRepo.findAll();
		List<String> stores = new ArrayList<String>();

		for(Store store : objectStores){
			stores.add(new ObjectMapper().writerWithView(JsonViews.Store.class).writeValueAsString(store));
		}
		return stores;
	}

	// EDIT ACTORS
	@PostMapping(value = "addActor", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Actor addActor(@RequestBody Actor actor){
		return actorRepo.save(actor);
	}

	@PutMapping(value = "editActor/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String editActor(@PathVariable("id") int actorID, @RequestBody Actor actor) throws JsonProcessingException {

		Actor x = actorRepo.findById(actorID).get();
		x.setFirstName(actor.getFirstName());
		x.setLastName(actor.getLastName());
		actorRepo.save(x);

		return new ObjectMapper().writerWithView(JsonViews.Actor.class).writeValueAsString(x);
	}

	//NOT READY YET
	@PostMapping(value = "addRole/{filmID}/{actorID}")
	public String addRole(@PathVariable("filmID") int filmID, @PathVariable("actorID") int actorID){
		RoleID newRoleID = new RoleID();
		newRoleID.setActor_id(actorID);
		newRoleID.setFilm_id(filmID);

		Film_Actor newRole = new Film_Actor();
		newRole.setId(newRoleID);
		newRole.setActor(actorRepo.findById(actorID).get());
		newRole.setFilm(filmRepo.findById(filmID).get());

		film_actorRepo.save(newRole);

		return "Actor ID: " + actorID + " added to a film with ID: " + filmID + ".";
	}

	@DeleteMapping("removeActor/{id}")
	public String removeActor(@PathVariable("id") int actorID){
		if(actorRepo.existsById(actorID)){
			actorRepo.deleteById(actorID);
			return "api/components/REST/API/Actor " + actorID + " removed.";
		}
		else{
			return "Actor with ID " + actorID + " not found.";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
