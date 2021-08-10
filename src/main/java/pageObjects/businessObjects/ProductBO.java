package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.ProductPage;

public class ProductBO {
    private final ProductPage productPage;

    public ProductBO() {
        productPage = new ProductPage();
    }

    public void verifyTitleHandBugsIsVisible() {
        Assert.assertTrue(productPage.IsTitleDisplayed(),
                "'HandBugs' is not visible");
    }

    public ProductPage validateSortingByName() {
        productPage
                .selectByName()
                .sortingByName();
        return productPage;
    }
}
