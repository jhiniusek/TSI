package api.components.sakilaproject.actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Integer>{
    @Query("SELECT a FROM Actor a JOIN a.rolesOfActor f JOIN f.categoriesOfFilm c WHERE c.categoryID = ?1")
    List<Actor> findActorsWhoPlayInCategory(int categoryID);

    @Query("SELECT a FROM Actor a WHERE a.firstName LIKE CONCAT('%',:name,'%') OR a.lastName LIKE CONCAT('%',:name,'%')")
    List<Actor> findActorsByName(String name);
}
