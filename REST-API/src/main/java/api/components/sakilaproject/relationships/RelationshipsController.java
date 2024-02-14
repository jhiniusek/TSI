package api.components.sakilaproject.relationships;

import api.components.sakilaproject.actor.ActorRepository;
import api.components.sakilaproject.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relationships")
public class RelationshipsController {
    @Autowired
    private ActorRepository actorRepo;
    @Autowired
    private FilmRepository filmRepo;
    @Autowired
    private Film_ActorRepository film_actorRepo;
    @Autowired
    private Film_CategoryRepository film_categoryRepo;


    @PostMapping("addRole/{filmID}/{actorID}")
    public String addRole(@PathVariable("filmID") short filmID, @PathVariable("actorID") short actorID){
        RoleID newRoleID = new RoleID();
        newRoleID.setActor_id(actorID);
        newRoleID.setFilm_id(filmID);

        Film_Actor newRole = new Film_Actor();
        newRole.setId(newRoleID);
        try{
            newRole.setActor(actorRepo.findById((int)actorID).get());
        } catch (Exception e) {
            return "Invalid Actor ID.";
        }
        try{
            newRole.setFilm(filmRepo.findById((int)filmID).get());
        } catch (Exception e) {
            return "Invalid Film ID";
        }
        film_actorRepo.save(newRole);
        return "Actor ID: " + actorID + " added to a film with ID: " + filmID + ".";
    }

    @DeleteMapping("deleteRole/{filmID}/{actorID}")
    public String deleteRole(@PathVariable("filmID") int filmID, @PathVariable("actorID") int actorID){
        return "not ready yet";
    }
}
