package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name,String language,String address) {
		
		 AddPlace ap=new AddPlace();
		    ap.setAccuracy(50);
		    ap.setLanguage(language);
		    ap.setName(name);
		    ap.setPhone_number("99387868423");
		    ap.setWebsite("http://google.com");
		    ap.setAddress(address);
		    
		    List<String> typ=new ArrayList<String>();
		    typ.add("shoe park");
		    typ.add("shop");
		    ap.setTypes(typ);
		    
		    Location loc=new Location();
		    loc.setLat(-38.383494);
		    loc.setLng(33.427362);
		    ap.setLocation(loc);
		    
		    return ap;
	}
	
	public String deletePlacePayload(String placeId) {
		return "{\r\n" + 
				"    \"place_id\":\""+placeId+"\"\r\n" + 
				"}";
	}

}
