package stepDefinitions;

import resources.API_Resources;
import resources.TestDataBuild;
import static org.junit.Assert.*;

import java.io.IOException;

import resources.Utility;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition extends Utility {

	RequestSpecification req;

	Response res;
	TestDataBuild data = new TestDataBuild();
	String response;
	JsonPath js;
	static String placeId;

	@Given("Add Place Paylod with {string} {string} {string}")
	public void add_Place_Paylod_with(String name, String language, String address) throws IOException {
		req = given().spec(requestsprc()).body(data.addPlacePayload(name, language, address));

	}

	@When("User calls {string} with {string} request")
	public void user_calls_with_request(String resource, String method) {
		API_Resources apiResource = API_Resources.valueOf(resource);
		apiResource.getResource();

		if (method.equalsIgnoreCase("POST")) {
			res = req.when().post(apiResource.getResource());
		} 
		else if (method.equalsIgnoreCase("GET")) {
			res = req.when().get(apiResource.getResource());
		}
	}

	@Then("^Api call get sucessfull with status code 200$")
	public void api_call_get_sucessfull_with_status_code_200() throws Throwable {
		assertEquals(res.getStatusCode(), 200);
	}

	@And("^\"([^\"]*)\" in responce body is \"([^\"]*)\"$")
	public void something_in_responce_body_is_something(String key, String value) throws Throwable {
		response = res.asString();
		js = new JsonPath(response);
		assertEquals(js.get(key).toString(), value);
		System.out.println(response);
		placeId = js.get("place_id");

	}

	
	/*
	 * @Then("verify Place_id created maps to {string} using {string}") public void
	 * verify_Place_id_created_maps_to_using(String expeceted_name, String resource)
	 * throws IOException { // Write code here that turns the phrase above into
	 * placeId=js.get("place_id");
	 * req=given().spec(requestsprc()).queryParam("place_id", placeId);
	 * user_calls_with_request(resource,"GET"); String ActualName=js.get("name");
	 * //String accurecy=js.get("accuracy"); //System.out.println(accurecy);
	 * System.out.println(ActualName); System.out.println(expeceted_name);
	 * assertEquals(ActualName,expeceted_name);
	 * 
	 * }
	 */
	 

	@Given("Delete Place Paylod")
	public void delete_Place_Paylod() throws IOException {

		System.out.println(placeId);
		// Write code here that turns the phrase above into concrete actions
		req = given().spec(requestsprc()).body(data.deletePlacePayload(placeId));
	}

}
