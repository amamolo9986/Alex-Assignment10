package com.coderscampus.assignment10.spoonacular;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.assignment10.spoonacular.dto.SpoonacularResponse;

public class SpoonacularIntegration {

	public void callApi() {
		RestTemplate rt = new RestTemplate();
		
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("apiKey", "9600681b87134872bc740384c3808883")
									  .build()
									  .toUri();
		
		ResponseEntity<SpoonacularResponse> response = rt.getForEntity(uri, SpoonacularResponse.class);
		System.out.println(response);
	}

}
