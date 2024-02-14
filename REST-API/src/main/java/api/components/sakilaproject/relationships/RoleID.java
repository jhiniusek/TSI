package api.components.sakilaproject.relationships;

import jakarta.persistence.Embeddable;
import jakarta.persistence.*;
import java.io.Serializable;

@Embeddable
public class RoleID implements Serializable {
    @Column(name = "actor_id")
    private short actor_id;

    @Column(name = "film_id")
    private short film_id;

    public short getActor_id() {
        return actor_id;
    }

    public void setActor_id(short actor_id) {
        this.actor_id = actor_id;
    }

    public short getFilm_id() {
        return film_id;
    }

    public void setFilm_id(short film_id) {
        this.film_id = film_id;
    }
}
