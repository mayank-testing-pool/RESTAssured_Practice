package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import io.restassured.http.ContentType;
import io.restassured.matcher.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class POSTExamples {

    @Test
    public void test_post ()
    {
        baseURI = "https://reqres.in/api/";
        // Creating JSON body to post
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","mayank");
//        map.put("job","Testing");
//        map.put("name","Tom");
//        map.put("job","Development");
//        System.out.println(map);
//        // Convert map to  JSON format
//        JSONObject request = new JSONObject(map);
//        System.out.println(request.toJSONString());

        // Can also create JSON body as below
        JSONObject request = new JSONObject();
        request.put("name","mayank");
        request.put("job","Testing");
        //request.put("name","Tom");
        //request.put("job","Development");
        System.out.println(request);

        given().
                //header("content-type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/users").
        then().
                statusCode(201).
                log().all();


    }
}
