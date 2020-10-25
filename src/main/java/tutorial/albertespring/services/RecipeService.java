package tutorial.albertespring.services;

import tutorial.albertespring.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
