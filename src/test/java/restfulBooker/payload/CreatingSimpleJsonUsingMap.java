package restfulBooker.payload;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CreatingSimpleJsonUsingMap {
    @Test
    public void mainMethod()
    {
        Map<String,Object> jsonMap= new LinkedHashMap<String,Object>();
        Map<String,Object> addressMap= new LinkedHashMap<String,Object>();
        jsonMap.put("id",101);
        jsonMap.put("first_name","Azhar");
        jsonMap.put("last_name","Jamal");
        jsonMap.put("Gender",'M');
        addressMap.put("flat","Heaven Apartment");
        addressMap.put("city","Bangalore");
        addressMap.put("state", "Karnataka");
        jsonMap.put("address",addressMap);
        String str=jsonMap.toString();

       // RestAssured.given().log().all().body(jsonMap).when().post();
        RestAssured.given().log().all().body(str).contentType(ContentType.JSON).when().post();

    }

    @Test
    public void jsonAsArray()
    {
        Map<String,Object> jsonMap= new LinkedHashMap<String,Object>();
        Map<String,Object> jsonMap2= new LinkedHashMap<String,Object>();
        jsonMap.put("id",101);
        jsonMap.put("first_name","Azhar");
        jsonMap.put("last_name","Jamal");
        jsonMap.put("Gender",'M');

        jsonMap2.put("id",102);
        jsonMap2.put("first_name","Nadia");
        jsonMap2.put("last_name","Jamal");
        jsonMap2.put("Gender",'F');

        List<Map<String,Object>> list =new ArrayList<>();
        list.add(jsonMap);
        list.add(jsonMap2);

        System.out.println(list);
        String str=list.toString();
        RestAssured.given().log().all().body(str).when().post();

    }
}
