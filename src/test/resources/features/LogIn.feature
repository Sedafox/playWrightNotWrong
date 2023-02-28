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

  Scenario Outline: Log in to Swag Labs with incorrect credentials
    Given I navigate to the log in page of Swag Labs
    And I enter "<username>" into the username field
    And I enter "<password>" into the password field
    When I click the LogIn button
    Then I observe the text 'Epic sadface: Username and password do not match any user in this service' on the log in page

    Examples:
      | username   | password  |
      | oh_hi_mark | pineapple |
      | no_u       | who_me?   |


  Scenario: The word Sandwich does not appear on the login page
    Given I navigate to the log in page of Swag Labs
    Then the text 'Sandwich' is not displayed on the log in page

  Scenario: I provide incorrect credentials so I can see the X icon indicating my credentials are wrong
    Given I navigate to the log in page of Swag Labs
    And I enter 'standard_user' into the username field
    When I click the LogIn button
    Then I see an x icon in the username field to indicate my username is incorrect

  Scenario: When I visit the login page, I observe the Swag Labs logo
    Given I navigate to the log in page of Swag Labs
    Then I observe the Swag Labs logo

  Scenario: The Login Page Only Has Two Input Fields
    Given I navigate to the log in page of Swag Labs
    Then I observe that only 2 input fields exist