package restfulBooker.jsonPath;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class JsonPathDemo {
    @Test
    public void JsonExampleDemo()
    {
        String response="{\n" +
                "  \"array\": [\n" +
                "    1,\n" +
                "    2,\n" +
                "    3\n" +
                "  ],\n" +
                "  \"boolean\": true,\n" +
                "  \"color\": \"gold\",\n" +
                "  \"null\": null,\n" +
                "  \"number\": 123,\n" +
                "  \"object\": {\n" +
                "    \"a\": \"b\",\n" +
                "    \"c\": \"d\"\n" +
                "  },\n" +
                "  \"string\": \"Hello World\"\n" +
                "}";
        JsonPath responseBody =new JsonPath(response);
        ArrayList<String> list= (ArrayList) responseBody.getList("array");
        System.out.println("Array size is " + list.size());
        System.out.println("Array element " + list);

        Boolean boo = responseBody.getBoolean("boolean");
        String str =responseBody.getString("color");
        String nullExample =responseBody.getString("null");
        int intValue =responseBody.getInt("number");
        Object obj= responseBody.get("object");
        String str2= responseBody.getString("string");
        System.out.println("Boolean Value is  " + boo);
        System.out.println("Color value in String  " + str);
        System.out.println("Null example  " + nullExample);
        System.out.println("Integer value " +intValue);
        System.out.println("Object  value" + obj);

    }
}
