package api.components.REST.API.Category;

import api.components.REST.API.Relationships.Film_Category;
import api.components.REST.API.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="category")
public class Category {

    @Id
    @Column(name="category_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ JsonViews.Category.class})
    private short categoryID;

    @Column(name="name")
    @JsonView({ JsonViews.Category.class, JsonViews.Film.class, JsonViews.Actor.class })
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @JsonView({ JsonViews.Category.class})
    private Set<Film_Category> filmsOfCategory;

    public short getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(short categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Film_Category> getFilmsOfCategory() {
        return filmsOfCategory;
    }

    public void setFilmsOfCategory(Set<Film_Category> filmsOfCategory) {
        this.filmsOfCategory = filmsOfCategory;
    }
}
