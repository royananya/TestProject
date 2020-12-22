package testValidation;

import io.restassured.path.json.JsonPath;
import payload.Cuisinepayload;


public class ZomatoCuisine {
	
	public static void main (String args[]) {
		
		JsonPath js = new JsonPath(Cuisinepayload.getCuisine());
		
		
		
		int count = js.getInt("cuisines.size()");
		System.out.println(count);
		
	}
}

