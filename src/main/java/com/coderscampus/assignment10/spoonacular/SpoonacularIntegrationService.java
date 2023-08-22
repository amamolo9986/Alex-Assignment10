package com.coderscampus.assignment10.spoonacular;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.assignment10.spoonacular.dto.WeekResponse;

@Service
public class SpoonacularIntegrationService {

	public void callApi() {
		RestTemplate rt = new RestTemplate();
		
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("apiKey", "9600681b87134872bc740384c3808883")
									  .build()
									  .toUri();
		
		ResponseEntity<WeekResponse> weekResponse = rt.getForEntity(uri, WeekResponse.class);
		System.out.println(weekResponse);
	}

} // Maybe I can use Generics to replace SpoonacularResponse - that way i only need this one
  // method, but i can use it for both my getday and getweek 
			
