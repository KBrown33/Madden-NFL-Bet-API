package com.example.maddennflbet.controller;


import com.example.maddennflbet.model.MaddenNFL;
import com.example.maddennflbet.model.Winner;
import com.example.maddennflbet.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class WinnerController {


    @Autowired
    public void setWinnerService(WinnerService winnerService) {
        this.winnerService = winnerService;
    }

    @GetMapping("/winners")
    public List<Winner> getWinners() {
        System.out.println("calling getWinners ==>");
        return winnerService.getWinners();
    }

    @GetMapping(path = "/winners/{winnerId}")
    public Optional getWinner(@PathVariable Long winnerId) {
        System.out.println("calling getWinner ==>");
        return winnerService.getWinner(winnerId);
    }

    @PostMapping("/winners/")
    public Winner createWinner(@RequestBody Winner winnerObject) {
        System.out.println("calling createWinner ==>");
        return winnerService.createWinner(winnerObject);
    }

    @PutMapping("/winners/{winnerId}")
    public Winner updateWinner(@PathVariable(
            value = "winnerId") Long winnerId, @RequestBody Winner winnerObject) {
        System.out.println("calling updateWinner ==>");
        return winnerService.updateWinner(winnerId, winnerObject);
    }

    @DeleteMapping("/winners/{winnerId}")
    public Optional<Winner> deleteWinner(@PathVariable(value = "winnerId") Long winnerId) {
        System.out.println("calling deleteWinner ==>");
        return winnerService.deleteWinner(winnerId);
    }

    @PostMapping("/winners/{winnerId}/maddenNFL")
    public Winner createWinnerMaddenNFL(
            @PathVariable(value = "winnerId") Long winnerId, @RequestBody MadddenNFL maddenNFLObject) {
        System.out.println("calling createWinnerMaddenNFL ==>");
        return winnerService.createWinnerRecipe(winnerId, maddenNFLObject);
    }

    @GetMapping("/winners/{winnerId}/maddenNFL")
    public List<MaddenNFL> getCategoryRecipes(@PathVariable(value = "winnerId") Long winnerId) {
        System.out.println("calling getWinnerMaddenNFL ==>");
        return winnerService.getWinnerMaddenNFL(winnerId);
    }

    @GetMapping("/winners/{winnerId}/maddenNFL/{maddenNFLId}")
    public MaddenNFL getWinnerMaddenNFL(
            @PathVariable(value = "winnerId") Long winnerId, @PathVariable(value = "maddenNFLId") Long maddenNFLId) {
        System.out.println("calling getWinnerMaddenNFL ==>");
        return winnerService.getCategoryRecipe(winnerId, maddenNFLId);
    }

    @PutMapping("/categories/{categoryId}/recipes/{recipeId}")
    public Recipe updateCategoryRecipe(@PathVariable(value = "categoryId") Long categoryId,
                                       @PathVariable(value = "recipeId") Long recipeId,
                                       @RequestBody Recipe recipeObject) {
        System.out.println("calling getCategoryRecipe ==>");
        return categoryService.updateCategoryRecipe(categoryId, recipeId, recipeObject);
    }

    @DeleteMapping("/categories/{categoryId}/recipes/{recipeId}")
    public ResponseEntity<HashMap> deleteCategoryRecipe(
            @PathVariable(value = "categoryId") Long categoryId, @PathVariable(value = "recipeId") Long recipeId) {
        System.out.println("calling getCategoryRecipe ==>");
        categoryService.deleteCategoryRecipe(categoryId, recipeId);
        HashMap responseMessage = new HashMap();
        responseMessage.put("status", "recipe with id: " + recipeId + " was successfully deleted.");
        return new ResponseEntity<HashMap>(responseMessage, HttpStatus.OK);
    }
}

