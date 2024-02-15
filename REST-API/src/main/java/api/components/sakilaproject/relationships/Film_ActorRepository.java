package api.components.sakilaproject.relationships;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Film_ActorRepository extends JpaRepository<Film_Actor,RoleID> {
}
