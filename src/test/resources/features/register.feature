Feature: Register Functionality

  @TC_Register_01 @Smoke @Regression
  Scenario: Successful Login with Valid Credentials
    Given User is on the login page
    When User enters valid username "mdangdn29@gmail.com" 
    And User enters valid password "D@ng291199"
    And User clicks the login button
    Then User should be redirected to the dashboard page

  @TC_Register_02 @Regression
  Scenario: Successful Login with Invalid Credentials
    Given User is on the login page
    When User enters valid username "mdangdn29@gmail.com" 
    And User enters valid password "123132131"
    And User clicks the login button
    Then User should be redirected to the dashboard page