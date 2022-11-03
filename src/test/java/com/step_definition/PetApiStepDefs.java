package com.step_definition;

import com.utilities.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.*;
public class PetApiStepDefs {

    Response response;
    RequestSpecification specification;
    int idOfCreatedPet;
    @Given("the user create a pet")
    public void the_user_create_a_pet() {

        String body="{\n" +
                "  \"id\": 123,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Av\"\n" +
                "  },\n" +
                "  \"name\": \"Doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
  requestSpecification= given().accept(ContentType.JSON).and().contentType(ContentType.JSON);
        response =
                requestSpecification.body(body).post(ApiUtils.getBaseUrl()+"pet").then().statusCode(200).extract().response();
        JsonPath jsonPath = response.jsonPath();
      idOfCreatedPet = jsonPath.getInt("id");

    }
    String nameOfDog;
    String actualStatus;
    @When("the user get the created pet")
    public void the_user_get_the_created_pet() {

        Response response1 = requestSpecification
                .pathParam("id", idOfCreatedPet)
                .get(ApiUtils.getBaseUrl()+"pet/{id}")
                .then()
                .statusCode(200)
                .extract().response();
        JsonPath jsonPath1 = response1.jsonPath();
      nameOfDog = jsonPath1.getString("name");
        actualStatus = jsonPath1.getString("status");


    }

    @Then("verify that name is equal")
    public void verify_that_name_is_equal() {
        Assert.assertEquals("Doggie",nameOfDog);
    }
    @Then("status is {string}")
    public void status_is(String expecetedStatus) {
Assert.assertEquals(expecetedStatus,actualStatus);
    }


}
