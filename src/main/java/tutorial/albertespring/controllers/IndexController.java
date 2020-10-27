package tutorial.albertespring.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tutorial.albertespring.services.RecipeService;


@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("Esto es lo que pasa si haces un debub en Index");
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }
}
