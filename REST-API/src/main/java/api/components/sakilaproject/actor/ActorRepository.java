package api.components.sakilaproject.actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Integer>{

    @Query("SELECT a FROM Actor a JOIN a.rolesOfActor f JOIN f.categoriesOfFilm c WHERE c.categoryID = 11")
    List<Actor> findActorsWhoPlayedInHorrors();
}
