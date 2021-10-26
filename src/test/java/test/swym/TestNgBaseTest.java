package test.swym;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import test.swym.pages.login.LoginPage;
import test.swym.utils.TestUtils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static test.DriverFactory.*;

public class TestNgBaseTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage = LoginPage.getLoginPage();
    Properties props = TestUtils.readPropertiesFile("src\\test\\resources\\testData.properties");

    @Parameters({"url"})
    @BeforeMethod
    public void goToUrl(@Optional("https://twitter.com/i/flow/login") String strUrl){
        driver = getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        wait = getWebDriverWait();
        driver.get(strUrl);
        loginPage
                .act().userLandsOnHomePage(props.getProperty("USERNAME"), props.getProperty("PASSWORD"));
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}