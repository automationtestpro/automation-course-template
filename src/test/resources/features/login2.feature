Feature: Login Functionality

  @TC_Login_03 @Smoke @Regression
  Scenario Outline: Successful Login with Valid Credentials
    Given User is on the login page
    When User enters valid username <username>
    And User enters valid password <password>
    And User clicks the login button
    Then verify expectedMessage is displayed <expectedMessage>

    Examples:
      | username              | password     | expectedMessage |
      | "mdangdn29@gmail.com" | "D@ng291199" | ""              |
      | " "                   | "D@ng291199" | "1"             |
      | "mdangdn29"           | "12342342"   | "2"             |
