package zoommer.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import zoommer.pages.CategoryPage;
import zoommer.pages.HomePage;

@Epic("Zoommer E-commerce")
@Feature("Category Navigation")
public class CategoryNavigationTest extends BaseTest {

    @Test
    @Story("Navigate to brand category from main menu")
    @Severity(SeverityLevel.NORMAL)
    @Description("User hovers over the mobile category menu, clicks the Apple brand link, and lands on the Apple category page with products listed")
    public void shouldNavigateToAppleCategoryViaMenuHover() {
        CategoryPage categoryPage = new HomePage()
                .openHomePage()
                .hoverMobileCategoryMenu()
                .clickAppleBrandLink()
                .waitForProducts();

        Assert.assertTrue(categoryPage.isOnAppleCategoryPage(),
                "Should be redirected to Apple category page, but current URL was: " + categoryPage.getCurrentUrl());

        int productCount = categoryPage.getProductCount();
        Assert.assertTrue(productCount > 0,
                "Apple category should display at least one product, but found: " + productCount);
    }
}