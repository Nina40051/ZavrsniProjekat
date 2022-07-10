package IkeaTests.IkeaInventoryTests;

import IkeaTests.BaseTestIkea;
import org.openqa.selenium.WebElement;
import pages.Strings;
import IkeaPages.IkeaBasePage;
import IkeaPages.IkeaSearchProductsPage;
import IkeaPages.PomocniStocicPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class RemoveItemFromCart extends BaseTestIkea {

    @Test
    public void RemoveItemFromCart (){
        ChromeDriver driver=openChromeDriver();
        try {
            /*
            Test steps:
            1.Navigate to homepage
            2.Insert text in search field
            3.Enter search button
            4.Enter PomocniStocic button
            5.Enter DodajUKorpu button
            6.Enter NastaviNaKorpu button
            7.Enter UkloniProizvod button

             Expected results:
             The shopping cart is empty.
             */

            print("Navigate to homepage");
            //create IkeaBasePage object
            IkeaBasePage ikeaBasePage=new IkeaBasePage(driver);
            //insert text in search field and click search button
            print("Insert text in search field");
            ikeaBasePage.InsertTextInSearchField("sto");
            //accept cookies
            ikeaBasePage.ClickCookiesButton();

            //create IkeaSearchProductsPage object
            IkeaSearchProductsPage ikeaSearchProductsPage=new IkeaSearchProductsPage(driver);
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            print("Enter PomocniStocic button");
            ikeaSearchProductsPage.ClickPomocniStocicButton();

            //create PomocniStocicPage object
            PomocniStocicPage pomocniStocicPage=new PomocniStocicPage(driver);
            print("Enter DodajUKorpu button");
            pomocniStocicPage.ClickDodajUKorpu();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            print("Enter NastaviNaKorpu button");
            pomocniStocicPage.ClickNastavinaKorpu();

            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            print("Enter UkloniProizvod button");
            pomocniStocicPage.ClickUkloniProizvodButton();

            print("Verify that the shopping cart is empty. 'Tvoja korpa je prazna' message should be dislayed");
            assert driver.getCurrentUrl().equals(Strings.SHOPPING_CART_URL) : "Tvoja korpa je prazna Expected: " + Strings.SHOPPING_CART_URL    + " . Actual" + driver.getCurrentUrl();
            String actualShoppingCartMessage = pomocniStocicPage.getTextFromEmptyCartMessage();
            assert actualShoppingCartMessage.equals(Strings.SHOPPING_CART_MESSAGE) : "Tvoja korpa je prazna Expected: " + Strings.SHOPPING_CART_MESSAGE
                    + " . Actual: " + actualShoppingCartMessage;



        }
        finally

        {driver.quit();
        }
    }
}
