package IkeaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomocniStocicPage {

    ChromeDriver driver=null;

    @FindBy (xpath="//button[@aria-label='Dodaj u korpu']")
    WebElement DodajUKorpuButton;

    @FindBy (xpath = "//a[@data-testid='go-to-cart']")
    WebElement NastaviNaKorpu;

    @FindBy(xpath = "//div[@class='productControls_remove__2hC2w']")
    WebElement UkloniProizvodButton;

    @FindBy(xpath = "//h2[@class='noProducts_header__2mpUZ']")
    WebElement EmptyCartMessage;

    public PomocniStocicPage (ChromeDriver driver) {
        driver.get("https://www.ikea.com/rs/sr/p/lack-pomocni-stocic-bela-30449908/");
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
    public void ClickDodajUKorpu (){
        DodajUKorpuButton.click();
    }

    public void ClickNastavinaKorpu (){
        NastaviNaKorpu.click();
    }

    public void ClickUkloniProizvodButton() {
        UkloniProizvodButton.click();
    }


    public String getTextFromEmptyCartMessage (){
        return EmptyCartMessage.getText();
    }}