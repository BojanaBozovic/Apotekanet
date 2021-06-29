package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GalenHome2Page extends BaseHelper
{
    @FindBy(className = "desktop-main-menu-wrapper")
    WebElement leftMidBar;
    @FindBy(xpath = "/html/body/div[4]/header/div[1]/div[2]/div[1]/div[2]/ul/li[1]/div/div/ul/li[3]")
    WebElement cosmeticButton;

    private void navigateToHomepage()
    {
        driver.get("https://www.apotekanet.rs/");
    }
    private void chooseProductButton()
    {
       List<WebElement>specialPrice = leftMidBar.findElements(By.tagName("li"));
       specialPrice.get(1).click();
    }
     private void clickOnCosmeticButton()
     {
         wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/header/div[1]/div[2]/div[1]/div[2]/ul/li[1]/div/div/ul/li[3]")));
         cosmeticButton.click();
     }

    public void chooseCosmeticArtical()
    {
        navigateToHomepage();
        chooseProductButton();
        clickOnCosmeticButton();
    }
    WebDriver driver;
    public GalenHome2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
