package tutorial.albertespring.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import tutorial.albertespring.domain.Recipe;
import tutorial.albertespring.services.RecipeService;


import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController=new IndexController(recipeService);
    }

    @Test
    public void testMockMVC()throws Exception {
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage(){


        //given
        Recipe recipe = new Recipe();
        recipe.setCookTime(5);
        HashSet<Recipe> recipeData= new HashSet<>();
        recipeData.add(recipe);
        recipeData.add(new Recipe());
        when(recipeService.getRecipes()).thenReturn(recipeData);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String valueGetIndexPage= indexController.getIndexPage(model);

        //then
        recipeService.getRecipes().add(recipe);
        when(recipeService.getRecipes()).thenReturn(recipeData);
        model.addAttribute(recipeService.getRecipes());
        assertEquals(2,recipeService.getRecipes().size());
        assertEquals(valueGetIndexPage,"index");
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        verify(recipeService,times(4)).getRecipes();
        Set<Recipe> setInController=argumentCaptor.getValue();
        assertEquals(setInController,recipeData);
        assertEquals(2,setInController.size());

    }

}