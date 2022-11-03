package com.step_definition;

import com.utilities.ApiUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class UserApiStepDefs {
    int actualCode;
    @When("the user create a user")
    public void the_user_create_a_user() {
        String user="{\n" +
                "  \"id\": 1,\n" +
                "  \"username\": \"Savas123\",\n" +
                "  \"firstName\": \"Savas\",\n" +
                "  \"lastName\": \"Altun\",\n" +
                "  \"email\": \"as@gmail.com\",\n" +
                "  \"password\": \"Test1234\",\n" +
                "  \"phone\": \"00000000\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        Response response3 =
                given().accept(ContentType.JSON).and().contentType(ContentType.JSON).body(user).post(ApiUtils.getBaseUrl()+"user").then().statusCode(200).extract().response();
        JsonPath jsonPath = response3.jsonPath();
        actualCode = jsonPath.getInt("code");
    }
    @Then("verify that user is created and code is {int}")
    public void verify_that_user_is_created(int expectedCode) {
        Assert.assertEquals(expectedCode,actualCode);
    }
}
