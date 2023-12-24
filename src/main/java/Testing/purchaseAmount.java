package Testing;

import Files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class purchaseAmount {
    public void validation1()
    {
        JsonPath js = new JsonPath(payload.CoursePrice());
        int count = js.getInt("courses.size()");
        int pAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("The purchase amount is: "+pAmount);
        int sum = 0;

        for (int i = 0; i<count; i++) {
            int price = js.getInt("courses[" + i + "].price");
            int copies = js.getInt("courses[" + i + "].copies");
            int product = price * copies;
            System.out.println(product);
            sum = sum + product;
        }
        System.out.println("The total sum is: "+sum);

        Assert.assertEquals(sum, pAmount);

    }
}
