package api.components.REST.API.Film;

import api.components.REST.API.Actor.Actor;
import api.components.REST.API.Relationships.Film_Category;
import api.components.REST.API.JsonViews;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="film")
public class Film {

    @Id
    @Column(name="film_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({JsonViews.Film.class })
    private int filmID;

    @Column(name="title")
    @JsonView({ JsonViews.Actor.class, JsonViews.Film.class, JsonViews.Category.class })
    private String title;

    @OneToMany(mappedBy = "film")
    @JsonView({JsonViews.Film.class})
    private Set<Film_Category> categoriesOfFilm;

    @Column(name="description")
    @JsonView({JsonViews.Film.class })
    private String description;

    @Column(name="release_year")
    @JsonView(JsonViews.Film.class)
    private int releaseYear;

    @Column(name="length")
    @JsonView(JsonViews.Film.class)
    private int duration;

    @ManyToMany(mappedBy = "rolesOfActor")
    @JsonView(JsonViews.Film.class)
    private Set<Actor> actorsInFilm;

    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Film_Category> getCategoriesOfFilm() {
        return categoriesOfFilm;
    }

    public void setCategoriesOfFilm(Set<Film_Category> categoriesOfFilm) {
        this.categoriesOfFilm = categoriesOfFilm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Set<Actor> getActorsInFilm() {
        return actorsInFilm;
    }

    public void setActorsInFilm(Set<Actor> actorsInFilm) {
        this.actorsInFilm = actorsInFilm;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
