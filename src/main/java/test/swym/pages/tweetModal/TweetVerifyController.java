package test.swym.pages.tweetModal;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static test.DriverFactory.getChromeDriver;

public class TweetVerifyController {
    private WebDriver driver = getChromeDriver();

    public TweetModalPage userNotAllowedToTweet(){
        Assert.assertFalse(driver.findElement(TweetModalPage.tweetButton).isEnabled());
        return TweetModalPage.getTweetModalPage();
    }

    public TweetModalPage userAllowedToTweet(){
        Assert.assertTrue(driver.findElement(TweetModalPage.tweetButton).isEnabled());
        return TweetModalPage.getTweetModalPage();
    }

    public TweetModalPage zeroCharsRemainingBar(){
        Assert.assertTrue(driver.findElement(TweetModalPage.zeroCharsRemaining).isDisplayed());
        return TweetModalPage.getTweetModalPage();
    }

    public TweetModalPage userLandsOnScheduleModal(){
        Assert.assertEquals(driver.findElement(TweetModalPage.modalHeader).getText(), "Schedule");
        return TweetModalPage.getTweetModalPage();
    }

    public TweetModalPage userIsAbleToScheduleATweet(){
        Assert.assertTrue(driver.findElement(TweetModalPage.confirmSchedule).isEnabled());
        return TweetModalPage.getTweetModalPage();
    }
}
