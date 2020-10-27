package tutorial.albertespring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tutorial.albertespring.domain.Recipe;
import tutorial.albertespring.repository.RecipeRepository;

import java.util.HashSet;

import java.util.Set;
@Slf4j
@Service
public class RecipeServiceImp implements  RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {

        this.recipeRepository = recipeRepository;
    }
    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");

       Set <Recipe> recipes=new HashSet<>();
       recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
