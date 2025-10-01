Feature: Get User Details API

  Scenario: Verify user details by ID
    Given I have the user API endpoint
    When I send a GET request for user with ID 2
    Then the response status should be 200
    And the user name should be "Janet Weaver"
