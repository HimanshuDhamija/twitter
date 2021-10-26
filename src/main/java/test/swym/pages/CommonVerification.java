package test.swym.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static test.DriverFactory.getChromeDriver;

public class CommonVerification extends By {

    protected WebDriver driver = getChromeDriver();

    private CommonVerification(){
        // hide it
    }

    @Override
    public List<WebElement> findElements(SearchContext searchContext) {
        return null;
    }

    public static CommonVerification getCommonVerification(){
        return new CommonVerification();
    }

    public CommonVerification verifyIsDisplayed(){
        Assert.assertTrue(driver.findElement(this).isDisplayed());
        return this;
    }

    public CommonVerification verifyIsNotDisplayed(){
        // your code ...
        return this;
    }
}
