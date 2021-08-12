import api.ServiceForCombinedApi;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.ProductBO;
import ui.BaseTest;

import java.util.List;

public class CombinedTest extends BaseTest {

    @Test(description = "Check that Beach bags category items on UI have the same names as in the response from the back end.",
            groups = "CombinedTest")
    public void verifyAreSameNamesFromUiGetItemsAndApiResponse() {

        new HomeBO()
                .proceedToHomePage()
                .proceedToProductBeachBugsPage();
        new ProductBO()
                .verifyTitleBeachBugsIsVisible();
        List<String> listOfItemsUi = new ProductBO().getItemUi();
        List<String> listOfItemsApi = new ServiceForCombinedApi().combinedTestApiPart();
        Assert.assertEquals(listOfItemsApi, listOfItemsUi, "Names are not same");
    }
}
