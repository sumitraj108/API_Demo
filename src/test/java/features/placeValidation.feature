Feature: Validate Place API's

@addPlace @regression
Scenario Outline: Variry if a place is being added sucessfully using addplaceAPI
        
Given Add Place Paylod with "<name>" "<language>" "<address>"
When User calls "AddPlaceApi" with "POST" request
Then Api call get sucessfull with status code 200
And "status" in responce body is "OK"
And "scope" in responce body is "APP"
#And verify Place_id created maps to "<name>" using "GetPlaceApi"


Examples:
	|name    |language |address       |
	|Sumit   |English  |#4,Muzaffarpur|
	
@deletePlace  @regression
Scenario: Verify if place is added successfully using deletePlaceAPI

Given Delete Place Paylod
When User calls "DeletePlaceApi" with "POST" request
Then Api call get sucessfull with status code 200
And "status" in responce body is "OK"

