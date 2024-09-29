## EvershopAutomationProject_v101
## Project Overview: Automation Testing for Evershop
This project automates the testing of Evershop e-commerce platform, developed using Selenium WebDriver with Java and TestNG. The main focus is to automate key features of the Evershop platform, ensuring thorough testing of the following functionalities:
* User Registration
* Login
* Product Search
* Add to Cart
* Checkout Process

## Key Features
* **Registration and Login Tests:** Automated validation for user creation and login processes.
* **Product Search and Add to Cart:** Tests covering search functionality and adding products to the shopping cart.
* **Checkout Process Test:** Automate the entire checkout workflow, including adding items to the cart, providing shipping details, and completing payment.
* Test grouping with TestNG (e.g., Sanity, Regression).
* Extent Reports with failure screenshots.
* run.bat file for executing tests via Maven.
* Jenkins Integration with GitHub for automated builds.

## Planned Features
* **Account Management Tests:** Automate scenarios like updating profile information, changing passwords, and viewing order history.
* **Cross-browser Compatibility Tests:** Ensure functionality works across multiple browsers, including Chrome, Firefox, and Safari.

## How to Run the Tests

### Running Tests via TestNG Suites
- **`master.xml`**: Use this suite to execute the entire test suite.
- **`grouping.xml`**: This suite allows you to run specific groups of tests, such as **Sanity**, **Regression**, etc.

### Running Tests Using `run.bat` (Windows Users)
For a convenient approach, Windows users can utilize the `run.bat` file provided in the project root. This batch script automates the process of executing the Maven tests.

## Jenkins Integration
This project is configured to work with Jenkins for continuous integration and continuous delivery. Jenkins allows you to schedule or trigger test executions automatically whenever changes are made to the repository.

