package DomaceTests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import DomacePages.RegistrujSePage;
import pages.Strings;

public class SignInWithInvalidCredentials extends BaseTest {

    @Test

    public void SignInWithInvalidCredentials () {
        ChromeDriver driver=openChromeDriver();
        try {
            /*test steps
            1.Click registruj se button
            2.Insert valid name
            3.Insert invalid email
            4.Insert invalid password
            5.Repeat invalid password
            6.Insert invalid result
            7.Click submit button

             Expected results:
             The user is NOT signed in
             */
            //create RegistrujsePage object
            RegistrujSePage registrujSePage=new RegistrujSePage(driver);
            print("Click 'Registruj se'button");
            registrujSePage.ClickRegistrujSeButton();
            print("Insert valid name");
            registrujSePage.InsertVaseImeField(Strings.VALID_NAME);
            print("Insert valid email");
            registrujSePage.InsertEmailField(Strings.INVALID_EMAIL);
            print("Insert valid password");
            registrujSePage.InserSifraField(Strings.VALID_PASSWORD);
            print("Repeat valid password");
            registrujSePage.InsertPonoviteSifruField(Strings.VALID_PASSWORD);
            print("Insert invalid result");
            registrujSePage.InsertUnesiteRezultatField (Strings.INVALID_RESULT);
            print("Click submit button");
            registrujSePage.ClickRegistrujSeSubmitButton();

            print("Verify that the user is NOT signed in");

            String actualErrorMessage = registrujSePage.getText ();
            assert actualErrorMessage.equals(Strings.ERROR_MESSAGE) : "Rezultat nije tacan. Expected: " + Strings.ERROR_MESSAGE
                    + " . Actual: " + actualErrorMessage;
        } finally {
            driver.quit();
        }



    }}
