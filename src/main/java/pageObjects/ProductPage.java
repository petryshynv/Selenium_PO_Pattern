package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ProductPage extends AbstractPage {

    Actions actions = new Actions(DriverFactory.getDriver());

    private static final Logger LOG = Logger.getLogger(String.valueOf(ProductPage.class));


    private final By titleHandBugsElement = By.xpath("//h1[@class='shop-banner-title lead']");
    private final By sortByMenuElement = By.xpath("//select[@class='cust-select']");
    private final By handBugElement = By.xpath("//div[@id='productsContainer']//h3[@itemprop='name']");


    private final By shoppingCartOnHomePageElement = By.xpath("//a[@aria-expanded='true']//span[@class='hidden-xs']");
    private final By checkoutElement = By.xpath("//a[@onclick='viewShoppingCartPage();']");
    private final By cookiesDismissElement = By.xpath("//a[@class='cc-btn cc-dismiss']");

    public boolean IsTitleDisplayed() {
        boolean isDisplayed = isDisplayed(titleHandBugsElement);
        // Assert.assertTrue(isDisplayed, "Title 'HandBugs'  is not visible");
        LOG.info(String.format("'HandBugs' is visible '%s'", isDisplayed));
        return isDisplayed;
    }

//    public ProductPage clickSortByMenu() {
//        getElement(sortByMenuElement).click();
//        // Assert.assertTrue(isDisplayed(logoElement), "Logo Element is not visible");
//        LOG.info("'Sort by' menu is clicked");
//        return this;
//    }

    public ProductPage selectByName() {
        Select selectName = new Select(getElement(sortByMenuElement));
        selectName.selectByVisibleText("Name");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("'HandBugs' is clicked");
        return new ProductPage();
    }

    public void sortingByName() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = getElements(handBugElement);
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String s : obtainedList) {
            sortedList.add(s);
        }
        System.out.println(obtainedList);
        Collections.sort(sortedList);
        System.out.println(sortedList);
        Assert.assertTrue(sortedList.equals(obtainedList), "Sorting by name doesn't work");
    }

    public boolean IsTitleOrderDisplayed() {
        boolean isDisplayed = isDisplayed(titleHandBugsElement);
        // Assert.assertTrue(isDisplayed, "Title 'HandBugs'  is not visible");
        LOG.info(String.format("'HandBugs' is visible '%s'", isDisplayed));
        return isDisplayed;
    }


//    public HomePage isFailedLoginErrorMessageDisplayed() {
//        boolean checkMessage = getDriver().getPageSource().contains("We can't find user with such credentials.");
//        LOG.info(String.format("Is 'Login Failed' error message displayed: '%s'", checkMessage));
//        Assert.assertTrue(checkMessage, "'Login Failed' error message is not displayed");
//        return new HomePage();
//    }
}
