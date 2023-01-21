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

  Scenario Outline: I change the filter from Name (A to Z) to other options
    Given I log in with the standard user
    And I click the filter product button
    Then I select "<filter_selection>" from the filter selection dropdown
    Then I verify the current filter for products is displayed as "<filter_selection>"

    Examples:
      | filter_selection    |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |

  Scenario Outline: I verify that changing the filter changes the product on the page
    Given I log in with the standard user
    Then I verify the first product on the page is 'Sauce Labs Backpack'
    And I click the filter product button
    Then I select "<filter_selection>" from the filter selection dropdown
    Then I verify the first product on the page is "<expected_first_product>"

    Examples:
      | filter_selection    | expected_first_product            |
      | Name (Z to A)       | Test.allTheThings() T-Shirt (Red) |
      | Price (low to high) | Sauce Labs Onesie                 |
      | Price (high to low) | Sauce Labs Fleece Jacket          |

  Scenario: I click add to cart on the third product
    Given I log in with the standard user
    And I click add to cart on product number 3
    Then the button on product number 3 now displays Remove

  Scenario: I add an item to the cart and verify the cart now displays a icon
    Given I log in with the standard user
    And I add 'Sauce Labs Bolt T-Shirt' to the cart
    Then the shopping cart displays a '1' badge
    And I add 'Sauce Labs Backpack' to the cart
    Then the shopping cart displays a '2' badge

