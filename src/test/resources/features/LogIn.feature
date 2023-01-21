@LogIn @Regression
Feature: Log In

  Scenario Outline: Log in to Swag Labs with proper credentials
    Given I navigate to the log in page of Swag Labs
    And I enter "<username>" into the username field
    And I enter "<password>" into the password field
    When I click the LogIn button
    Then I observe the Products page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |


  Scenario: The word Sandwich does not appear on the login page
    Given I navigate to the log in page of Swag Labs
    Then the text 'Sandwich' is not displayed on the log in page