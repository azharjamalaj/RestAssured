package restfulBooker.jsonPath;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class JsonExampleWIthFilter {
    @Test
    public void jsonExampleUsingFilter()
    {
        String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\restfulBooker\\jsonPath\\payload.json";
        System.out.println(filePath);
        File file= new File(filePath);
        JsonPath json = new JsonPath(file);

        System.out.println(json.getString("email"));
        List<String> listOfEmail = json.getList("email");

        System.out.println(listOfEmail);

       List<String> list_firstNameFilter =json.getList("findAll{it.first_name=='Matin' ||it.last_name=='Matin'}");
        System.out.println(list_firstNameFilter);

    }
}
