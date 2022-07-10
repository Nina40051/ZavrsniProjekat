package DomacePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.atomic.LongAdder;

public class ProizvodiPretragaPage {

    ChromeDriver driver=null;

    @FindBy(xpath = "//input[@name='pretraga']")
    WebElement PretragaField;

    @FindBy(xpath ="//img[@alt='Cherry tomato']")
    WebElement CherryButton;

    @FindBy (xpath=("//a[@href='https://www.domaceizsrbije.rs/proizvodjac/ukusi-kopaonika/naruci']"))
    WebElement BeliSirButton;

    public ProizvodiPretragaPage(ChromeDriver driver) {
        driver.get("https://www.domaceizsrbije.rs/proizvodi/pretraga");
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void EnterPretragaField (String pretraga) {
        PretragaField.click();
        PretragaField.sendKeys(pretraga);
        PretragaField.click();
    }

    public void ClickCherryButton (){

        CherryButton.click();
    }

    public void ClickBeliSirButton() {
        BeliSirButton.click();
    }
}
