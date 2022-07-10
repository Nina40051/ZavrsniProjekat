package IkeaTests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTestIkea {

        ChromeDriver driver;

        public ChromeDriver openChromeDriver() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--start-maximized"});
            options.addArguments(new String[]{"--ignore-certificate-errors"});
            options.addArguments(new String[]{"--disable-popup-blocking"});
            options.addArguments(new String[]{"--incognito"});
            //options.addArguments(new String[]{"--remote-debugging-port=9222"});
            //options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            ChromeDriver driver = new ChromeDriver(options);
            return driver;

        }

        public void sleep(int seconds) {
            try {
                Thread.sleep(seconds * 1000);
            } catch (Exception e) {
            }
        }


        public void scrollIntoView(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }

        public void print(String s) {
            System.out.println(s);
        }


        public void sendKeys(CharSequence... keysToSend) {
            if (keysToSend == null || keysToSend.length == 0) {
                throw new IllegalArgumentException("Keys to send should be a not null CharSeequence");}
            for (CharSequence cs : keysToSend) {
                if (cs == null){
                    throw new IllegalArgumentException("Keys to send should be a not null CharSeequence");
                }
            }
            String allKeysToSend=String.join("", keysToSend);
        }
    }

