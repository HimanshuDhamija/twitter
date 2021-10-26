package test.swym.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static test.DriverFactory.getChromeDriver;

public class HomePage {

    private HomeActController act;
    private HomeVerifyController verify;
    private HomeGetController get;

    public HomeActController act(){
        return act;
    }

    public HomeVerifyController verify(){
        return verify;
    }

    public HomeGetController get(){
        return get;
    }

    private WebDriver driver = getChromeDriver();

    private HomePage(){
        // hide it
    }

    //Locators
    protected static By tweet = By.cssSelector("a[href*='tweet']");

    private HomePage(HomeActController act, HomeVerifyController verify, HomeGetController get){
        this.act = act;
        this.verify = verify;
        this.get = get;
    }
    public static HomePage getHomePage(){
        return new HomePage(new HomeActController(),
                            new HomeVerifyController(), new HomeGetController());
    }
}
