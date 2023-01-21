@Products @Regression
Feature: Products

  Scenario: I verify the cart button is displayed on the product page
    Given I log in with the standard user
    Then I observe the shopping cart button on the products page

  Scenario: I click the hamburger menu and observe All Items, About, Logout, and Reset App State
    Given I log in with the standard user
    And I click the hamburger menu on the products page
    Then I observe 'ALL ITEMS', 'ABOUT', 'LOGOUT', and 'RESET APP STATE' on the menu

  Scenario: The filter for products defaults to Name (A To Z)
    Given I log in with the standard user
    Then I verify the default filter for products is 'Name (A to Z)'

  Scenario: I log out of my account and log back in to ensure the filter defaults to Name (A To Z)
    Given I log in with the standard user
    And I click the hamburger menu on the products page
    And I click 'LOGOUT' on the menu
    And I enter 'standard_user' into the username field
    And I enter 'secret_sauce' into the password field
    And I click the LogIn button
    Then I verify the default filter for products is 'Name (A to Z)'
