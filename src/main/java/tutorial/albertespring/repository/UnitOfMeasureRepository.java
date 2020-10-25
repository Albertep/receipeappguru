package tutorial.albertespring.repository;

import org.springframework.data.repository.CrudRepository;
import tutorial.albertespring.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {
    Optional <UnitOfMeasure> findByDescription(String description);
}
