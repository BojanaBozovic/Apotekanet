package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.WeakHashMap;

public class GalenHomePage extends BaseHelper
{
    @FindBy(name = "search")
    WebElement searchField;
    @FindBy(className = "search-button")
    WebElement searchButton;

    private void navigateToHomepage()
    {
        driver.get("https://www.apotekanet.rs/");
    }
    private void enterTerm(String term)
    {
        searchField.sendKeys(term);
    }
    private void clickOnSearchButton()
    {
        searchButton.click();
    }
   public void articlesAppears(String term)
   {
       navigateToHomepage();
       enterTerm(term);
       clickOnSearchButton();
   }
    WebDriver driver;
    public GalenHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
