
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;

import resources.Payload;
import resources.resources;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;

public class Weather_update {
	
	String ConsumerKey="7C1las31LFZ1sqh8VOHkhAI8M";
	String ConsumerSecret="i8cjjdZIbJwcWhDy0oATBfeOztJ7CNAK82YQcUVMfdg0NKOE7p";
	String Token="1366702057093099523-vcxMlPU6tkUOgH6VU80AyhVZXFtqKY";
	String TokenSecret="o7RsPSdjhEUC9jbXU1HgY40uiWewgJE5NdD3obQc5XpRy";
	
	private static Logger log=LogManager.getLogger(Weather_update.class.getName());

			
@Test
public void Weather() {
		
		RestAssured.baseURI="https://api.twitter.com/1.1/search/";
		Response res=given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
		queryParam("q","#Bangalore #Weather").when().
		get("tweets.json").then().extract().response();
		
		String responseString=res.asString();
		JsonPath js=new JsonPath(responseString);
		
		ArrayList<Object> arr=new ArrayList<Object>();
		arr.addAll(js.getList("statuses"));
		Iterator<Object> itr=arr.iterator();
		while(itr.hasNext())
		{
			log.info(itr.next());
		}			
}

@DataProvider
public Object[][] location() {
	
	Object loc[][]= new Object[4][2];
	loc[0][0]="India";
	loc[0][1]="23424848";
	loc[1][0]="US";
	loc[1][1]="23424977";	
	loc[2][0]="UK";
	loc[2][1]="23424975";	
	loc[3][0]="ISRAEL";	
	loc[3][1]="23424852";	
	return loc;
						
}
}
