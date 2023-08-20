package com.coderscampus.assignment10.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment10.spoonacular.SpoonacularIntegration;

//@RestController
//public class RecipeController {
//	
//	@Autowired
//	private SpoonacularIntegration spoonaculatIntegration;
//	
//	@GetMapping("mealplanner/week")
//	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions){
//	}
//
//	@GetMapping("mealplanner/day")
//	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions){
//	}
//
//}
