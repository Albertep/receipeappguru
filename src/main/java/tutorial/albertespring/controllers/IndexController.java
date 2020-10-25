package tutorial.albertespring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tutorial.albertespring.domain.Category;
import tutorial.albertespring.domain.UnitOfMeasure;
import tutorial.albertespring.repository.CategoryRepository;
import tutorial.albertespring.repository.UnitOfMeasureRepository;
import tutorial.albertespring.services.RecipeService;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }
}
