import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.Mappayloaf;
import payload.ReusuableMethod;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics

{
	public static void main(String Args[])
	{
		
		String newAddress="70 Summer walk, USA";
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Mappayloaf.addPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP")).extract().response().asString();
		
		//System.out.print(response);
		
		JsonPath js = ReusuableMethod.rawToJson(response);
		String placeID = js.getString("place_id");
		System.out.println(placeID);
		//This article will give an introduction to Jayway JsonPath, a Java implementation of the JSONPath specification. 
		//It describes setup, syntax, common APIs, and a demonstration of use cases.
		
		//Add Place -> Update the place with new address -> 
		//get place to validate if the new address is present in the response
		//three apis will be used here : Add place(post) , update(put) , see the response (get)
		//the new place id added in the post (placeid) will be passed to put request , so that we can exactly update that place id which 
		//we want to update
		
	
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\n" + 
				"\"place_id\":\""+placeID+"\",\n" + 
				"\"address\":\""+newAddress+"\",\n" + 
				"\"key\":\"qaclick123\"\n" + 
				"}\n" + 
				"")
		.when().log().all().put("/maps/api/place/update/json")
		.then().log().all(). assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		//getplace
		
		String getPlaceResponse=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.queryParam("place_id", placeID)
		.when().log().all().get("/maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
			//string is getting stored and then string is getting converted to the jsonfile and then the with jsonpath the 
		//jsonobject is being created which can be used to extract the string into the path
		//read about jsonpath here 
		JsonPath js1 = ReusuableMethod.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		//A JSONObject is an unordered collection of key and value pairs, resembling Java's native Map implementations.
	}

}
