Feature: Login
    User can Login

  @TC01  
  Scenario: Successful login
    Given I am on the login page
    When I enter email "<email>"
    And I enter password "<password>"
    And I click on the login button
    Then I should be redirected to the dashboard

  @TC02
  Scenario Outline: Test login
    Given I am on the login page
    When I enter email "testtest@gmail.com"
    And I enter password "password123"
    And I click on the login button
    Then I should be redirected to the dashboard

    Examples:
      | email                | password      |
      | "testtest@gmail.com" | "password123" |
      | ""                   | "password123" |
      | "testtest@gmail.com" | ""            |
