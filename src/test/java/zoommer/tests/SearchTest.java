package zoommer.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import zoommer.pages.HomePage;
import zoommer.pages.SearchResultsPage;

import static zoommer.constants.TestData.SEARCH_QUERY;

@Epic("Zoommer E-commerce")
@Feature("Product Search")
public class SearchTest extends BaseTest {

    @Test
    @Story("Search products by keyword")
    @Severity(SeverityLevel.CRITICAL)
    @Description("User enters a product keyword in the search bar and gets relevant results on the search results page")
    public void shouldReturnResultsWhenSearchingByProductName() {
        SearchResultsPage resultsPage = new HomePage()
                .openHomePage()
                .searchForProduct(SEARCH_QUERY)
                .waitForResults();

        int resultsCount = resultsPage.getResultsCount();
        Assert.assertTrue(resultsCount > 0,
                "Search for '" + SEARCH_QUERY + "' should return at least one product, but returned " + resultsCount);

        String firstProductTitle = resultsPage.getFirstProductTitle();
        Assert.assertTrue(firstProductTitle.toLowerCase().contains(SEARCH_QUERY.toLowerCase()),
                "First product title should contain '" + SEARCH_QUERY + "', but was: " + firstProductTitle);
    }
}