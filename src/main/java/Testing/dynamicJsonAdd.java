package Testing;

import Files.payload;
import Files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class dynamicJsonAdd {
    @Test(dataProvider="BooksData")
    public void addBook(String isbn, String aisle)

    {
        RestAssured.baseURI = "http://216.10.245.166";
        Response response = given().header("Content-Type", "application/json").body(payload.addBook(isbn, aisle))
                .when().post("Library/Addbook.php").
                then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());

        JsonPath js = reusableMethods.rawToJson(response.asString());
        String id = js.get("ID");
        String msg = js.getString("Msg");
        System.out.println(msg +" and its ID is: "+ id);

    }

    @DataProvider(name="BooksData")
    public Object[][] getData()
    {
        return new Object[][] {{"aksda", "8877"},{"sdwer", "4534"},{"sdwqe", "9998"}};
    }
}
