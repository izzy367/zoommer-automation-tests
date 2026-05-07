package zoommer.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static zoommer.constants.TestData.APPLE_BRAND_TEXT;
import static zoommer.constants.TestData.BASE_URL;
import static zoommer.constants.TestData.MOBILE_CATEGORY_TEXT;

public class HomePage extends BasePage {

    private final SelenideElement searchInput = $("input[placeholder='ძიება']");
    private final SelenideElement mobileCategoryMenu = $(byText(MOBILE_CATEGORY_TEXT));
    private final SelenideElement appleBrandLink = $(byText(APPLE_BRAND_TEXT));

    @Step("Open Zoommer home page")
    public HomePage openHomePage() {
        openUrl(BASE_URL);
        return this;
    }

    @Step("Search for product: {query}")
    public SearchResultsPage searchForProduct(String query) {
        waitForElementVisible(searchInput);
        searchInput.setValue(query).pressEnter();
        return new SearchResultsPage();
    }

    @Step("Hover over mobile category menu")
    public HomePage hoverMobileCategoryMenu() {
        waitForElementVisible(mobileCategoryMenu);
        mobileCategoryMenu.hover();
        return this;
    }

    @Step("Click on Apple brand link")
    public CategoryPage clickAppleBrandLink() {
        waitForElementVisible(appleBrandLink);
        appleBrandLink.click();
        return new CategoryPage();
    }
}