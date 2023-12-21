package Testing;

import Files.payload;
import Files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutGetExample {
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


        // UPDATE PLACE

        String newAddress = "70 Summer walk, USA";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
                body("{\n" +
                        "\"place_id\":\""+placeID+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n").
                when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        // GET PLACE for validating that the updated address is diplaying in get method

        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID).
                when().get("maps/api/place/get/json").

                then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js1 = reusableMethods.rawToJson(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, "70 Summer walk, USA", "Actual address does not match the expected address.");
        System.out.println("Address assertion successfully passed. Test Passed!");


    }
}
