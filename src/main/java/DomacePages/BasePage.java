package DomacePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    ChromeDriver driver = null;

//pronalazimo i pravimo webelemente na login stranici

    @FindBy(xpath = "//a[@class='btn login-btn']")
    WebElement PrijaviseButton;


    @FindBy(xpath = "//input[@id='email']")
    WebElement EmailField;

    @FindBy(xpath = "//input[@id='pwd']")
    WebElement PasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement SubmitButton;

    @FindBy(xpath = "//input[@name='pretraga']")
    WebElement PretragaField;

    @FindBy(xpath ="//a[@class='btn card-btn']")
    WebElement NaruciButton;

    @FindBy(xpath ="//a[@href='#']")
    WebElement SuperhranaMenuButton;

    @FindBy(xpath="//a[@href='https://www.domaceizsrbije.rs/proizvodi/kategorija/kakao-proizvodi']")
    WebElement KakaoProizvodiButton;

    @FindBy (xpath="//span[@class='glyphicon glyphicon-search']")
    WebElement SearchButton;


   @FindBy (xpath=("//ul[@style='list-style:none;text-align:center;']"))
    WebElement LoginMessage;

   @FindBy (xpath=("//li[text()='Email ili šifra su pogrešni!']"))
   WebElement IncorrectCredentialsMessage;

    @FindBy (xpath = ("//div[@class='btn auth-dropdown-btn']"))
            WebElement MojNalogButton;

    @FindBy (xpath=("//li/a[@href='https://www.domaceizsrbije.rs/odjava']"))
    WebElement OdjaviSeButton;



    //konstruktor

    public BasePage(ChromeDriver driver) {
        driver.get("https://www.domaceizsrbije.rs/");
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }


    //pravimo metode

    public void clickPrijaviseButton() {
        PrijaviseButton.click();
    }

    public void EnterEmailField(String email) {
        EmailField.click();
        EmailField.sendKeys(email);
    }

    public void EnterPasswordField(String password) {
        PasswordField.click();
        PasswordField.sendKeys(password);

    }

    public void EnterSubmitButton() {
        SubmitButton.click();
    }


    public void EnterPretragaField (String pretraga) {
        PretragaField.click();
        PretragaField.sendKeys(pretraga);
    }

    public void ClickNaruciButton (){
        NaruciButton.click();
    }

    public void ClickSuperhranaMenuButtton (){
        SuperhranaMenuButton.click();
    }

    public void ClickKakaoProizvodiButton (){
        KakaoProizvodiButton.click();
    }

    public void ClickSearchButton (){
        SearchButton.click();
    }


    public String getTextFromLoginMessage (){
        return LoginMessage.getText();
    }

    public String getTextFromIncorrectCredentialsMessage (){
        return IncorrectCredentialsMessage.getText();}

    public void MojNalogButtonClick (){
        MojNalogButton.click();
    }

    public void OdjaviSeButtonClick (){
        OdjaviSeButton.click();
    }

    public boolean isPrijaviSeButtonPresent(WebElement prijaviseButton) { return isPrijaviSeButtonPresent(PrijaviseButton);
    }




}




