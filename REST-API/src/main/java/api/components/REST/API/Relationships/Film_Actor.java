package api.components.REST.API.Relationships;

import api.components.REST.API.Actor.Actor;
import api.components.REST.API.Film.Film;
import jakarta.persistence.*;

@Entity
@Table(name="film_actor")
public class Film_Actor {

    @EmbeddedId
    private RoleID id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("actor_id")
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("film_id")
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;


    public RoleID getId() {
        return id;
    }

    public void setId(RoleID id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
