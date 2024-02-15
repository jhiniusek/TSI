package api.components.sakilaproject.actor;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private final ActorService actorService;

    public ActorController (ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public String getAllActors() throws JsonProcessingException {
        return actorService.readActors();
    }

    @GetMapping("/searchByID/{id}")
    public String getActorByID(@PathVariable("id") int actorID) throws JsonProcessingException {
        return actorService.readActor(actorID);
    }

    @GetMapping("/searchByName/{name}")
    public String getActorByName(@PathVariable("name") String actorName) throws JsonProcessingException {
        return actorService.readActorsByName(actorName);
    }

    @GetMapping("/getActorsPlayingInCategory/{id}")
    public String getHorrorStars(@PathVariable("id") int categoryID) throws JsonProcessingException{
        return actorService.readActorsPlayingInCategory(categoryID);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Actor addActor(@RequestBody Actor actor){
        return actorService.createActor(actor);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editActor(@PathVariable("id") int actorID, @RequestBody Actor actor) throws JsonProcessingException {
        return actorService.editActor(actorID, actor);
    }

    @DeleteMapping("/{id}")
    public String removeActor(@PathVariable("id") int actorID){
        return actorService.removeActor(actorID);
    }
}
