package Testing;

import Files.payload;
import Files.reusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class dynamicJsonDelete {
    @Test(dataProvider ="BooksData")
    public void deleteBook(String bookId)
    {
        RestAssured.baseURI = "http://216.10.245.166";
        Response resp = given().log().all().header("Content-Type", "application/json").body(payload.deleteBook(bookId)).
                when().post("/Library/DeleteBook.php").
                then().assertThat().statusCode(200).extract().response();
        System.out.println(resp);
        JsonPath js = reusableMethods.rawToJson(resp.asString());
        String message = js.getString("msg");
        System.out.println("Message: --> "+bookId+ "  "+message);

    }

    @DataProvider(name="BooksData")
    public Object[] getData()
    {
        return new Object[] {"aksda8877", "sdwer4534", "sdwqe9998"};
    }
}
