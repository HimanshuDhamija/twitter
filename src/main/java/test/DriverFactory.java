package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverFactory(){
        // prevent instantiation
    }

    public static WebDriver getChromeDriver(){

        if(driver == null){
            WebDriverManager.chromedriver().version("2.41").setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver getFirefoxDriver(){

        if(driver == null){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait(){
        if(wait == null){
            wait = new WebDriverWait(getChromeDriver(), 5);
        }
        return wait;
    }
}
