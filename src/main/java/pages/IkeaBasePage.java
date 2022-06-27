package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

public class IkeaBasePage {
    ChromeDriver driver = null;

   //inspect and create webelements

    @FindBy (xpath ="//input[@type='search']")
    WebElement SearchField;

    @FindBy (xpath="//button[@aria-labelledby='search-box__searchbutton--tooltip']")
    WebElement SearchButton;

    @FindBy (xpath="//button[text()='Prihvati sve kolačiće']")
    WebElement CookiesButton;


    //create constructor

    public IkeaBasePage(ChromeDriver driver) {
        driver.get("https://www.ikea.com/rs/sr/");
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    //create methods

    public void InsertTextInSearchField(String product){
        SearchField.click();
        SearchField.sendKeys(product);
    }



    public void ClickSearchButton(){
        SearchButton.click();
    }

    public void ClickCookiesButton (){
        CookiesButton.click();
    }





}
