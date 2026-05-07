package zoommer.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import zoommer.config.BrowserConfig;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        BrowserConfig.setup();
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
                        .includeSelenideSteps(true));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
        closeWebDriver();
    }
}