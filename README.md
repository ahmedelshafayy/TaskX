﻿**TaskX - E-commerce Checkout Flow Automation Project**

**Overview**
The TaskX project automates the end-to-end flow of a shopping experience on the Konakart website using Selenium WebDriver with Java. The test includes account registration, navigating product categories, sorting products, adding items to the cart, validating cart and order details, and verifying the checkout process.

The project employs the Page Object Model (POM) design pattern to ensure modularity, maintainability, and scalability of the code.


**Features Automated**
-Account Registration:
Registers a new account with dynamically generated email IDs.
-Navigation:
Navigates through product categories (e.g., DVD Movies > Action).
-Sorting:
Sorts products in the "Action" category by "Price: Low to High".
-Cart Management:
Adds single and multiple items to the cart.
Validates item counts, prices, and subtotal.
-Checkout Flow:
Proceeds to checkout using registered accounts.
Sets payment method and confirms the order.
-Order Validation:
Verifies order status and item details in the "My Account" section.
-Error Handling:
Validates form input errors during registration.


**Project Structure**
css
Copy code
src
├── main
│   └── java
│       └── pages
│           ├── ActionMoviesPage.java
│           ├── CartPage.java
│           ├── CheckoutConfirmationSubmitPage.java
│           ├── CheckoutPage.java
│           ├── HomePage.java
│           ├── LoginPage.java
│           ├── MovieDetailsPage.java
│           ├── MyAccountPage.java
│           └── RegistrationPage.java
└── test
└── java
└── tests
└── TaskXTest.java


**Key Components**

-Pages:
Each webpage or functional module is encapsulated in a separate class for modularity.
Example: ActionMoviesPage handles interactions specific to the Action Movies category.

-Tests:
The TaskXTest class contains the main test flow to execute the shopping and checkout scenarios.

Configuration:
The test is configured with TestNG for managing test execution.

**Tools and Libraries Used**
-Selenium WebDriver: For web automation.
-TestNG: For test case management and assertions.
-Java: Programming language.
-ChromeDriver: To interact with the Chrome browser.
-POM (Page Object Model): For code organization.
-Maven: For dependency management and build configuration.

**Prerequisites**
-Java Development Kit (JDK): Version 8 or above.
-Maven: Installed and configured in the system.
-ChromeDriver: Ensure the appropriate version for your Chrome browser is available.
-TestNG Plugin: Installed in your IDE (e.g., IntelliJ IDEA, Eclipse).
