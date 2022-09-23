package com.ragnarzone.recipeproject.controllers;

import com.ragnarzone.recipeproject.commands.IngredientCommand;
import com.ragnarzone.recipeproject.services.IngredientService;
import com.ragnarzone.recipeproject.services.RecipeService;
import com.ragnarzone.recipeproject.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable Long recipeId, Model model){
        log.debug("Getting ingredient list for recipe id " + recipeId);
        model.addAttribute("recipe", recipeService.findCommandById(recipeId));
        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
    public  String showRecipeIngredient(@PathVariable Long recipeId,
                                        @PathVariable Long ingredientId, Model model){

        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdAndIngredientId(recipeId,ingredientId));

        return "recipe/ingredient/show";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateRecipeIngredient(@PathVariable Long recipeId,
                                         @PathVariable Long ingredientId, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId, ingredientId));

        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());
        return "recipe/ingredient/ingredientform";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("saved recipe id:" + savedCommand.getRecipeId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }
}
