package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class GalenArticlesPage extends BaseHelper
{
   @FindBy(id = "input-limit")
   WebElement counterArticles;

   public String itemsCounter;
   public int articlesOnPage;

   private void clickOnCounterArticles()
   {
       wdWait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("page-title"), "Pretraga - AVENE"));
       counterArticles.click();
   }
   private void choose25ArticlesOnPage()
   {
       wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/div[3]/div[1]/div[2]/div[2]/select/option[2]")));
       Select drpCounter = new Select(driver.findElement(By.id("input-limit")));
       drpCounter.selectByVisibleText("25");
       itemsCounter = counterArticles.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/div[1]/div[2]/div[2]/select/option[2]")).getText();
       System.out.println("Articles counter:"+itemsCounter);
   }
   public void chooseArticlesNumberOnPage()
   {
       clickOnCounterArticles();
       choose25ArticlesOnPage();

       wdWait.until(ExpectedConditions.refreshed(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("product-layout"), 16)));
       WebElement articlesList = driver.findElement(By.className("product-grid"));
       List<WebElement> allArticlesOnPage=articlesList.findElements(By.className("product-layout"));

       System.out.println("Articles number on page:"+allArticlesOnPage.size());
       articlesOnPage = allArticlesOnPage.size();
   }
    WebDriver driver;

    public GalenArticlesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
