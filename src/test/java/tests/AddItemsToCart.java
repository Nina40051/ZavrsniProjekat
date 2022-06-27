package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.IkeaBasePage;
import pages.IkeaSearchProductsPage;
import pages.Strings;

import java.util.concurrent.TimeUnit;

public class AddItemsToCart extends BaseTestIkea {

    @Test
    public void AddItemsToCart (){

        /*
        Test steps:
        1.Navigate to homepage
        2.Insert text in search field
        3.Enter search button
        4.Enter add to cart button
        5.Verify that the shopping cart icon displays number 1
         */
        ChromeDriver driver=openChromeDriver();
        try {

            print("Navigate to homepage");
            //create IkeaBasePage object
            IkeaBasePage ikeaBasePage=new IkeaBasePage(driver);
            //accept cookies
            ikeaBasePage.ClickCookiesButton();
            //insert text in search field and click search button
            print("Insert text in search field");
            ikeaBasePage.InsertTextInSearchField("sto");
            print("Enter search button");
            ikeaBasePage.ClickSearchButton();

            //create IkeaSearchProductsPage object
            IkeaSearchProductsPage ikeaSearchProductsPage=new IkeaSearchProductsPage(driver);
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            print("Enter add to cart button");
            ikeaSearchProductsPage.ClickAddToCartButton();


            print("Verify that the shopping cart icon displays number 1");
            String actualNumberFromC=ikeaSearchProductsPage.getNumberFromShoppingCartIcon();
            print("The number in the shopping cart equals one");
            assert actualNumberFromC.equals("1"):"Wrong number in the shopping cart";

        }
    finally

    {driver.quit();
    }
    }}


