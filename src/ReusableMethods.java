import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath  rawtoJson(String response)
	{
		JsonPath js1= new JsonPath(response);
		return js1;
	}

}

//A Java DSL for reading JSON documents.