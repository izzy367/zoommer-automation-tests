package zoommer.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;
import static zoommer.constants.TestData.APPLE_URL_FRAGMENT;

public class CategoryPage extends BasePage {

    private final ElementsCollection products = $$("a[href*='/mobiluri-telefonebi/']");

    @Step("Wait for category products to load")
    public CategoryPage waitForProducts() {
        products.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Get the number of products in the category")
    public int getProductCount() {
        return products.size();
    }

    @Step("Check whether the Apple category page is currently displayed")
    public boolean isOnAppleCategoryPage() {
        return getCurrentUrl().contains(APPLE_URL_FRAGMENT);
    }
}