package api.components.sakilaproject.actor;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorRepository actorRepo;

    @GetMapping("allActors")
    public String getAllActors() throws JsonProcessingException {
        List<Actor> objectActors = actorRepo.findAll();
        List<String> actors = new ArrayList<String>();

        for(Actor actor : objectActors){
            JSONObject jo = JSONFix.fixOrder(actor, JsonViews.Actor.class);
            actors.add(jo.toString());
        }
        return actors.toString();
    }

    @GetMapping("searchById/{id}")
    public String getActorByID(@PathVariable("id") int actorID) throws JsonProcessingException {
        Actor x = actorRepo.findById(actorID).get();
        JSONObject jo = JSONFix.fixOrder(x, JsonViews.Actor.class);
        return jo.toString();
    }

    @GetMapping("searchByName/{name}")
    public String getActorByName(@PathVariable("name") String actorName) throws JsonProcessingException {
        List<Actor> objectActors = actorRepo.findAll();
        List<String> actors = new ArrayList<String>();

        for(Actor x : objectActors){
            if(x.getFirstName().toLowerCase().contains(actorName.toLowerCase())){
                JSONObject jo = JSONFix.fixOrder(x, JsonViews.Actor.class);
                actors.add(jo.toString());
            }
        }
        return actors.toString();
    }

    @GetMapping("getHorrorStars")
    public String getHorrorStars() throws JsonProcessingException{
        List<Actor> objectActors = actorRepo.findActorsWhoPlayedInHorrors();
        List<String> actors = new ArrayList<String>();

        for(Actor x : objectActors){
            JSONObject jo = JSONFix.fixOrder(x, JsonViews.Film.class);
            actors.add(jo.toString());
        }
        return actors.toString();
    }

    @PostMapping(value = "addActor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Actor addActor(@RequestBody Actor actor){
        return actorRepo.save(actor);
    }

    @PutMapping(value = "editActor/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editActor(@PathVariable("id") int actorID, @RequestBody Actor actor) throws JsonProcessingException {

        Actor x = actorRepo.findById(actorID).get();
        x.setFirstName(actor.getFirstName());
        x.setLastName(actor.getLastName());
        actorRepo.save(x);

        JSONObject jo = JSONFix.fixOrder(x, JsonViews.Actor.class);

        return jo.toString();
    }

    @DeleteMapping("removeActor/{id}")
    public String removeActor(@PathVariable("id") int actorID){
        if(actorRepo.existsById(actorID)){
            actorRepo.deleteById(actorID);
            return "Actor with ID " + actorID + " removed.";
        }
        else{
            return "Actor with ID " + actorID + " not found.";
        }
    }
}
