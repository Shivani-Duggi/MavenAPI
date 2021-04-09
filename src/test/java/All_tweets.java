

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

 

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class All_tweets {
	
		String ConsumerKey="7C1las31LFZ1sqh8VOHkhAI8M";
		String ConsumerSecret="i8cjjdZIbJwcWhDy0oATBfeOztJ7CNAK82YQcUVMfdg0NKOE7p";
		String Token="1366702057093099523-vcxMlPU6tkUOgH6VU80AyhVZXFtqKY";
		String TokenSecret="o7RsPSdjhEUC9jbXU1HgY40uiWewgJE5NdD3obQc5XpRy";
		
		 private static Logger log=LogManager.getLogger(All_tweets.class.getName());

       
     public Properties prop;
        @Test    
        public void Tweet() throws IOException
        {
            prop=new Properties();
            FileInputStream fis=new FileInputStream("C:\\Selenium projects\\APIAutomation\\src\\files\\data.properties");
            prop.load(fis);
            RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
            Response res=given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
        	//queryParam("count","1").
            when().get("/home_timeline.json").then().extract().response();
            
            String response=res.asString();
            log.info(response);
            JsonPath js=new JsonPath(response);
            String id= js.get("id").toString();
            log.info(id);
            String text= js.get("text").toString();
            log.info(text);
    
                        
        }
    }