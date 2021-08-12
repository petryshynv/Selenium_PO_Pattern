package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;



public class AbstractPage {


    AbstractPage() {
    }

    void proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        return DriverFactory.getDriver().findElement(locator);
    }

    List<WebElement> getElements(By locator){
        return DriverFactory.getDriver().findElements(locator);
    }

    public boolean isDisplayed(By locator) {
        try {
            return DriverFactory
                    .getDriver()
                    .findElement(locator)
                    .isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
