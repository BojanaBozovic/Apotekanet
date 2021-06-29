package pages;

import helpers.BaseHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;


import java.util.List;

public class GalenCosmeticArticlesPage extends BaseHelper
{
    @FindBy(xpath = "/html/body/div[4]/div/div/div/div/div[2]/div[11]/div/div[2]/div[6]/div/div[1]/a")
    WebElement addToBasketArtical;
    @FindBy(className = "notification-view-cart")
    WebElement navigateToBasketButton;
    @FindBy(className = "price-normal")
    WebElement price;

    public String priceOnPageText;

    private void printWebPrice()
    {
        priceOnPageText = price.getText().replace(".","").replace(",",".").replace("RSD","").trim();
        System.out.println("Web price:"+priceOnPageText);
    }
    private void clickOnArtical()
    {
      Actions actions = new Actions(driver);
      actions.moveToElement(price);
      actions.clickAndHold();
      actions.moveToElement(addToBasketArtical);
      actions.click().perform();
      wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/div/div[2]/div[11]/div/div[2]/div[6]/div/div[1]/a")));
      js.executeScript("arguments[0].click();",addToBasketArtical);
    }
    private void clickOnNavigateToBasket()
    {
      wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-view-cart")));
      navigateToBasketButton.click();
    }
   public void chooseCosmeticArtical()
    {
       printWebPrice();
       clickOnArtical();
       clickOnNavigateToBasket();
    }
    WebDriver driver;
    public GalenCosmeticArticlesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
