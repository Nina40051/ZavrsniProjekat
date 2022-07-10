package DomacePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.NumberFormat;

public class RegistrujSePage {

    ChromeDriver driver = null;

    @FindBy(xpath = "//a[@class='btn register-btn']")
    WebElement RegistrujSeButton;

    @FindBy (xpath = "//input[@id='name']")
    WebElement VaseImeField;
    
    @FindBy (xpath = "//input[@id='newemail']")
    WebElement EmailField;

    @FindBy (xpath = "//input[@id='newpwd']")
    WebElement SifraField;

    @FindBy (xpath = "//input[@name='password_confirmation']")
    WebElement PonoviteSifruField;

    @FindBy (xpath = "//input[@name='rezultat']")
    WebElement UnesiteRezultatField;

    @FindBy (xpath= "//button[@class='btn modal-submit-register-btn']")
    WebElement RegistrujSeSubmitButton;

    @FindBy (xpath = ("//ul[@class='errors_holder']"))
    WebElement ErrorMessage;

    public RegistrujSePage (ChromeDriver driver) {
    driver.get("https://www.domaceizsrbije.rs/");
    PageFactory.initElements(driver, this);
    this.driver = driver;
}

    public void ClickRegistrujSeButton (){
    RegistrujSeButton.click();
}

    public void InsertVaseImeField (String ime){
    VaseImeField.click();
    VaseImeField.sendKeys(ime);

}
    public void InsertEmailField (String email){
        EmailField.click();
        EmailField.sendKeys(email);


}
    public void InserSifraField (String sifra) {
        SifraField.click();
        SifraField.sendKeys(sifra);

    }

    public void InsertPonoviteSifruField (String ponovitesifru) {
        PonoviteSifruField.click();
        PonoviteSifruField.sendKeys(ponovitesifru);

    }

    public void InsertUnesiteRezultatField (String rezultat) {
        int number=Integer.parseInt(rezultat);
        UnesiteRezultatField.click();
        UnesiteRezultatField.sendKeys(rezultat);

    }
    public void ClickRegistrujSeSubmitButton () {
        RegistrujSeSubmitButton.click();

    }

    public String getText (){ return ErrorMessage.getText(); }

}