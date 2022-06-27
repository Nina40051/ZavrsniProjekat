package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CherryTomatoPage {

    ChromeDriver driver=null;

    @FindBy (xpath = ("//p/a[text()='Cherry tomato - Sombor']"))
    WebElement CherryTomatoButton;

    @FindBy (xpath=("//div[@class='product-details']"))
    WebElement ProductDetails;


public  CherryTomatoPage(ChromeDriver driver) {
    driver.get("https://www.domaceizsrbije.rs/proizvod/cherry-tomato");
    PageFactory.initElements(driver, this);
    this.driver = driver;}


    public void ClickCherryTomatoButton(){
        CherryTomatoButton.click();
    }
}

