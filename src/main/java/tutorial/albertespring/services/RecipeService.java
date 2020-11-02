package tutorial.albertespring.services;

import org.springframework.stereotype.Service;
import tutorial.albertespring.domain.Recipe;

import java.util.Set;
@Service
public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
}
