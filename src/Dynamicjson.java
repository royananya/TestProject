
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import payload.Mappayloaf;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
//import static io.restassured.RestAssured.then;

public class Dynamicjson 
{
	
	
	
	
	

	@Test(dataProvider = "BooksData")
	
	public void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		
		String Response =given().header("Content-Type","application/json").
		body(Mappayloaf.Addbook(isbn,aisle)).
		when()
		.post(" Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js=ReusableMethods.rawtoJson(Response);
		String id = js.get("ID");
		System.out.println(id);
		
		
	}
		
	//multidimensional array > collections of array. 
		@DataProvider(name="BooksData")
		public  Object[][] getData()
		{
		 return	new Object[][]  {{"asjhjsah","1111"},{"ash","2198"},{"djhc","736376"},{"djhsdyg","2822"}};	
		}
		
		
		
		
		
		
	
}







