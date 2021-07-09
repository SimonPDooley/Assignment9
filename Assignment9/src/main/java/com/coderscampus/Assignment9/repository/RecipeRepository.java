package com.coderscampus.Assignment9.repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.FileService;

@Repository
public class RecipeRepository {
	
	@Autowired
	private FileService fileService;

	public List<Recipe> getGlutenFreeRecipes() throws IOException {
		List<Recipe> allRecipes = fileService.readRecipesFile();
		List<Recipe> glutenFreeRecipes = allRecipes
				.stream()
				.filter(x -> x.getGlutenFree())
				.collect(Collectors.toList());

		return glutenFreeRecipes;
	}
	
	public List<Recipe> getVeganRecipes() throws IOException {
		List<Recipe> allRecipes = fileService.readRecipesFile();
		List<Recipe> veganRecipes = allRecipes
				.stream()
				.filter(x -> x.getVegan())
				.collect(Collectors.toList());
				  		  
		return veganRecipes;
	}
	 
	public List<Recipe> getVeganAndGlutenFreeRecipes() throws IOException {
		List<Recipe> allRecipes = fileService.readRecipesFile();
		List<Recipe> veganAndGlutenFreeRecipes = allRecipes
				.stream()
				.filter(x -> x.getVegan())
				.filter(x -> x.getGlutenFree())
				.collect(Collectors.toList());
				  		  
		return veganAndGlutenFreeRecipes;
	}
	  
	public List<Recipe> getVegetarianRecipes() throws IOException {
		List<Recipe> allRecipes = fileService.readRecipesFile();
		List<Recipe> vegetarianRecipes = allRecipes
				.stream()
				.filter(x -> x.getVegetarian())
				.collect(Collectors.toList());
				  		  
		return vegetarianRecipes;
	}
	
}