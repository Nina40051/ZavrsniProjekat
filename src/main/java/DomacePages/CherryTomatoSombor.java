package DomacePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class CherryTomatoSombor {

    ChromeDriver driver = null;

    @FindBy(xpath = "//a[@class='fas fa-star']")
    WebElement RateFiveButton;

    @FindBy(xpath = "//button[@class='btn submit-rating']")
    WebElement OceniButton;


    public CherryTomatoSombor(ChromeDriver driver) {
        driver.get("https://www.domaceizsrbije.rs/proizvodjac/cherry-tomato-sombor");
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void ClickRateFiveButton (){
    RateFiveButton.click();}

    public void ClickOceniButton (){
        OceniButton.click();
    }
}
