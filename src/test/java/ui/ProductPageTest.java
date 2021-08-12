package ui;

import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.ProductBO;

public class ProductPageTest extends BaseTest {

    @Test(description = "Validate sorting by name", groups = "UITest")
    public void validateSortingByName() {
        new HomeBO()
                .proceedToHomePage()
                .proceedToProductPage();
        new ProductBO()
                .verifyTitleHandBugsIsVisible();
        new ProductBO()
                .validateSortingByName();
    }
}
