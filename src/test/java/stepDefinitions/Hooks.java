package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@deletePlace")
	public void beforeScenarios() throws Throwable {
		//execute this code only if place id is null
		//write a code that will give you place id
		StepDefinition step = new StepDefinition();
		if (StepDefinition.placeId==null) {
		step.add_Place_Paylod_with("sammy", "bhojpuri", "bihar");
		step.user_calls_with_request("AddPlaceApi", "POST");
		step.something_in_responce_body_is_something("status", "OK");
		}
		
	}

}
