package test.swym.pages.tweetModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static test.DriverFactory.getChromeDriver;

public class TweetModalPage {

    private WebDriver driver = getChromeDriver();

    private TweetActController act;
    private TweetVerifyController verify;
    private TweetGetController get;

    public TweetActController act(){
        return act;
    }

    public TweetVerifyController verify(){
        return verify;
    }

    public TweetGetController get(){
        return get;
    }

    private TweetModalPage(){
        // hide it
    }

    //Locators
    protected static By tweetTextArea(int number){
        return By.cssSelector(String.format("div[role='dialog'] div[data-testid='tweetTextarea_%d']", number));
    }
    protected static By tweetButton = By.cssSelector("div[role='dialog'] div[data-testid='tweetButton']");
    protected static By zeroCharsRemaining = By.xpath("//div[.='0 characters remaining']");
    protected static By exceededChars = By.xpath("//div[contains(.,'You have exceeded the character limit by')]");
    protected static By whoCanReply(String whoCanReply){
        return By.xpath(String.format("//div[@role='dialog']//span[.='%s']/ancestor::div[@role='button']",
                whoCanReply));
    }
    protected static By everyoneCanReply = By.xpath("//div[@role='dialog']//span[.='Everyone can reply']/ancestor::div[@role='button']");
    protected static By addTweet = By.cssSelector("div[aria-label='Add Tweet']");
    protected static By menuItems = By.cssSelector("div[role='menuitem']");
    protected static By scheduleTweet = By.cssSelector("div[role='dialog'] div[aria-label='Schedule Tweet']");
    protected static By modalHeader = By.cssSelector("#modal-header");
    protected static By confirmSchedule = By.xpath("//span[.='Confirm']/ancestor::div[@role='button']");

    private TweetModalPage(TweetActController act, TweetVerifyController verify, TweetGetController get){
        this.act = act;
        this.verify = verify;
        this.get = get;
    }
    public static TweetModalPage getTweetModalPage(){
        return new TweetModalPage(new TweetActController(),
                new TweetVerifyController(), new TweetGetController());
    }
}
