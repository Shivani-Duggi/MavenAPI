
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class First {

	@Test
	public void APITest() {
				
		RestAssured.baseURI="https://reqres.in/";
		Response res=given().
		given().
		param("page","2").
		when().
		get("api/users").
		then().assertThat().
		statusCode(200).and().contentType(ContentType.JSON).and().
		//body("data[0].first_name",equalTo("Michael")).and().
		//body("data[1].avatar",equalTo("https://reqres.in/img/faces/8-image.jpg")).and().
		//body("page",equalTo(2)).and().header("Server","cloudfare");
		extract().response();
		
		String responseString=res.asString();
		System.out.println(responseString);
	    JsonPath js=new JsonPath(responseString);
	    String fname=js.get("data[0].first_name");
	    System.out.println(fname);
	    int count=js.get("data.size()");
	    System.out.println(count);
	  	
	    for(int i=0;i<count;i++) {
	    	
	    	String First_Name=js.getString("data["+i+"].first_name");
	    	System.out.println(First_Name);
	    }
	}
}
