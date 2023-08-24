package com.coderscampus.assignment10.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.assignment10.spoonacular.dto.DayResponse;
import com.coderscampus.assignment10.spoonacular.dto.WeekResponse;

@Service
public class SpoonacularIntegrationService {

	public ResponseEntity<WeekResponse> callWeekApi(String numCalories, String diet, String exclusions) {
		
		RestTemplate rt = new RestTemplate();
		UriComponentsBuilder uriBuild = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
															.queryParam("timeFrame", "week")
															.queryParam("apiKey", "9600681b87134872bc740384c3808883");

		if (numCalories != null) {
			uriBuild.queryParam("targetCalories", numCalories);
		}
		if (diet != null) {
			uriBuild.queryParam("diet", diet);
		}
		if (exclusions != null) {
			uriBuild.queryParam("exclude", exclusions);
		}

		URI uri = uriBuild.build()
						  .toUri();

		ResponseEntity<WeekResponse> weekResponse = rt.getForEntity(uri, WeekResponse.class);
		return weekResponse;
	}

	public ResponseEntity<DayResponse> callDayApi(String numCalories, String diet, String exclusions) {
		
		RestTemplate rt = new RestTemplate();
		UriComponentsBuilder uriBuild = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
															.queryParam("timeFrame", "day")
															.queryParam("apiKey", "9600681b87134872bc740384c3808883");

		if (numCalories != null) {
			uriBuild.queryParam("targetCalories", numCalories);
		}
		if (diet != null) {
			uriBuild.queryParam("diet", diet);
		}
		if (exclusions != null) {
			uriBuild.queryParam("exclude", exclusions);
		}

		URI uri = uriBuild.build()
						  .toUri();
		
		ResponseEntity<DayResponse> dayResponse = rt.getForEntity(uri, DayResponse.class);
		return dayResponse;
	}

}
