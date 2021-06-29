package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class GalenBonesPage extends BaseHelper
{
    @FindBy(xpath = "/html/body/div[4]/div/div/div/div[3]/div[2]/div[2]/div/div[1]/div[2]/span/b")
    WebElement discount;
    @FindBy(className = "product-grid")
    WebElement bonesArticles;

    public String discountText;
    public String webPriceText;

    private void printPercentageReduction()
    {
        discountText = discount.getText().replace("-","").replace("%","").trim();
        System.out.println("Percentage reduction:"+discountText);

        List<WebElement>articlesPrices = bonesArticles.findElements(By.className("price"));
        webPriceText = articlesPrices.get(1).getText().replace(".","").replace(",",".").replace("RSD","").trim();
        System.out.println("Web price:"+webPriceText);
    }
    private void chooseBoneArtical()
    {
        List<WebElement>boneArtical=bonesArticles.findElements(By.className("product-layout"));
        boneArtical.get(1).click();
    }
    public void chooseArtical()
    {
        printPercentageReduction();
        chooseBoneArtical();
    }
    WebDriver driver;
    public GalenBonesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
