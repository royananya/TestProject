import io.restassured.path.json.JsonPath;
import payload.Mappayloaf;
import payload.Cuisinepayload;



public class ComplexJsonParsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JsonPath js=new JsonPath(Mappayloaf.CoursePrice());
		JsonPath js1=new JsonPath(Cuisinepayload.getCuisine());
		//Print No of courses returned by API
		int count1=js1.getInt("cuisine.size()");
		System.out.println(count1);
int count=	js.getInt("courses.size()");
System.out.println(count);

//2.Print Purchase Amount
int purchaseAmount=js.getInt("dashboard.purchaseAmount");
System.out.println("Purchased Amount"+purchaseAmount);

//3. Print Title of the first course
String title =js.get("courses[0].title");
System.out.println(title);
int i;
int totalsale=0;
//4. Print All course titles and their respective Prices
for(i=0;i<count;i++)
{
	
	String title1 =js.get("courses["+i+"].title");
	if(title1.equalsIgnoreCase("RPA"))
	{
		int copies=js.getInt("courses["+i+"].copies");
	}
	int price = js.getInt("courses["+i+"].price");
	int copies = js.getInt("courses["+i+"].copies");
	int sale=price*copies;
	totalsale=totalsale+sale;
	System.out.println(title1+" "+price);
}
System.out.println(totalsale);

int copies= js.getInt("courses[2].copies");
System.out.println(copies);

  
 }
 
 
 
	}



/*




4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount
*/



/*

{
"dashboard": {
  "purchaseAmount": 910,
  "website": "rahulshettyacademy.com"
},
"courses": [
  {
    "title": "Selenium Python",
    "price": 50,
    "copies": 6
  },
  {
    "title": "Cypress",
    "price": 40,
    "copies": 4
  },
  {
    "title": "RPA",
    "price": 45,
    "copies": 10
  }
]
}

*/