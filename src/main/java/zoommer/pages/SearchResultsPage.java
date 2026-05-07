package zoommer.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage extends BasePage {

    private final ElementsCollection productCards = $$("a[href*='/mobiluri-telefonebi/']");

    @Step("Wait for search results to load")
    public SearchResultsPage waitForResults() {
        productCards.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Get the count of search results")
    public int getResultsCount() {
        return productCards.size();
    }

    @Step("Get the title text of the first product")
    public String getFirstProductTitle() {
        return productCards.first().getText();
    }
}