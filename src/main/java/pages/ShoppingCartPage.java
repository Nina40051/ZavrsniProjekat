package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    ChromeDriver driver = null;

    @FindBy(xpath = "//div[@class='productControls_remove__2hC2w']")
    WebElement UkloniProizvodButton;

    @FindBy(xpath = "//h2[@class='noProducts_header__2mpUZ']")
    WebElement EmptyCartMessage;

    @FindBy (xpath="//div[@class='productControls_quantity__3kCs5']")
    WebElement DropDownMenuButton;

    public ShoppingCartPage() {
        driver.get("https://www.ikea.com/rs/sr/shoppingcart/");
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void ClickUkloniProizvodButton() {
        UkloniProizvodButton.click();
    }


    public String getTextFromEmptyCartMessage (){
        return EmptyCartMessage.getText();
    }

    public void ClickDropDownMenuButton(){
        DropDownMenuButton.click();
    }

}