🚀 API Automation Testing with Cucumber & RestAssured

This project is a BDD-style API automation framework built with:

Cucumber
 for BDD feature files

RestAssured
 for API testing

TestNG
 for test execution

Maven
 for build and dependency management

It demonstrates API test automation using the public ReqRes API
.

📂 Project Structure
src
 └── test
     ├── java
     │   ├── stepdefinitions    # Step definition classes
     │   │    └── UserSteps.java
     │   ├── runners            # TestNG + Cucumber runner
     │   │    └── TestRunner.java
     │   └── payload            # (Optional) Payload POJOs
     │        └── Login.java
     └── resources
         ├── features           # Feature files in Gherkin syntax
         │    └── featurefile.feature
         └── logindetails.properties (optional for credentials)

🛠️ Tech Stack

Java 11+

Maven (for build & dependency management)

RestAssured – for REST API requests

Cucumber – for writing BDD scenarios in Gherkin

TestNG – for test execution & reporting

Lombok (optional) – to reduce boilerplate in POJOs

⚙️ Setup Instructions

Clone the repo

git clone <your-repo-url>
cd <project-folder>


Import into IntelliJ / Eclipse
Make sure to enable annotation processing if using Lombok.

Install dependencies

mvn clean install

▶️ Running Tests
Run with Maven
mvn clean test -Dtest=TestRunner

Run from IDE

Open TestRunner.java

Right-click → Run 'TestRunner'

✅ Sample Scenario

Feature file: featurefile.feature

Feature: Get User Details API

  Scenario: Verify user details by ID
    Given I have the user API endpoint
    When I send a GET request for user with ID 2
    Then the response status should be 200
    And the user name should be "Janet Weaver"


Step Definition: UserSteps.java

@Given("I have the user API endpoint")
public void i_have_the_user_api_endpoint() {
    baseUrl = "https://reqres.in/api/users";
}

📊 Reports

After execution, reports are generated in:

target/cucumber-report.html


Open the file in a browser to view the test results.

🔧 Troubleshooting

Undefined steps → Ensure your step definitions are under src/test/java and package is scanned by @CucumberOptions.

setUserName not found → Lombok not working → either enable annotation processing or write getters/setters manually.

Feature not found → Make sure your .feature files are under src/test/resources/features.
