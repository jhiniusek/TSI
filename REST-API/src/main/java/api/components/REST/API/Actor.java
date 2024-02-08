package api.components.REST.API;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor {
    @Id
    @Column(name="actor_id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({ JsonViews.Actor.class})
    private short actorID;

    @Column(name="first_name")
    @JsonView({ JsonViews.Actor.class, JsonViews.Film.class })
    private String firstName;

    @Column(name="last_name")
    @JsonView({ JsonViews.Actor.class, JsonViews.Film.class })
    private String lastName;

    @ManyToMany
    @JoinTable(name = "film_actor",
                joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"),
                inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"))
    @JsonView(JsonViews.Actor.class)
    private Set<Film> rolesOfActor;

    public short getActorID() {
        return actorID;
    }

    public void setActorID(short actorID) {
        this.actorID = actorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Film> getRolesOfActor() {
        return rolesOfActor;
    }

    public void setRolesOfActor(Set<Film> rolesOfActor) {
        this.rolesOfActor = rolesOfActor;
    }
}
