package resources;

public enum API_Resources {
	
	AddPlaceApi("/maps/api/place/add/json"),
	GetPlaceApi("/maps/api/place/get/json"),
	DeletePlaceApi("/maps/api/place/delete/json");
	
	private String resource;

	API_Resources(String resource) {
		this.resource=resource;
	}

	public String getResource() {
		return resource;
	} 
	

}
