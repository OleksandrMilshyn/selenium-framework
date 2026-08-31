# Selenium WebDriver Framework

UI test automation framework developed with Selenium WebDriver, Java, TestNG and Cucumber-JVM.

## Technologies

- Java 17
- Maven
- Selenium WebDriver 4
- WebDriverManager
- TestNG
- Cucumber-JVM
- Lombok
- Log4j2
- Allure
- GitHub Actions
- Page Object Model (POM)
- Page Factory

## Project Structure

    src
    ├── main
    │   ├── java
    │   │   ├── base
    │   │   ├── driver
    │   │   ├── model
    │   │   ├── pages
    │   │   └── utils
    │   └── resources
    │
    └── test
        ├── java
        │   ├── base
        │   ├── data
        │   ├── listeners
        │   ├── runners
        │   ├── steps
        │   └── tests
        └── resources
            ├── config-dev.properties
            ├── config-test.properties
            ├── features
            ├── log4j2.xml
            ├── testng.xml
            └── suites
                ├── smoke.xml
                └── regression.xml

## Automated Test Scenarios

### Cart Test

- Login with valid credentials
- Add Sauce Labs Backpack to the cart
- Verify cart badge
- Open the cart
- Verify cart page
- Verify product in the cart

### Checkout Test

- Login
- Add product to the cart
- Open the cart
- Proceed to checkout
- Fill customer information
- Complete the order
- Verify successful checkout

### Product Sorting Test

- Login
- Sort products by Price (Low to High)
- Verify sorting order
- Add the cheapest product to the cart
- Remove the product
- Verify the cart is empty

### Cucumber Login Test

- Open the login page
- Login with different credentials
- Verify Products page is displayed
- Use Scenario Outline for parameterized test data
- Use Examples section for multiple sets of credentials
- Use Background for common preconditions
- Use regular expressions in step definitions for parameterization

## Design Patterns

The framework implements the following design patterns:

- Singleton
- Factory Method
- Decorator

All implemented patterns are integrated into the test framework and invoked during test execution.

## SOLID Principles

The framework was reviewed and refactored according to SOLID principles.

The refactoring includes:

- Separation of responsibilities between framework components
- Improved class responsibilities
- Encapsulation of page object fields
- Separation of authentication, browser management and test logic
- Removal of unnecessary responsibilities from existing classes

## Implemented Features

- WebDriverManager
- Driver Factory
- Factory Method
- Singleton
- Decorator
- Page Object Model (POM)
- Page Factory
- Abstract Page
- Business Object (Customer)
- Explicit Wait
- Multiple locator strategies (id, className, css)
- Multi-browser support (Chrome, Firefox)
- Multiple environments (dev, test)
- Parallel test execution (TestNG + ThreadLocal WebDriver)
- Lombok
- Smoke and Regression TestNG suites
- TestNG Listener
- Cucumber-JVM integration
- Scenario Outline and Examples
- Background
- Parameterized Gherkin step definitions
- Allure reporting
- Screenshot capture on test failure
- Log4j2 logging
- GitHub Actions CI workflow

## Running Tests

Run all tests:

    mvn test

Run Regression suite:

    mvn test "-DsuiteXmlFile=src/test/resources/suites/regression.xml"

Run Smoke suite:

    mvn test "-DsuiteXmlFile=src/test/resources/suites/smoke.xml"

Run in Chrome:

    mvn test "-Dbrowser=chrome"

Run in Firefox:

    mvn test "-Dbrowser=firefox"

Run using TEST environment:

    mvn test "-Denv=test"

Run using DEV environment:

    mvn test "-Denv=dev"

Run in headless mode:

    mvn test "-Dheadless=true"

## Logging

The framework provides:

- Console logging
- Daily rolling log files
- Multiple log levels (DEBUG, INFO, WARN, ERROR)
- Logging of test actions
- Logging of WebDriver lifecycle
- Logging of test execution results

## Screenshots

Screenshots for TestNG tests are attached to the Allure report.

## Continuous Integration

The project includes a GitHub Actions workflow that:

- Builds the project
- Runs the Regression test suite
- Publishes test reports
- Uploads logs as artifacts
- Uploads failure screenshots as artifacts