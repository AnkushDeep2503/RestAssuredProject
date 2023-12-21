package Testing;

import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetPostPutRestExample {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.addPlace())

                .when().post("/maps/api/place/add/json")

                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

        System.out.println(response);

        JsonPath js = new JsonPath(response); // for parsing Json
        String placeID = js.getString("place_id"); //we have put js.getString with argument path inside a variable String placeID
        System.out.println("The retrieved place id is: --> " +
                ""+ placeID);
    }
}
