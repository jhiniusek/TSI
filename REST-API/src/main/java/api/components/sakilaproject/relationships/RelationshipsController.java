package api.components.sakilaproject.relationships;

import api.components.sakilaproject.actor.ActorRepository;
import api.components.sakilaproject.customer.CustomerService;
import api.components.sakilaproject.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relationships")
public class RelationshipsController {
    @Autowired
    private final RelationshipService relationshipService;

    public RelationshipsController (RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }


    @PostMapping("addRole/{filmID}/{actorID}")
    public String addRole(@PathVariable("filmID") short filmID, @PathVariable("actorID") short actorID){
        return relationshipService.addRole(filmID, actorID);
    }

    @PostMapping("addCategory/{filmID}/{categoryID}")
    public String addCategory(@PathVariable("filmID") short filmID, @PathVariable("categoryID") short categoryID){
        return relationshipService.addCategoryToFilm(filmID,categoryID);
    }

    @DeleteMapping("deleteRole/{filmID}/{actorID}")
    public String deleteRole(@PathVariable("filmID") int filmID, @PathVariable("actorID") int actorID){
        return "not ready yet";
    }
}
