package tutorial.albertespring.services;

import org.springframework.stereotype.Service;
import tutorial.albertespring.domain.Recipe;
import tutorial.albertespring.repository.RecipeRepository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class RecipeServiceImp implements  RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {

        this.recipeRepository = recipeRepository;
    }
    @Override
    public Set<Recipe> getRecipes() {
       Set <Recipe> recipes=new HashSet<>();
       recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
