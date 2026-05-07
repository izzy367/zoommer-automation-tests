package zoommer.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static zoommer.constants.TestData.ADD_TO_CART_BUTTON_TEXT;
import static zoommer.constants.TestData.CART_CONFIRMATION_TEXT;
import static zoommer.constants.TestData.EXPECTED_PRODUCT_TITLE;
import static zoommer.constants.TestData.PRODUCT_URL;

public class ProductPage extends BasePage {

    private final SelenideElement productTitle = $(byText(EXPECTED_PRODUCT_TITLE));
    private final SelenideElement addToCartButton = $(byText(ADD_TO_CART_BUTTON_TEXT));
    private final SelenideElement cartConfirmation = $(byText(CART_CONFIRMATION_TEXT));

    @Step("Open product page directly via URL")
    public ProductPage openProductPage() {
        openUrl(PRODUCT_URL);
        return this;
    }

    @Step("Wait for the product page to load (title becomes visible)")
    public ProductPage waitForProductLoaded() {
        productTitle.shouldBe(visible);
        return this;
    }

    @Step("Click 'Add to cart' button")
    public ProductPage clickAddToCart() {
        waitForElementVisible(addToCartButton);
        addToCartButton.click();
        return this;
    }

    @Step("Wait for cart confirmation to appear")
    public ProductPage waitForCartConfirmation() {
        cartConfirmation.shouldBe(visible);
        return this;
    }

    @Step("Check if expected product title is displayed")
    public boolean isProductTitleDisplayed() {
        return productTitle.is(visible);
    }

    @Step("Check if 'Add to cart' button is displayed")
    public boolean isAddToCartButtonDisplayed() {
        return addToCartButton.is(visible);
    }

    @Step("Check if cart confirmation message is displayed")
    public boolean isCartConfirmationDisplayed() {
        return cartConfirmation.is(visible);
    }
}