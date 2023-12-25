package Testing;

import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/* Important Note: This code is specifically for passing json file directly in the body
* instead of copying json in the file */

public class staticJsonFileAsPathInBody {

        public static void main(String[] args) throws IOException {

            String JsonFilePath = "C:\\Users\\nkusm\\Downloads\\jsonformatter01.json";
            Path path = Paths.get(JsonFilePath);
            String jsonContent = new String (Files.readAllBytes(path));
            System.out.println(jsonContent+"<<<<This one====>>>>");
            RestAssured.baseURI = "https://rahulshettyacademy.com";

            String response = given().log().all().queryParam("key", "qaclick123")
                    .header("Content-Type", "application/json")
                    .body(jsonContent)

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

