package test.swym;

import org.testng.annotations.Test;
import test.swym.pages.home.HomePage;

import static test.swym.pages.home.HomePage.getHomePage;

public class TweetTest extends TestNgBaseTest {

    HomePage homePage = getHomePage();

    @Test
    public void userAllowedToTweetAfterEnteringCharactersForTweet() {
       homePage
               .act().userClicksTweetButton()
               .verify().userNotAllowedToTweet()
               .act().userEntersChars(props.getProperty("CHARS"), 0)
               .verify().userAllowedToTweet();
    }

    @Test
    public void userAllowedToTweetMultipleTweets() {
        homePage
                .act().userClicksTweetButton()
                .act().userAddsMultipleTweets()
                .act().userEntersChars(props.getProperty("CHARS"), 0)
                .verify().userNotAllowedToTweet()
                .act().userEntersChars(props.getProperty("CHARS"), 1)
                .verify().userAllowedToTweet();
        //More tests can be written considering the number of characters(how many chars need to be removed
        // to make the tweet valid)
    }

    @Test
    public void userAllowedToTweetBasedOnWhoCanReply() {
        homePage
                .act().userClicksTweetButton()
                .act().userEntersChars(props.getProperty("CHARS"), 0)
                .act().selectWhoCanReply("Everyone")
                .verify().userAllowedToTweet()
                .act().selectWhoCanReply("People you follow")
                .verify().userAllowedToTweet()
                .act().selectWhoCanReply("Only people you mention")
                .verify().userAllowedToTweet();
        //Mocked tests can be written based on the selection
    }

    @Test
    public void userIsAbleToScheduleTweet(){
        homePage
                .act().userClicksTweetButton()
                .act().clickScheduleATweet()
                .verify().userLandsOnScheduleModal()
                .verify().userIsAbleToScheduleATweet();
        //More test cases of schedule can be added
        //Like validating errors on past dates
        //same date but past time
        //Time zone
        //Message on top changing with the selection of date/time
    }

    //Tests to send a tweet using media, GIF etc. should be written
    //Reply to a tweet

}
