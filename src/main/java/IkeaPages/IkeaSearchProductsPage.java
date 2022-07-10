package IkeaPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IkeaSearchProductsPage {

    ChromeDriver driver = null;

    @FindBy(xpath="//button[@id='30449908add_to_cart']")
    WebElement AddToCartButton;

    @FindBy (xpath="//span[@class='hnf-header__cart-counter']")
    WebElement ShoppingCartIcon;

    @FindBy (xpath="//li[@class='hnf-header__shopping-cart-link']")
    WebElement ShoppingCartButton;

    @FindBy (xpath ="//div[@id='search-results']//span[contains(text(), 'LACK Pomoćni stočić, bela, 55x55 cm')] //ancestor :: h3")
    WebElement PomocniStocicButton;



    public IkeaSearchProductsPage (ChromeDriver driver) {
        driver.get("https://www.ikea.com/rs/sr/search/products/?q=sto");
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void ClickAddToCartButton (){
        AddToCartButton.click();
    }

    public void ClickShoppingCartButton (){
        ShoppingCartButton.click();
    }

    public void ClickPomocniStocicButton (){
        PomocniStocicButton.click();
    }

    public void waitFOrElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void print(String s) {
        System.out.println(s);
    }

    public String getNumberFromShoppingCartIcon() {
        print ("getNumberFromShoppingCartIcon");

        String number = ShoppingCartIcon.getText();
        return number;

    }

    public boolean isShoppingCartIconShown() { return isElementPresent(ShoppingCartIcon);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            boolean present = element.isDisplayed();
            return present;
        } catch (Exception e) {
            return false;
        }
    }
}



