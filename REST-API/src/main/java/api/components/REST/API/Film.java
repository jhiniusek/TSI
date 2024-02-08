package api.components.REST.API;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.HashSet;
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
    @JsonView({ JsonViews.Actor.class, JsonViews.Film.class })
    private String title;

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
