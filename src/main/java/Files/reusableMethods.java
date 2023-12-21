package Files;

import io.restassured.path.json.JsonPath;

public class reusableMethods {

    public static JsonPath rawToJson(String getPlaceResponse)
    {
        JsonPath js1 = new JsonPath(getPlaceResponse);
        return js1;
    }
}
