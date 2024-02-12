package api.components.sakilaproject.relationships;

import jakarta.persistence.Embeddable;
import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class RoleID implements Serializable {
    @Column(name = "actor_id")
    private int actor_id;

    @Column(name = "film_id")
    private int film_id;

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }
}
