package test.swym.pages.login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.swym.pages.home.HomePage;
import test.swym.utils.TestUtils;

import java.util.Properties;

import static test.DriverFactory.getChromeDriver;
import static test.DriverFactory.getWebDriverWait;

public class LoginActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();

    public HomePage userLandsOnHomePage(String username, String password){
        driver.findElement(LoginPage.username).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(LoginPage.next))).click();
        driver.findElement(LoginPage.password).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(LoginPage.login))).click();
        return HomePage.getHomePage();
    }

}
