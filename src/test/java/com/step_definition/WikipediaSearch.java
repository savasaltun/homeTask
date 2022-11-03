package com.step_definition;

import com.pages.WikipediaSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikipediaSearch {

    WikipediaSearchPage wikipediaSearch = new WikipediaSearchPage();

    @When("User writes {string}")
    public void user_writes(String string) {
        wikipediaSearch.searchInput.sendKeys(string);

    }

    @And("User clicks search button")
    public void user_clicks_search_button() throws InterruptedException {
        Thread.sleep(3000);
        wikipediaSearch.searchButton.click();
    }

    @Then("verify that User should be able to see the page title")
    public void verify_that_user_should_be_able_to_see_the_page_title() {

        String expectedTitle = "William Shakespeare";
        String actualTitle = wikipediaSearch.williamShakespeareTitle.getText();

        Assert.assertEquals(expectedTitle, actualTitle);

    }

}
