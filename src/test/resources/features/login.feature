Feature: login
    As a user
    I want to login
    So that I can access the application
    # @tc01 @login 
    # Scenario: login with valid credentials
    #     Given I am on the login page
    #     When I enter username "testtest@gmail.com"
    #     And I enter password "testtest"
    #     And I click on login button
    #     Then I should be logged in
    # @tc02 @login
    # Scenario: login with invalid credentials
    #     Given I am on the login page
    #     When I enter username "testtest@gmail.com"
    #     And I enter password "testtest123"
    #     And I click on login button
    #     Then I should be logged in

  @login
  Scenario Outline: login test
    Given I am on the login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click on login button
    Then I should be logged in

    Examples:
      | username        | password |
      | test1@gmail.com | test1    |
      | test2@gmail.com | test2    |
