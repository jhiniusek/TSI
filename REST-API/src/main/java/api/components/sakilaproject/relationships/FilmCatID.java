package api.components.sakilaproject.relationships;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FilmCatID implements Serializable {
    @Column(name = "film_id")
    private short film_id;

    @Column(name = "category_id")
    private short category_id;

    public short getFilm_id() {
        return film_id;
    }

    public void setFilm_id(short film_id) {
        this.film_id = film_id;
    }

    public short getCategory_id() {
        return category_id;
    }

    public void setCategory_id(short category_id) {
        this.category_id = category_id;
    }
}
