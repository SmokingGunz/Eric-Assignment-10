package com.coderscampus.mealplan.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderscampus.mealplan.spoonacular.dto.DayResponse;
import com.coderscampus.mealplan.spoonacular.dto.WeekResponse;

@RestController
public class MealPlanController {
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam(required = false) String numCalories, @RequestParam(required = false) String diet, @RequestParam(required = false) String exclusions){
		
		RestTemplate rt = new RestTemplate();
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
													   		  .queryParam("timeFrame", "week")
													   		  .queryParam("apiKey", "613653729e1e4caaa4a0ba3433f60d48");
		
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
		
		ResponseEntity<WeekResponse> response = rt.getForEntity(uri, WeekResponse.class);
		return response;
	}
	
	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(@RequestParam(required = false) String numCalories, @RequestParam(required = false) String diet, @RequestParam(required = false) String exclusions){
	RestTemplate rt = new RestTemplate();
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
													   		  .queryParam("timeFrame", "day")
													   		  .queryParam("apiKey", "613653729e1e4caaa4a0ba3433f60d48");
		
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
		
		ResponseEntity<DayResponse> response = rt.getForEntity(uri, DayResponse.class);
		return response;
		
	}

}
