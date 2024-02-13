package api.components.sakilaproject.film;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.actor.ActorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmRepository filmRepo;

    @GetMapping("allFilms")
    public String getAllFilms() throws JsonProcessingException {
        List<Film> objectFilms = filmRepo.findAll();
        List<String> films = new ArrayList<String>();

        for(Film film : objectFilms){
            JSONObject jo = JSONFix.fixOrder(film, JsonViews.Film.class);
            films.add(jo.toString());
        }
        JSONObject jo = new JSONObject(films);
        return films.toString();
    }

    @GetMapping("searchById/{id}")
    public String getFilmByID(@PathVariable("id") int filmID) throws JsonProcessingException {
        Film x = filmRepo.findById(filmID).get();
        JSONObject jo = JSONFix.fixOrder(x, JsonViews.Film.class);
        return jo.toString();
    }

    @GetMapping("searchByTitle/{title}")
    public String getFilmsByTitle(@PathVariable("title") String filmTitle) throws JsonProcessingException {
        List<Film> objectFilms = filmRepo.findAll();
        List<String> films = new ArrayList<String>();

        for(Film x : objectFilms){
            if(x.getTitle().toLowerCase().contains(filmTitle.toLowerCase())){
                JSONObject jo = JSONFix.fixOrder(x,JsonViews.Film.class);
                films.add(jo.toString());
            }
        }
        return films.toString();
    }

    @GetMapping("searchByCategoryID/{id}")
    public String searchByCategoryID(@PathVariable("id") int catID) throws JsonProcessingException {
        List<Film> objectFilms = filmRepo.findFilmsFromCategory(catID);
        List<String> films = new ArrayList<String>();

        for(Film x : objectFilms){
            JSONObject jo = JSONFix.fixOrder(x, JsonViews.Film.class);
            films.add(jo.toString());
        }
        return films.toString();
    }
}
