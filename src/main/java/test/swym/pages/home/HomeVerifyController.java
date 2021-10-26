package test.swym.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static test.DriverFactory.getChromeDriver;
import static test.swym.pages.home.HomePage.getHomePage;
import static test.swym.pages.home.HomePage.tweet;

public class HomeVerifyController {

    private WebDriver driver = getChromeDriver();

    public HomePage tweetLinkIsDisplayed(){
        WebElement element = driver.findElement(tweet);
        Assert.assertTrue(element.isDisplayed());
        return getHomePage();
    }

}
