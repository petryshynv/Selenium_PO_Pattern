package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static consts.DriversConfigs.browsers;
import static consts.DriversConfigs.browsers.CHROME;
import static consts.DriversConfigs.browsers.FIREFOX;
import static consts.DriversConfigs.waitersValue.IMPLICIT_WAIT_VALUE;

public class DriverFactory {

    private static WebDriver driver;

    private static void createDriver(browsers browser) {
        switch (browser) {
            case CHROME:
                System.setProperty(CHROME.getProperty(), CHROME.getPath());
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(FIREFOX.getProperty(), FIREFOX.getPath());
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_VALUE.getValue(), TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initDriver(browsers browser) {
        createDriver(browser);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
