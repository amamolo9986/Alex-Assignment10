package com.coderscampus.assignment10.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.assignment10.spoonacular.dto.DayResponse;
import com.coderscampus.assignment10.spoonacular.dto.WeekResponse;

@Service
public class SpoonacularIntegrationService {
	
	@Value("${spoonacular.urls.base}")
	private String baseUrl;
	
	@Value("${spoonacular.urls.mealplan}")
	private String mealPlannerUrl;
	
	@Value("${spoonacular.apiKey}")
	private String apiKey;

	public ResponseEntity<WeekResponse> callWeekApi(@RequestParam(required = false) String numCalories, 
													@RequestParam(required = false) String diet, 
													@RequestParam(required = false) String exclusions) {
		
		RestTemplate rt = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + mealPlannerUrl)
															  .queryParam("timeFrame", "week")
															  .queryParam("apiKey", apiKey);
															
		if(numCalories!= null) {
			uriBuilder.queryParam("targetCalories", numCalories);
		}
		
        if(diet!= null) {
            uriBuilder.queryParam("diet", diet);
        }
        
        if(exclusions!= null) {
            uriBuilder.queryParam("exclude", exclusions);
        }
        
        URI uri = uriBuilder.build().toUri();
		ResponseEntity<WeekResponse> weekResponse = rt.getForEntity(uri, WeekResponse.class);
		return weekResponse;
	}

	public ResponseEntity<DayResponse> callDayApi(@RequestParam(required = false) String numCalories, 
												  @RequestParam(required = false) String diet, 
												  @RequestParam(required = false) String exclusions) {
		
		RestTemplate rt = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + mealPlannerUrl)
															  .queryParam("timeFrame", "day")
															  .queryParam("apiKey", apiKey);
															
		if(numCalories!= null) {
			uriBuilder.queryParam("targetCalories", numCalories);
		}
		
        if(diet!= null) {
            uriBuilder.queryParam("diet", diet);
        }
        
        if(exclusions!= null) {
            uriBuilder.queryParam("exclude", exclusions);
        }
        
        URI uri = uriBuilder.build().toUri();
		ResponseEntity<DayResponse> dayResponse = rt.getForEntity(uri, DayResponse.class);
		return dayResponse;
	}

}



