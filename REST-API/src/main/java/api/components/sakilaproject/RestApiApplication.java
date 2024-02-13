package api.components.sakilaproject;
import api.components.sakilaproject.actor.Actor;
import api.components.sakilaproject.actor.ActorRepository;
import api.components.sakilaproject.address.Address;
import api.components.sakilaproject.address.AddressRepository;
import api.components.sakilaproject.category.Category;
import api.components.sakilaproject.category.CategoryRepository;
import api.components.sakilaproject.city.City;
import api.components.sakilaproject.city.CityRepository;
import api.components.sakilaproject.country.Country;
import api.components.sakilaproject.country.CountryRepository;
import api.components.sakilaproject.film.Film;
import api.components.sakilaproject.film.FilmRepository;
import api.components.sakilaproject.relationships.Film_Actor;
import api.components.sakilaproject.relationships.Film_ActorRepository;
import api.components.sakilaproject.relationships.Film_CategoryRepository;
import api.components.sakilaproject.relationships.RoleID;
import api.components.sakilaproject.staff.Staff;
import api.components.sakilaproject.staff.StaffRepository;
import api.components.sakilaproject.store.Store;
import api.components.sakilaproject.store.StoreRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
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

	@GetMapping("allCategories")
	public String getAllCategories() throws JsonProcessingException {
		List<Category> objectCategories = categoryRepo.findAll();
		List<String> categories = new ArrayList<String>();

		for(Category category : objectCategories){
			JSONObject jo = JSONFix.fixOrder(category, JsonViews.Category.class);
			categories.add(jo.toString());
		}
		System.out.println(categories);
		return categories.toString();
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
	public String getAllStaff() throws JsonProcessingException {
		List<Staff> objectStaff = staffRepo.findAll();
		List<String> staffList = new ArrayList<String>();

		for(Staff staff : objectStaff){
			JSONObject jo = JSONFix.fixOrder(staff, JsonViews.Staff.class);
			staffList.add(jo.toString());
		}
		return staffList.toString();
	}
	@GetMapping("allStores")
	public String getAllStores() throws JsonProcessingException {
		List<Store> objectStores = storeRepo.findAll();
		List<String> stores = new ArrayList<String>();

		for(Store store : objectStores){
			JSONObject jo = JSONFix.fixOrder(store, JsonViews.Store.class);
			stores.add(jo.toString());
		}
		return stores.toString();
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


	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
