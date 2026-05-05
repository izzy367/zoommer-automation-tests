package zoommer.config;

import com.codeborne.selenide.Configuration;

public class BrowserConfig {

    private BrowserConfig() {
        // Utility class — prevent instantiation
    }

    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;
        Configuration.pageLoadTimeout = 30_000;
        Configuration.headless = false;
        Configuration.baseUrl = "https://zoommer.ge";
        Configuration.fastSetValue = true;
    }
}