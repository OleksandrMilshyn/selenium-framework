# Selenium WebDriver + TestNG Practice

This project was created as a practice assignment for UI test automation using Selenium WebDriver, Java and TestNG.

## Technologies

- Java 17
- Maven
- Selenium WebDriver 4
- Selenium Manager
- TestNG
- Page Object Model (POM)
- Page Factory

## Project Structure

```
src
├── main
│   ├── java
│   │   ├── base
│   │   ├── pages
│   │   └── utils
│   └── resources
└── test
    ├── java
    │   └── tests
    └── resources
```

## Automated Test Scenarios

### 1. Add Product to Cart

- Login with valid credentials
- Verify successful login
- Add **Sauce Labs Backpack** to the cart
- Verify cart badge
- Open the cart
- Verify the product in the cart

### 2. Complete Checkout

- Login
- Add product to the cart
- Open the cart
- Proceed to checkout
- Fill customer information
- Complete the order
- Verify successful checkout

### 3. Sort Products and Remove Item

- Login
- Sort products by **Price (Low to High)**
- Verify sorting order
- Add the cheapest product to the cart
- Open the cart
- Remove the product
- Verify the cart is empty

## Implemented Features

- Page Object Model
- Page Factory
- Abstract Page
- Base Test
- Explicit Waits
- Implicit Waits
- Multiple locator strategies (`id`, `className`, `css`)
- TestNG assertions
- Configuration via `config.properties`

## Running Tests

Run all tests with Maven:

```bash
mvn test
```

Or execute the TestNG suite:

```
src/test/resources/testng.xml
```