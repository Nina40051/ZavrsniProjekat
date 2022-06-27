package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class CheckingVidiProizvodButton extends BaseTest {


    @Test

    public void CheckingVidiProizvodButton (){
        ChromeDriver driver=openChromeDriver();
        try {
            /*
            test steps:
            1.Navigate to home page
            2.Login
            3.Click 'Pretraga' field and insert 'sir'
            4.Click 'Search' button
            5.Click 'Vidi proizvod' button
            6.Verify that the user is navigated to the actual page
             */
            //create PretragaPage object
            ProizvodiPretragaPage proizvodiPretragaPage=new ProizvodiPretragaPage(driver);


            print("Navigate to home page");
            BasePage BasePage=new BasePage(driver);

            //log in with valid credentials

            print("Click 'prijavi se' button");
            BasePage.clickPrijaviseButton();
            print("Insert email");
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            BasePage.EnterEmailField(Strings.VALID_EMAIL);
            print("Insert password");
            BasePage.EnterPasswordField(Strings.VALID_PASSWORD);
            print("Enter 'submit' button");
            BasePage.EnterSubmitButton();

            //send text to 'Pretraga' field and click search button
            print ("Click 'Pretraga' field and insert 'sir'");
            BasePage.EnterPretragaField("sir");
            print ("Click 'Search' button");
            BasePage.ClickSearchButton();

            print("Click 'Vidi proizvod' button");
            proizvodiPretragaPage.ClickCherryButton();

            print("Verify that the user is navigated to the actual page");
            String currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals(Strings.CHERRYTOMATO_PAGE_URL) : "Error. Wrong url . Expected: " + Strings.CHERRYTOMATO_PAGE_URL + "  . Actual :" + currentUrl;

        } finally {


            driver.quit();
        }}}
