package api.components.sakilaproject.film;

import api.components.sakilaproject.actor.Actor;
import api.components.sakilaproject.category.Category;
import api.components.sakilaproject.JsonViews;
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
    private short filmID;

    @Column(name="title")
    @JsonView({ JsonViews.Actor.class, JsonViews.Film.class, JsonViews.Category.class })
    private String title;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonView({JsonViews.Film.class})
    private Set<Category> categoriesOfFilm;

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

    public short getFilmID() {
        return filmID;
    }

    public void setFilmID(short filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Category> getCategoriesOfFilm() {
        return categoriesOfFilm;
    }

    public void setCategoriesOfFilm(Set<Category> categoriesOfFilm) {
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
