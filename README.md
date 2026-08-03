# Selenium WebDriver Framework

UI test automation framework developed with Selenium WebDriver, Java and TestNG.

## Technologies

- Java 17
- Maven
- Selenium WebDriver 4
- WebDriverManager
- TestNG
- Log4j2
- GitHub Actions
- Page Object Model (POM)
- Page Factory

## Project Structure

```
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
    │   ├── listeners
    │   └── tests
    └── resources
        ├── config-dev.properties
        ├── config-test.properties
        ├── log4j2.xml
        └── suites
            ├── smoke.xml
            └── regression.xml
```

## Automated Test Scenarios

### Cart Test

- Login with valid credentials
- Verify successful login
- Add Sauce Labs Backpack to the cart
- Verify cart badge
- Open the cart
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

## Implemented Features

- WebDriverManager
- Driver Factory
- Page Object Model (POM)
- Page Factory
- Abstract Page
- Business Object (Customer)
- Explicit and Implicit Waits
- Multiple locator strategies (`id`, `className`, `css`)
- Multi-browser support (Chrome, Firefox)
- Multiple environments (`dev`, `test`)
- Smoke and Regression TestNG suites
- TestNG Listener
- Screenshot capture on test failure
- Log4j2 logging
- GitHub Actions CI workflow

## Running Tests

Run all regression tests:

```bash
mvn test
```

Run Regression suite:

```bash
mvn test "-DsuiteXmlFile=src/test/resources/suites/regression.xml"
```

Run Smoke suite:

```bash
mvn test "-DsuiteXmlFile=src/test/resources/suites/smoke.xml"
```

Run in Chrome:

```bash
mvn test "-Dbrowser=chrome"
```

Run in Firefox:

```bash
mvn test "-Dbrowser=firefox"
```

Run using TEST environment:

```bash
mvn test "-Denv=test"
```

Run using DEV environment:

```bash
mvn test "-Denv=dev"
```

Run in headless mode:

```bash
mvn test "-Dheadless=true"
```

## Logging

The framework provides:

- Console logging
- Daily rolling log files
- Multiple log levels (`DEBUG`, `INFO`, `WARN`, `ERROR`)
- Screenshot path logging for failed tests

## Screenshots

On test failure screenshots are automatically saved to:

```
target/screenshots
```

## Continuous Integration

The project includes a GitHub Actions workflow that:

- Builds the project
- Runs the Regression test suite
- Publishes test reports
- Uploads logs as artifacts
- Uploads failure screenshots as artifacts