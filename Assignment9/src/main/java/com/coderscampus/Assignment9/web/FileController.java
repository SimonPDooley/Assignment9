package com.coderscampus.Assignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.repository.RecipeRepository;
import com.coderscampus.Assignment9.service.FileService;

@RestController
public class FileController {

	@Autowired
	private FileService fileService;	
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@GetMapping("/gluten-free")
	public List<Recipe> glutenFreeRecipes() throws IOException{
		return recipeRepository.getGlutenFreeRecipes();
	}
  
	@GetMapping("/vegan")
	public List<Recipe> VeganRecipes() throws IOException {		  		  
		return recipeRepository.getVeganRecipes();
	}
	 
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> VeganAndGlutenFreeRecipes() throws IOException {
		return recipeRepository.getVeganAndGlutenFreeRecipes();
	}
	  
	@GetMapping("/vegetarian")
	public List<Recipe> VegetarianRecipes() throws IOException {		  		  
		return recipeRepository.getVegetarianRecipes();
	}
	 
	@GetMapping("/all-recipes")
	public List<Recipe> allRecipes() throws IOException {
		return fileService.readRecipesFile();
	}
}
