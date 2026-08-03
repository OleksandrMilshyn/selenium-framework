# Selenium WebDriver Framework

UI test automation framework developed with Selenium WebDriver, Java and TestNG.

## Technologies

- Java 17
- Maven
- Selenium WebDriver 4
- WebDriverManager
- TestNG
- Log4j2
- Page Object Model (POM)
- Page Factory

---

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
│       ├── config-dev.properties
│       └── config-test.properties
│
└── test
    ├── java
    │   ├── listeners
    │   └── tests
    └── resources
        ├── log4j2.xml
        └── suites
            ├── smoke.xml
            └── regression.xml
```

---

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
- Sort products by price (Low to High)
- Verify sorting order
- Add the cheapest product to the cart
- Remove the product
- Verify the cart is empty

---

## Implemented Features

- WebDriverManager
- Driver Factory
- Page Object Model
- Page Factory
- Abstract Page
- Business Object (Customer)
- Explicit Waits
- Implicit Waits
- Multiple locator strategies (`id`, `className`, `css`)
- Multi-browser support (Chrome, Firefox)
- Multiple environments (dev, test)
- Smoke and Regression TestNG suites
- Log4j2 logging
- Screenshot capturing on test failure
- TestNG Listener

---

## Running Tests

Run Regression suite:

```bash
mvn test
```

or

```bash
mvn test "-DsuiteXmlFile=src/test/resources/suites/regression.xml"
```

Run Smoke suite:

```bash
mvn test "-DsuiteXmlFile=src/test/resources/suites/smoke.xml"
```

Run tests in Chrome:

```bash
mvn test "-Dbrowser=chrome"
```

Run tests in Firefox:

```bash
mvn test "-Dbrowser=firefox"
```

Run tests for TEST environment:

```bash
mvn test "-Denv=test"
```

Run tests for DEV environment:

```bash
mvn test "-Denv=dev"
```

---

## Logging

- Console logging
- Daily rolling log files
- Multiple log levels (`DEBUG`, `INFO`, `WARN`, `ERROR`)
- Screenshot path is logged when a test fails

---

## Screenshots

On test failure, screenshots are automatically saved to:

```
target/screenshots
```

The screenshot location is written to the application log.

---