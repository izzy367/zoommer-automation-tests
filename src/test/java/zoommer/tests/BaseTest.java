package zoommer.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import zoommer.utils.DriverConfig;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverConfig.setupBrowser();

        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
        );
    }

    @AfterMethod
    public void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}
