package pageObjects.businessObjects;

import org.testng.Assert;
import pageObjects.ProductPage;

import java.util.List;

public class ProductBO {
    private final ProductPage productPage;

    public ProductBO() {
        productPage = new ProductPage();
    }

    public void verifyTitleHandBugsIsVisible() {
        Assert.assertTrue(productPage.isHandBugsVisible(),
                "'Hand Bugs' is not visible");
    }

    public void verifyTitleBeachBugsIsVisible() {
        Assert.assertTrue(productPage.isBeachBugsVisible(),
                "'Beach Bugs' is not visible");
    }

    public void validateSortingByName() {
        productPage
                .selectByName()
                .sortingByName();
    }

    public List<String> getItemUi() {
        return productPage.getItemUiPart();
    }
}
