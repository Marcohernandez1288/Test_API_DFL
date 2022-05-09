import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPatchEditUser {

	@Test
	public void test_Patch01() {  //Request to update users information
			  
    JSONObject request = new JSONObject();
    
  //This is the body
    request.put("name", "morpheus");
    request.put("job", "leader");
    
    System.out.println(request.toJSONString());
    System.out.println("The user was modified");
    
    given().
    	header("Content Type", "application/json").
    	contentType(ContentType.JSON).
    	accept(ContentType.JSON).
    	body(request.toJSONString()).
    when().
    	patch("https://reqres.in/api/users/2").
    then().
    	statusCode(200).
    	log().all();
    
	}
	
	
}
