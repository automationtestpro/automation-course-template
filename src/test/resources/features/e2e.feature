Feature: E2E testing checkout flow
    In order to test the end-to-end checkout flow
    As a user
    I want to add items to the cart, proceed to checkout, and complete the purchase
    
    @tc4 @e2e @regression
    Scenario Outline: Verify end-to-end checkout flow
        Given I am on the homepage
        When I log in with username and password
        When I add item "<item>" to the cart
        And I proceed to checkout
        And I enter shipping information with first name "<firstName>", last name "<lastName>", and postal code "<postalCode>"
        And I complete the purchase
        Then I should see a confirmation message
    
        Examples:
        | item                | firstName | lastName | postalCode |
        | Sauce Labs Backpack | John      | Doe      | 12345      |
        | Sauce Labs Bike Light | Jane   | Smith    | 67890      |