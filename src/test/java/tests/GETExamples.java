package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import io.restassured.matcher.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETExamples {
    @Test
    public void test_1()
    {
        Response response = get("https://reqres.in/api/users?page=2");
        int statuscode = response.getStatusCode();
        System.out.println (statuscode);
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        Assert.assertEquals(statuscode,200);
    }

    @Test
    public void test_2()
    {
        baseURI = "https://reqres.in/api/users?page=2";
        given().
                get(baseURI).
        then().
                assertThat().
                statusCode(200).
                body("data[1].id",equalTo(8)).
                body("data.first_name",hasItems("Michael", "Lindsay")).
                body("data.last_name",hasItems("Funke", "Fields")).
                log().all();
    }

}
