package tests.LoginTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Strings;
import tests.BaseTest;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {


    @Test
    /*
        Test steps:
        1.Navigate to home page
        2.Click Prijavi se button
        3.Insert valid email
        4.Insert valid password
        5.Enter submit button
        6.Verify the user is logged in
         */

    public void LoginTest (){
        ChromeDriver driver=openChromeDriver();
        try{
            //create BasePage object

            print("Navigate to home page");
            BasePage BasePage=new BasePage(driver);

            //login as valid user

            print("Click 'prijavi se' button");
            BasePage.clickPrijaviseButton();
            print("Insert email");
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            BasePage.EnterEmailField(Strings.VALID_EMAIL);
            print("Insert password");
            BasePage.EnterPasswordField(Strings.VALID_PASSWORD);
            print("Enter 'submit' button");
            BasePage.EnterSubmitButton();

            //verify that the user is logged in

            print("Verify that the user is logged in");
            assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "Uspešno ste se prijavili. Expected: " + Strings.LOGIN_PAGE_URL    + " . Actual" + driver.getCurrentUrl();
            String actualLoginMessage = BasePage.getTextFromLoginMessage();
            assert actualLoginMessage.equals(Strings.LOGIN_MESSAGE) : "Uspešno ste se prijavili. Expected: " + Strings.LOGIN_MESSAGE
                    + " . Actual: " + actualLoginMessage;
        } finally {


            driver.quit();
        }

    }
    public static class LoginWithInvalidCredentials extends BaseTest {


        @Test
        /*
        Test steps:
        1.Navigate to home page
        2.Click Prijavi se button
        3.Insert valid email
        4.Insert invalid password
        5.Enter submit button
        6.Verify the user is not logged in
         */
        public void LoginWithValidCredentials (){
            ChromeDriver driver=openChromeDriver();
            try{
                //create BasePage object

                print("Navigate to home page");
                BasePage BasePage=new BasePage(driver);

                //insert valid email and invalid password

                print("Click 'prijavi se' button");
                BasePage.clickPrijaviseButton();
                print("Insert valid email");
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                BasePage.EnterEmailField(Strings.VALID_EMAIL);
                print("Insert invalid password");
                BasePage.EnterPasswordField(Strings.INVALID_PASSWORD);
                print("Enter 'submit' button");
                BasePage.EnterSubmitButton();

                //verify that the user is not logged in

                print("Verify that the user is not logged in");
                assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "Email ili šifra su pogrešni! Expected: " + Strings.LOGIN_PAGE_URL    + " . Actual" + driver.getCurrentUrl();
                String incorrectCredentialsMessage = BasePage.getTextFromIncorrectCredentialsMessage();
                assert incorrectCredentialsMessage.equals(Strings.INCORRECT_CREDENTIALS_MESSAGE) : "Email ili šifra su pogrešni! Expected: " + Strings.INCORRECT_CREDENTIALS_MESSAGE
                        + " . Actual: " + incorrectCredentialsMessage;
            } finally {


                driver.quit();
            }

        }


    }


    public static class LoginAndLogoutTest extends BaseTest {


            @Test

            /*
            Test steps:
            1.Navigate to home page
            2.Click Prijavi se button
            3.Insert valid email
            4.Insert valid password
            5.Enter submit button
            6.Enter Moj nalog button
            7.Enter Odjavi se button
            8.Verify the user is logged out
             */

            public void LoginAndLogoutTest (){
                ChromeDriver driver=openChromeDriver();
                try{
                    //kreiramo objekat base stranice

                    print("Navigate to home page");
                    BasePage BasePage=new BasePage(driver);

                    print("Click 'prijavi se' button");
                    BasePage.clickPrijaviseButton();
                    print("Insert email");
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                    BasePage.EnterEmailField(Strings.VALID_EMAIL);
                    print("Insert password");
                    BasePage.EnterPasswordField(Strings.VALID_PASSWORD);
                    print("Enter 'submit' button");
                    BasePage.EnterSubmitButton();
                    print("Enter MojNalog button");
                    BasePage.MojNalogButtonClick();
                    print("Enter Odjavise button");
                    BasePage.OdjaviSeButtonClick();

                    //verify that the user is logged out
                    print("Verify that the user is logged out");

                    assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL);

                }


                finally {
                    driver.quit();
                }
                }}



}

