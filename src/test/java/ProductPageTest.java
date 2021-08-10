import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.ProductBO;

public class ProductPageTest extends BaseTest {

    @Test(description = "Validate sorting by name")
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
