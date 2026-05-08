# Zoommer Automation Tests

UI test automation suite for [zoommer.ge](https://zoommer.ge) e-commerce website, built with Java, Selenide, TestNG and the Page Object Model. Test reports are generated with Allure.

## Tech Stack

- **Java 21** (Eclipse Temurin)
- **Maven** — build & dependency management
- **Selenide 7.5.1** — UI automation framework (Selenium wrapper)
- **TestNG 7.10.2** — test runner
- **Allure 2.29.0** — test reporting
- **AspectJ Weaver** — Allure step interception

## Project Structure

```
src/
├── main/java/zoommer/
│   ├── config/
│   │   └── BrowserConfig.java       # Selenide/browser configuration
│   ├── constants/
│   │   └── TestData.java            # URLs, expected texts, search queries
│   └── pages/                        # Page Object classes
│       ├── BasePage.java            # Parent with common methods + @Step
│       ├── HomePage.java
│       ├── SearchResultsPage.java
│       ├── CategoryPage.java
│       └── ProductPage.java
└── test/java/zoommer/tests/
    ├── BaseTest.java                # @BeforeMethod / @AfterMethod
    ├── SearchTest.java              # Product search by keyword
    ├── CategoryNavigationTest.java  # Brand category navigation via menu hover
    └── ProductPageTest.java         # Add product to cart
```

## Test Coverage

| Test class | What it verifies |
|---|---|
| `SearchTest` | Search returns results; first product URL contains the search query |
| `CategoryNavigationTest` | Hover over mobile menu, click Apple brand, verify URL and product count |
| `ProductPageTest` | Open product page, verify elements visible, click add-to-cart, confirm cart message |

## How to Run

### Prerequisites

- JDK 21
- Maven 3.9+
- Chrome browser

### Run tests

```bash
mvn clean test
```

### Generate and view Allure report

```bash
mvn allure:serve
```

This builds the HTML report and opens it in the default browser. Press `Ctrl+C` to stop the server.

## Patterns and Conventions

- **Page Object Model:** every page is a class extending `BasePage`. Locators are stored as `private final SelenideElement` fields, never exposed publicly.
- **No assertions in pages:** pages provide data and actions; tests perform assertions with `Assert.*`.
- **Fluent interface:** page methods return Page Objects so test flows read naturally.
- **Wait/Check separation:** `waitFor*` methods perform Selenide waits; `is*Displayed` methods return immediate booleans for assertions.
- **Test data extracted:** product URLs, search queries, and expected texts live in `TestData.java`.
- **Allure annotations:** every page method has `@Step`; every test has `@Description`, `@Severity`, `@Story`, `@Feature`, `@Epic`.