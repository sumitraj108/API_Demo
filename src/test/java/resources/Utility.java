package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utility {

	public static RequestSpecification reqst;
	ResponseSpecification resp;
	
	
	public RequestSpecification requestsprc() throws IOException {
		
		
		if(reqst==null) {
		PrintStream log = new PrintStream(new FileOutputStream("Logging.txt"));
		 reqst=new RequestSpecBuilder().setBaseUri(getGlobelValue("baseUri"))
				 .addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType("application/json").build();
		 return reqst;
		}
		return reqst;
	}
	
	public ResponseSpecification responseSpec() {

	    resp= new ResponseSpecBuilder().expectStatusCode(200).build();
	    return resp;
	}
	
	public String getGlobelValue(String globkey) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\SumitRaj\\Eclipse_java_11_Workspace\\MULTI_Api_Project\\src\\test\\java\\resources\\globel.properties");
		prop.load(fis);
		return prop.getProperty(globkey);
	}
	
	public String getJsonPath(Response responce,String key) {
		
		String resp= responce.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
