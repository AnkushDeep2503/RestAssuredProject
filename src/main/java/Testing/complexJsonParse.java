package Testing;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class complexJsonParse {

    public static void main(String[] args) {

        JsonPath js = new JsonPath(payload.CoursePrice());

        // print number of courses returned by API
        int count = js.getInt("courses.size()");
        System.out.println("The total number of courses are: " + count);

        //print purchase amount
        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("The purchase aount is: " + totalAmount);

        String titleName = js.getString("courses[0].title");
        String titleName1 = js.getString("courses[1].title");
        String titleName2 = js.getString("courses[2].title");
        System.out.println(titleName);
        System.out.println(titleName1);
        System.out.println(titleName2);


        System.out.println("####################################################################");

        for (int i = 0; i < count; i++) {
            String titleNames = js.getString("courses[" + i + "].title");
            int totalCopies = js.getInt("courses[" + i + "].copies");
            int prices = js.getInt("courses[" + i + "].price");

            System.out.println(titleNames + ": The price is: " + prices + " and total copies are: " + totalCopies);

            //print the specific title and its price
        }

        System.out.println("Printing the specific title and its price");
        for(int i = 0; i<count; i++){
            String titleNames = js.getString("courses[" + i + "].title");
            if (titleNames.equalsIgnoreCase("python developer"))
            {
                int totPrice = js.getInt("courses["+i+"].price");
                System.out.println("The price for course "+titleNames+" is "+totPrice+"");
            }
        }

        System.out.println("");
    }
}
