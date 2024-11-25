# Selenium Test Automation for KonaKart Shopping Flow

This project automates end-to-end testing for the KonaKart e-commerce platform
using Selenium WebDriver and TestNG. The tests cover functionalities such as 
user registration, product navigation, adding items to the cart, 
verifying cart contents, and completing an order.


---

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Test Execution](#test-execution)
- [Dependencies](#dependencies)
---

## Features

- Automates user registration with dynamically generated usernames.
- Sorts products by price in ascending order.
- Adds products to the cart and validates cart details.
- Verifies order summary and calculates the subtotal.
- Completes checkout using a specified payment method.
- Confirms order processing and validates order details.

---

## Project Structure

```plaintext
src/
├── main/
│   └── java/
│       └── pages/
│           ├── ActionMoviesPage.java
│           ├── CartPage.java
│           ├── CheckoutConfirmationSubmitPage.java
│           ├── CheckoutPage.java
│           ├── HomePage.java
│           ├── LoginPage.java
│           ├── MovieDetailsPage.java
│           ├── MyAccountPage.java
│           └── RegistrationPage.java
└── test/
    └── java/
        └── tests/
            └── TaskXTest.java
