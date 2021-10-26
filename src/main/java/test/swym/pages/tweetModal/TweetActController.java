package test.swym.pages.tweetModal;

import org.openqa.selenium.WebDriver;

import static test.DriverFactory.getChromeDriver;

public class TweetActController {

    private WebDriver driver = getChromeDriver();

    public TweetModalPage userEntersChars(String keysToSend, int numberOfTweet){
        driver.findElement(TweetModalPage.tweetTextArea(numberOfTweet)).sendKeys(keysToSend);
        return TweetModalPage.getTweetModalPage();
    }

    public TweetModalPage userAddsMultipleTweets(){
        driver.findElement(TweetModalPage.addTweet).click();
        return TweetModalPage.getTweetModalPage();
    }

    public TweetModalPage selectWhoCanReply(String value){
        driver.findElement(TweetModalPage.everyoneCanReply).click();
        driver.findElement(TweetModalPage.whoCanReply(value)).click();
        return TweetModalPage.getTweetModalPage();
    }

    public TweetModalPage clickScheduleATweet(){
        driver.findElement(TweetModalPage.scheduleTweet).click();
        return TweetModalPage.getTweetModalPage();
    }
}
