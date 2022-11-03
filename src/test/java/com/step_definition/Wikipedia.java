package com.step_definition;

import com.pages.WikipediaPage;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class Wikipedia {

WikipediaPage wikipedia = new WikipediaPage();

    @Given("user navigate to wikipedia")
    public void user_navigate_to_wikipedia() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("User can verify the Wikipedia logo")
    public void user_can_see_the_wikipedia_title() {

        String expectedLogo = "Wikipedia";
        String actualLogo = wikipedia.wikipediaTitle.getText();

        assertEquals(expectedLogo, actualLogo);


    }

}
