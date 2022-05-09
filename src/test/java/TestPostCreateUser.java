import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import io.restassured.http.ContentType;


public class TestPostCreateUser {

	@Test
	public void test_Post01() {  //Request to register users
			  
    JSONObject request = new JSONObject();
    
    //This is the body
    request.put("name", "morpheus");
    request.put("job", "leader");
    
    System.out.println(request.toJSONString());
    System.out.println("The user was created");
    
    given().
    	header("Content Type", "application/json").
    	contentType(ContentType.JSON).
    	accept(ContentType.JSON).
    	body(request.toJSONString()).
    when().
    	post("https://reqres.in/api/users/23").
    then().
    	statusCode(201);
    
	}
	
	@Test
	public void test_Post02() {  //Request to register a user - unsuccessful
		  
	    JSONObject request = new JSONObject();
	    
	  //This is the body
	    request.put("email", "sydney@fife");
	    	    
	    System.out.println(request.toJSONString());
	    System.out.println("The password is missing");
	    
	    given().
	    	header("Content Type", "application/json").
	    	contentType(ContentType.JSON).
	    	accept(ContentType.JSON).
	    	body(request.toJSONString()).
	    when().
	    	post("https://reqres.in/api/register").
	    then().
	    	statusCode(400);
	    
		}
}
