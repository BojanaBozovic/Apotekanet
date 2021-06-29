package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GalenArticalPage extends BaseHelper
{
   @FindBy(className = "product-price-old2")
   WebElement oldPrice;
   @FindBy(className = "product-price-new")
   WebElement newPrice;
   @FindBy(className = "usteda")
   WebElement differenceInPrice;

   public String oldPriceText;
   public String newPriceText;
   public String differenceInPriceText;

   private void printOldPrice()
   {
    oldPriceText=oldPrice.getText().replace("MP cena:","").replace(".","").replace(",",".").replace("RSD","").trim();
    System.out.println("Old price:"+oldPriceText);
   }
   private void printNewPrice()
   {
    newPriceText=newPrice.getText().replace(".","").replace(",",".").replace("RSD","").trim();
    System.out.println("New price:"+newPriceText);
   }
   private void printDifferenceInPrice()
   {
    differenceInPriceText=differenceInPrice.getText().replace("Vaša ušteda:","").replace(",",".").replace("RSD","").trim();
    System.out.println("Savings:"+differenceInPriceText);
   }
   public void checkPrices()
   {
       printOldPrice();
       printNewPrice();
       printDifferenceInPrice();
   }
    WebDriver driver;
    public GalenArticalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
