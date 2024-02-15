package api.components.sakilaproject.actor;

import api.components.sakilaproject.JSONFix;
import api.components.sakilaproject.JsonViews;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private final ActorRepository actorRepo;
    public ActorService (ActorRepository actorRepo){
        this.actorRepo = actorRepo;
    }

    public String readActor(Integer id) throws JsonProcessingException {
        Actor actor;
        try{
            actor = actorRepo.findById(id).get();
        } catch (Exception e){
            return "Invalid actor ID.";
        }
        return (JSONFix.fixOrder(actor, JsonViews.Actor.class)).toString();
    }

    public String readActors() throws JsonProcessingException {
        List<Actor> objectActors = actorRepo.findAll();
        List<String> actors = new ArrayList<String>();

        for(Actor actor : objectActors){
            JSONObject jo = JSONFix.fixOrder(actor, JsonViews.Actor.class);
            actors.add(jo.toString());
        }
        return actors.toString();
    }

    public String readActorsByName(String name) throws JsonProcessingException {
        List<Actor> objectActors = actorRepo.findActorsByName(name);
        List<String> actors = new ArrayList<String>();

        for(Actor actor : objectActors){
            JSONObject jo = JSONFix.fixOrder(actor, JsonViews.Actor.class);
            actors.add(jo.toString());
        }
        return actors.toString();
    }

    public String readHorrorActors() throws JsonProcessingException {
        List<Actor> objectActors = actorRepo.findActorsWhoPlayedInHorrors();
        List<String> actors = new ArrayList<String>();

        for(Actor x : objectActors){
            JSONObject jo = JSONFix.fixOrder(x, JsonViews.Film.class);  //Yes, Film view, it was easier solution
            actors.add(jo.toString());
        }
        return actors.toString();
    }

    public Actor createActor(Actor actor){
        actorRepo.save(actor);
        return actor;
    }

    public String editActor(int ID, Actor actor) throws JsonProcessingException {
        Actor editedActor;

        try{
            editedActor = actorRepo.findById(ID).get();
        } catch (Exception e){
            return "Invalid actor ID.";
        }
        if(actor.getFirstName().length() > 45 || actor.getLastName().length() > 45){
            return "Names cannot be longer than 45 characters.";
        }
        editedActor.setFirstName(actor.getFirstName());
        editedActor.setLastName(actor.getLastName());
        actorRepo.save(editedActor);
        JSONObject jo = JSONFix.fixOrder(editedActor, JsonViews.Actor.class);
        return jo.toString();
    }

    public String removeActor(int ID){
        if(actorRepo.existsById(ID)){
            actorRepo.deleteById(ID);
            return "Actor with ID " + ID + " removed.";
        }
        else{
            return "Actor with ID " + ID + " not found.";
        }
    }
}
