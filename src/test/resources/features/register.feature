Feature: register
    As a user
    I want to register
    So that I can access the application

    @tc03 @register
    Scenario: register with valid credentials
        Given I am on the login page
        When I enter username "testtest@gmail.com"
        And I enter password "testtest"
        And I click on login button
        Then I should be logged in