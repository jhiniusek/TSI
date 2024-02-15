package api.components.sakilaproject.film;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {
    @Autowired
    private final FilmRepository filmRepo;
    public FilmService (FilmRepository filmRepo){
        this.filmRepo = filmRepo;
    }

    public String readFilm(Integer id) throws JsonProcessingException {
        Film film;
        try{
            film = filmRepo.findById(id).get();
        } catch (Exception e){
            return "Invalid film ID.";
        }
        return (JSONFix.fixOrder(film, JsonViews.Film.class)).toString();
    }
    public String readFilms() throws JsonProcessingException {
        List<Film> objectFilms = filmRepo.findAll();
        List<String> films = new ArrayList<String>();

        for(Film film : objectFilms){
            JSONObject jo = JSONFix.fixOrder(film, JsonViews.Film.class);
            films.add(jo.toString());
        }
        return films.toString();
    }

    public String readFilmsByTitle(String title) throws JsonProcessingException {
        List<Film> objectFilms = filmRepo.findFilmByTitle(title);
        List<String> films = new ArrayList<String>();

        for(Film film : objectFilms){
            JSONObject jo = JSONFix.fixOrder(film, JsonViews.Film.class);
            films.add(jo.toString());
        }
        return films.toString();
    }

    public String readFilmsByCategoryId(int ID) throws JsonProcessingException {
        List<Film> objectFilms = filmRepo.findFilmsFromCategory(ID);
        List<String> films = new ArrayList<String>();

        for(Film x : objectFilms){
            JSONObject jo = JSONFix.fixOrder(x, JsonViews.Film.class);
            films.add(jo.toString());
        }
        return films.toString();
    }
}



