Feature: Cart Management
  In order to manage items in my cart
  As a user
  I want to add and remove items from my cart 

  @tc3 @cart @regression
  Scenario Outline: Verify adding items to the cart
    Given I am on the homepage
    When I log in with username and password
    When I add item "<item>" to the cart
    Then I should see "<item>" in the cart

    Examples:
      | item                |
      | Sauce Labs Backpack |
