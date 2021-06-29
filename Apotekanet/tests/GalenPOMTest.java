package tests;

import com.sun.deploy.security.SelectableSecurityManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import static org.junit.Assert.*;

public class GalenPOMTest extends BaseTest
{
    @Test
    public void articlesApperenceTest() throws InterruptedException
    {
        String term = "AVENE";
        GalenHomePage homepage = new GalenHomePage(driver);
        homepage.articlesAppears(term);

        GalenArticlesPage articles = new GalenArticlesPage(driver);
        articles.chooseArticlesNumberOnPage();
        int articlesCounter = Integer.parseInt(articles.itemsCounter);
        int articlesOnPagee = Integer.parseInt(String.valueOf(articles.articlesOnPage));
        assertEquals("Not correct appears!", articlesOnPagee, articlesCounter);

        Thread.sleep(3000);
    }

    @Test
    public void webPriceTest() throws InterruptedException
    {
        String term = "kosti";
        GalenHomePage homepageWebPrice = new GalenHomePage(driver);
        homepageWebPrice.articlesAppears(term);

        wdWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/div[3]/div[2]/div[9]/div/div[2]/div[2]/a")));
        GalenBonesPage bonespage = new GalenBonesPage(driver);
        bonespage.chooseArtical();

        GalenArticalPage articalpage = new GalenArticalPage(driver);
        articalpage.checkPrices();
        double webPrice = Double.parseDouble(bonespage.webPriceText);
        double oldPrice = Double.parseDouble(articalpage.oldPriceText);
        double newPrice = Double.parseDouble(articalpage.newPriceText);
        double savings = Double.parseDouble(articalpage.differenceInPriceText);
        double percentageDiscount = Double.parseDouble(bonespage.discountText);

        assertTrue("Incorrect calculation for discount!", savings==percentageDiscount*oldPrice/100);
        assertEquals("Incorrect new price!", newPrice, oldPrice - savings, 0.0);
        assertFalse("Incorrect web price!", newPrice != webPrice);

        Thread.sleep(3000);
    }
    @Test
    public void checkBill() throws InterruptedException
    {
        GalenHome2Page home2Page = new GalenHome2Page(driver);
        home2Page.chooseCosmeticArtical();

        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("product-grid")));
        GalenCosmeticArticlesPage cosmeticpage = new GalenCosmeticArticlesPage(driver);
        cosmeticpage.chooseCosmeticArtical();

        GalenBasketPage basketpage = new GalenBasketPage(driver);
        basketpage.checkTotalBill();

        double webPrice = Double.parseDouble(cosmeticpage.priceOnPageText);
        double unitPrice = Double.parseDouble(basketpage.unitPriceText);
        Assert.assertTrue("Not correct unit price!", webPrice==unitPrice);

        double totalBill = Double.parseDouble(basketpage.totalBillText);
        Assert.assertTrue("Not correct total bill!", totalBill==2.00*unitPrice);


















     Thread.sleep(3000);
    }
}
