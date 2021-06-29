package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GalenBasketPage extends BaseHelper
{
    @FindBy(className = "form-control")
    WebElement quantity;
    @FindBy(className = "fa-refresh")
    WebElement refreshButton;

    public String unitPriceText;
    public String totalBillText;

    private void changeQuantity()
    {
        quantity.click();
        quantity.clear();
        wdWait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("form-control"),""));
        quantity.sendKeys("2");
    }
    private void refreshBasket()
    {
        refreshButton.click();
    }
    private void printPrice()
    {
        WebElement unitPrice = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div/form/div/table/tbody/tr/td[5]"));
        unitPriceText = unitPrice.getText().replace(".","").replace(",",".").replace("RSD","").trim();
        System.out.println("Unit price:"+unitPriceText);

        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div/form/div/table/tbody/tr/td[6]"),"3493.35 RSD"));
        WebElement totalBill = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div/div/div/div[1]/div[2]/table/tbody/tr[2]/td[2]"));
        totalBillText = totalBill.getText().replace(".","").replace(",",".").replace("RSD","").trim();
        System.out.println("Total bill:"+totalBillText);

    }
    public void checkTotalBill()
    {
        changeQuantity();
        refreshBasket();
        printPrice();
    }
    WebDriver driver;
    public GalenBasketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
