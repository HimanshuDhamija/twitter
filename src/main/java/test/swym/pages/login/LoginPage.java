package test.swym.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static test.DriverFactory.getChromeDriver;

public class LoginPage {

    private LoginActController act;
    private LoginVerifyController verify;
    private LoginGetController get;

    public LoginActController act(){
        return act;
    }

    public LoginVerifyController verify(){
        return verify;
    }

    public LoginGetController get(){
        return get;
    }

    private WebDriver driver = getChromeDriver();

    private LoginPage(){
        // hide it
    }

    //Locators for login functionality
    protected static By username = By.name("username");
    protected static By password = By.name("password");
    protected static By next = By.xpath("//span[.='Next']/ancestor::div[@role='button']");
    protected static By login = By.cssSelector("div[data-testid='LoginForm_Login_Button']");

    private LoginPage(LoginActController act, LoginVerifyController verify, LoginGetController get){
        this.act = act;
        this.verify = verify;
        this.get = get;
    }
    public static LoginPage getLoginPage(){
        return new LoginPage(new LoginActController(),
                            new LoginVerifyController(), new LoginGetController());
    }
}
