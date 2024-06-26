This project is designed to automate the registration and login functionalities of a website using Selenium WebDriver and TestNG. 
It includes test scripts written in Java and follows the Page Object Model (POM) design pattern.
Clone this repository to your local machine using the following command: git clone <repository_url>
Install Dependencies: Make sure you have Maven installed on your machine. Then, navigate to the project directory and run the following command to install the project dependencies:mvn clean install
Download WebDriver: Download the appropriate WebDriver executable for your browser (e.g., ChromeDriver for Google Chrome) and place it in the drivers directory of the project.
Update Configuration: Update the configuration file (if any) to set the correct URLs and other parameters for the website under test.
How to Run Tests
To execute the test scripts, follow these steps:

Run Tests via Maven: Open a terminal or command prompt, navigate to the project directory, and run the following Maven command to execute the tests:
mvn test

View Test Results: After the tests are executed, you can view the test results and reports generated by TestNG in the target directory of the project.
Test Reports: TestNG generates HTML test reports that provide detailed information about the test execution, including pass/fail status, logs, and screenshots (if configured).
Customization: You can customize the test execution by modifying the test scripts, adding new test cases, or configuring TestNG XML files according to your requirements.
Test Data Document: json files within the project 
