package api.components.REST.API.Film;

import api.components.REST.API.Film.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Integer>{
}
