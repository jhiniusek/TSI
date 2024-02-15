package api.components.sakilaproject.film;

import api.components.sakilaproject.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Integer>{
    @Query("SELECT f FROM Film f JOIN f.categoriesOfFilm c WHERE c.categoryID = :inputID")
    List<Film> findFilmsFromCategory(int inputID);

    @Query("SELECT f FROM Film f WHERE f.title LIKE CONCAT('%',:title,'%')")
    List<Film> findFilmByTitle(String title);
}
