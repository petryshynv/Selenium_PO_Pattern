import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.ProductPO;

public class ProductPageTest extends BaseTest {

    @Test(description = "Validate sorting by name")
    public void validateSortingByName() {
        new HomeBO()
                .proceedToHomePage()
                .proceedToProductPage();
        new ProductPO()
                .verifyTitleHandBugsIsVisible();
        new ProductPO()
                .validateSortingByName();
    }
}
