package api.components.sakilaproject.film;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.actor.Actor;
import api.components.sakilaproject.actor.ActorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private final FilmService filmService;

    public FilmController (FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public String getAllFilms() throws JsonProcessingException {
        return filmService.readFilms();
    }

    @GetMapping("searchById/{id}")
    public String getFilmByID(@PathVariable("id") int filmID) throws JsonProcessingException {
        return filmService.readFilm(filmID);
    }

    @GetMapping("searchByTitle/{title}")
    public String getFilmsByTitle(@PathVariable("title") String filmTitle) throws JsonProcessingException {
        return filmService.readFilmsByTitle(filmTitle);
    }

    @GetMapping("searchByCategoryID/{id}")
    public String searchByCategoryID(@PathVariable("id") int catID) throws JsonProcessingException {
        return filmService.readFilmsByCategoryId(catID);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Film addFilm(@RequestBody Film film){
        return filmService.createFilm(film);
    }

    @DeleteMapping("/{id}")
    public String removeFilm(@PathVariable("id") int filmID){
        return filmService.removeFilm(filmID);
    }
}
