package test.swym.pages.home;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.swym.pages.tweetModal.TweetModalPage;
import test.swym.utils.TestUtils;

import static test.DriverFactory.getChromeDriver;

public class HomeActController {

    private WebDriver driver = getChromeDriver();

    public TweetModalPage userClicksTweetButton(){
        driver.findElement(HomePage.tweet).click();
        return TweetModalPage.getTweetModalPage();
    }

}
