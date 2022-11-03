package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchPage {

    public WikipediaSearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="searchInput")
    public WebElement searchInput;


    @FindBy(xpath ="//i[@class='sprite svg-search-icon']")
    public WebElement searchButton;


    @FindBy(xpath ="//span[.='William Shakespeare']")
    public WebElement williamShakespeareTitle;

}
