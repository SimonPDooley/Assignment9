package com.coderscampus.Assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.coderscampus.Assignment9.domain.Recipe;
import com.coderscampus.Assignment9.service.FileService;

@SpringBootTest
class Assignment9ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void should_populate_list_with_recipes_from_file() throws IOException {
		
		
		FileService sut = new FileService();
		List<Recipe> recipes;
		
		recipes = sut.readRecipesFile();
		
		assertEquals(true,  recipes.get(0).getGlutenFree());
		assertEquals(false,  recipes.get(76).getGlutenFree());
		assertEquals(true,  recipes.get(71).getGlutenFree());

	}
	

}
