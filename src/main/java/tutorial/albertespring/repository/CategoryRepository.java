package tutorial.albertespring.repository;

import org.springframework.data.repository.CrudRepository;
import tutorial.albertespring.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    Optional <Category> findByDescription(String description);
}
