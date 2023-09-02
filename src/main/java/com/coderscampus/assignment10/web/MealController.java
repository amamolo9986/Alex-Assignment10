package com.coderscampus.assignment10.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderscampus.assignment10.service.SpoonacularIntegrationService;
import com.coderscampus.assignment10.spoonacular.dto.DayResponse;
import com.coderscampus.assignment10.spoonacular.dto.WeekResponse;

@Controller
public class MealController {

	@Autowired
	private SpoonacularIntegrationService spoonacularIntegrationService;

	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories, 
			@RequestParam(value = "diet", required=false) String diet, 
			@RequestParam(value = "exclusions", required = false) String exclusions){
		ResponseEntity<WeekResponse> weekResponse = spoonacularIntegrationService.callWeekApi(numCalories, diet, exclusions);
		return weekResponse;
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories, 
			@RequestParam(value = "diet", required=false) String diet, 
			@RequestParam(value = "exclusions", required = false) String exclusions){
		ResponseEntity<DayResponse> dayResponse = spoonacularIntegrationService.callDayApi(numCalories, diet, exclusions);
		return dayResponse;
	}

}
