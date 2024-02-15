package api.components.sakilaproject.relationships;

import api.components.sakilaproject.actor.ActorRepository;
import api.components.sakilaproject.category.CategoryRepository;
import api.components.sakilaproject.film.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService {
    @Autowired
    private final ActorRepository actorRepo;
    @Autowired
    private final FilmRepository filmRepo;
    @Autowired
    private final CategoryRepository categoryRepo;
    @Autowired
    private final Film_ActorRepository film_actorRepo;
    @Autowired
    private final Film_CategoryRepository film_categoryRepo;

    public RelationshipService (ActorRepository actorRepo, FilmRepository filmRepo, CategoryRepository categoryRepo,
                                Film_ActorRepository film_actorRepo, Film_CategoryRepository film_categoryRepo){
        this.actorRepo = actorRepo;
        this.filmRepo = filmRepo;
        this.categoryRepo = categoryRepo;
        this.film_actorRepo = film_actorRepo;
        this.film_categoryRepo = film_categoryRepo;
    }

    public String addRole(short filmID, short actorID){
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

    public String addCategoryToFilm(short filmID, short categoryID){
        FilmCatID newFilmCatID = new FilmCatID();
        newFilmCatID.setCategory_id(categoryID);
        newFilmCatID.setFilm_id(filmID);

        Film_Category newFilm_Category = new Film_Category();
        newFilm_Category.setId(newFilmCatID);
        try{
            newFilm_Category.setCategory(categoryRepo.findById((int)categoryID).get());
        } catch (Exception e) {
            return "Invalid Category ID.";
        }
        try{
            newFilm_Category.setFilm(filmRepo.findById((int)filmID).get());
        } catch (Exception e) {
            return "Invalid Film ID";
        }
        film_categoryRepo.save(newFilm_Category);
        return "Category ID: " + categoryID + " added to a film with ID: " + filmID + ".";
    }
}
