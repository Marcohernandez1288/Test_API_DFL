import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestGetUsers {

	@Test
	public void test_Get01() {   //Request to get data user

		given()
			.when()
		.get("https://reqres.in/api/users?page=2")
			.then()
		.statusCode(200)
		.body("data.id[1]", equalTo (8));

	}

	@Test
	public void test_Get02() {    //Request to get data user that not exist

		given()
			.when()
		.get("https://reqres.in/api/users/23")
			.then()
		.statusCode(404);
	}

}
