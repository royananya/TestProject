import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.Mappayloaf;
import payload.ReusuableMethod;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZomatoCategories {
	
	
		//RestAssured.baseURI="https://developers.zomato.com/";
		//api/v2.1/cities
		
		public static Response doGetRequest(String endpoint) {
	        RestAssured.defaultParser = Parser.JSON;

		
		return
				
				given().log().all().queryParam("lat", "12.8403870000")
				.queryParam("lon", "77.6757240000")
				.header("Accept","application/json")
				.header("user-key","3ef45cf5b8c7788619df765025f94783")
				.when().log().all().get(endpoint)
				.then().log().all().assertThat().statusCode(200).extract().response();
		
		
		
		}
		
		
/*		String response_cuisine = given().log().all().queryParam("city_id", 4)
				.header("Accept","application/json")
				.header("user-key","3ef45cf5b8c7788619df765025f94783")
				.when().log().all().get("api/v2.1/cuisines")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response_cuisine);
		
		
		
		String response_collections = given().log().all().queryParam("lat", "12.8403870000")
				.queryParam("lon", "77.6757240000")
				.header("Accept","application/json")
				.header("user-key","3ef45cf5b8c7788619df765025f94783")
				.when().log().all().get("api/v2.1/collections")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response_collections);
		
		
		String response_establishements = given().log().all().queryParam("lat", "12.8403870000")
				.queryParam("lon", "77.6757240000")
				.header("Accept","application/json")
				.header("user-key","3ef45cf5b8c7788619df765025f94783")
				.when().log().all().get("api/v2.1/establishments")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response_establishements);
		
		String response_geocode = given().log().all().queryParam("lat", "12.8403870000")
				.queryParam("lon", "77.6757240000")
				.header("Accept","application/json")
				.header("user-key","3ef45cf5b8c7788619df765025f94783")
				.when().log().all().get("api/v2.1/geocode")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response_geocode);
		
	}

*/
}
