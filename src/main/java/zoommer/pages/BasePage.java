package zoommer.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.url;

public abstract class BasePage {

    @Step("Open URL: {url}")
    protected void openUrl(String url) {
        open(url);
    }

    @Step("Get current page URL")
    public String getCurrentUrl() {
        return url();
    }

    @Step("Get current page title")
    public String getPageTitle() {
        return title();
    }

    @Step("Wait until element is visible")
    protected void waitForElementVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    @Step("Scroll to element")
    protected void scrollTo(SelenideElement element) {
        element.scrollIntoView(true);
    }
}