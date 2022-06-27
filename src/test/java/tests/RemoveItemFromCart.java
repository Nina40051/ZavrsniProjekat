package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;


import java.util.concurrent.TimeUnit;

public class RemoveItemFromCart extends BaseTestIkea {

    @Test
    public void RemoveItemFromCart (){
        ChromeDriver driver=openChromeDriver();
        try {

            print("Navigate to homepage");
            //create IkeaBasePage object
            IkeaBasePage ikeaBasePage=new IkeaBasePage(driver);
            //insert text in search field and click search button
            print("Insert text in search field");
            ikeaBasePage.InsertTextInSearchField("sto");
            ikeaBasePage.ClickCookiesButton();

            IkeaSearchProductsPage ikeaSearchProductsPage=new IkeaSearchProductsPage(driver);

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


            ikeaSearchProductsPage.ClickPomocniStocicButton();
            //ikeaSearchProductsPage.waitFOrElement("");

            PomocniStocicPage pomocniStocicPage=new PomocniStocicPage(driver);
            pomocniStocicPage.ClickDodajUKorpu();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            pomocniStocicPage.ClickNastavinaKorpu();

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            ShoppingCartPage shoppingCartPage=new ShoppingCartPage();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            shoppingCartPage.ClickDropDownMenuButton();

            assert driver.getCurrentUrl().equals(Strings.SHOPPING_CART_URL) : "Tvoja korpa je prazna Expected: " + Strings.SHOPPING_CART_URL    + " . Actual" + driver.getCurrentUrl();
            String actualShoppingCartMessage = shoppingCartPage.getTextFromEmptyCartMessage();
            assert actualShoppingCartMessage.equals(Strings.SHOPPING_CART_MESSAGE) : "Tvoja korpa je prazna Expected: " + Strings.SHOPPING_CART_MESSAGE
                    + " . Actual: " + actualShoppingCartMessage;



        }
        finally

        {driver.quit();
        }
    }
}
