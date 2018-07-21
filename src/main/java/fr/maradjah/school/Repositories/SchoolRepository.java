package fr.maradjah.school.Repositories;

import fr.maradjah.school.models.School;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SchoolRepository extends CrudRepository<School, Long> {

}
