package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.ProductPage;

public class ProductPO {
    private ProductPage productPage;

    public ProductPO() {
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
