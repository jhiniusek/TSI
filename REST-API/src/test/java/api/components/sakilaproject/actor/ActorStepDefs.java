package api.components.sakilaproject.actor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorStepDefs{
    Actor actor;
    @Given("an actor")
    public void anActor(){
        actor = new Actor();
    }

    @When("I set the actor's id to {int}")
    public void setActorID(short actorID){
        actor.setActorID(actorID);
    }

    @When("I set the actor's first name to {string}")
    public void setActorFName(String name){
        actor.setFirstName(name);
    }

    @When("I set the actor's last name to {string}")
    public void setActorLName(String name){
        actor.setLastName(name);
    }

    @Then("Actor's id is {int}")
    public void checkActorID(int actorID){
        assertEquals(actorID, actor.getActorID());
    }

    @Then("Actor's first name is {string}")
    public void checkActorFName(String name){
        assertEquals(name, actor.getFirstName());
    }

    @Then("Actor's last name is {string}")
    public void checkActorLName(String name){
        assertEquals(name, actor.getLastName());
    }
}
