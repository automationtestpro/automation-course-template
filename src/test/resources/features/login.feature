Feature: Logon
    In order to access the application
    As a user
    I want to log in

  @smoke @tc1 @regression
  Scenario: Successful login
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the dashboard
