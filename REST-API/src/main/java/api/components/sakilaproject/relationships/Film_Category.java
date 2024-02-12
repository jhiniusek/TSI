package api.components.sakilaproject.relationships;

import api.components.sakilaproject.category.Category;
import api.components.sakilaproject.film.Film;
import api.components.sakilaproject.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

@Entity
@Table(name="film_category")
public class Film_Category {
    @EmbeddedId
    FilmCatID id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("film_id")
    @JsonView(JsonViews.Category.class)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @MapsId("category_id")
    @JsonView({JsonViews.Film.class})
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public FilmCatID getId() {
        return id;
    }

    public void setId(FilmCatID id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
