package zoommer.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import zoommer.pages.ProductPage;

@Epic("Zoommer E-commerce")
@Feature("Shopping Cart")
public class ProductPageTest extends BaseTest {

    @Test
    @Story("Add a product to the shopping cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User opens a product page directly via URL, verifies key elements are displayed, " +
            "clicks 'Add to cart', and confirms the product is successfully added")
    public void shouldAddProductToCartFromProductPage() {
        ProductPage productPage = new ProductPage()
                .openProductPage()
                .waitForProductLoaded();

        Assert.assertTrue(productPage.isProductTitleDisplayed(),
                "Product title should be displayed after the product page loads");

        Assert.assertTrue(productPage.isAddToCartButtonDisplayed(),
                "'Add to cart' button should be visible on the product page");

        productPage.clickAddToCart()
                .waitForCartConfirmation();

        Assert.assertTrue(productPage.isCartConfirmationDisplayed(),
                "Cart confirmation should appear after clicking 'Add to cart'");
    }
}