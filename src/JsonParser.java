


import io.restassured.response.Response;
public class JsonParser {
	public static void main(String[] args) {
        Response response = ZomatoCategories.doGetRequest("https://developers.zomato.com/api/v2.1/cities");

        
        List<String> jsonResponse = response.jsonPath().getList("$");
        
        System.out.println(jsonResponse.size());
}
}