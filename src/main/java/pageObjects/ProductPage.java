package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class ProductPage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(String.valueOf(ProductPage.class));

    private final By titleHandBugsElement = By.xpath("//h1[@class='shop-banner-title lead']");
    private final By sortByMenuElement = By.xpath("//select[@class='cust-select']");
    private final By handBugElement = By.xpath("//div[@id='productsContainer']//h3[@itemprop='name']");

    public boolean IsTitleDisplayed() {
        boolean isDisplayed = isDisplayed(titleHandBugsElement);
        LOG.info(String.format("'HandBugs' is visible '%s'", isDisplayed));
        return isDisplayed;
    }

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
        Collections.sort(sortedList);
        Assert.assertEquals(obtainedList, sortedList, "Sorting by name doesn't work");
    }
}
