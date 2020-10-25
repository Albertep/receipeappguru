package tutorial.albertespring.repository;

import org.springframework.data.repository.CrudRepository;
import tutorial.albertespring.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
}
