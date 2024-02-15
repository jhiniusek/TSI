package api.components.sakilaproject.film;

import api.components.sakilaproject.actor.Actor;
import api.components.sakilaproject.category.Category;
import api.components.sakilaproject.JsonViews;
import api.components.sakilaproject.country.Country;
import api.components.sakilaproject.language.Language;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="film")
public class Film {

    @Id
    @Column(name="film_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({JsonViews.Film.class, JsonViews.Inventory.class})
    private short filmID;

    @Column(name="title")
    @JsonView({ JsonViews.Actor.class, JsonViews.Film.class, JsonViews.Category.class, JsonViews.Inventory.class, JsonViews.Rental.class, JsonViews.Payment.class})
    private String title;

    @ManyToMany
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonView({JsonViews.Film.class})
    private Set<Category> categoriesOfFilm;

    @Column(name="description")
    @JsonView({JsonViews.Film.class})
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "language_id", nullable = false)
    @JsonView({JsonViews.Film.class})
    private Language language;

    @Column(name="release_year")
    @JsonView({JsonViews.Film.class})
    private int releaseYear;

    @Column(name="length")
    @JsonView({JsonViews.Film.class})
    private int duration;

    @Column(name="rental_duration")
    @JsonView({JsonViews.Inventory.class, JsonViews.Rental.class, JsonViews.Payment.class})
    private int rentalDuration;

    @Column(name="rental_rate")
    @JsonView({JsonViews.Inventory.class, JsonViews.Rental.class, JsonViews.Payment.class})
    private double rentalRate;

    @Column(name="replacement_cost")
    @JsonView({JsonViews.Inventory.class, JsonViews.Rental.class, JsonViews.Payment.class})
    private double replacementCost;

    @Column(name="rating")
    @JsonView({JsonViews.Film.class})
    private String rating;

    @Column(name="special_features")
    @JsonView({JsonViews.Film.class})
    private String specialFeatures;

    @ManyToMany(mappedBy = "rolesOfActor")
    @JsonView({JsonViews.Film.class})
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Set<Actor> getActorsInFilm() {
        return actorsInFilm;
    }

    public void setActorsInFilm(Set<Actor> actorsInFilm) {
        this.actorsInFilm = actorsInFilm;
    }
}
