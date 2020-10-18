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
	
	public static void gitcheck() {
		System.out.println("hi i m going to check the git code ");
	}
	

}
