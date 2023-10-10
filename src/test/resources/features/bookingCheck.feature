Feature: Booking functionality

  Scenario: Checking maximum number of booking rooms
    Given the user is on the homepage
    When the user clicks the plus button for booking rooms 5 times
    And clicks the plus button for booking rooms 10 more times
    Then the maximum number of booking rooms should be 9

  Scenario: Checking maximum number of adult persons
    Given the user is on the homepage
    When the user clicks the plus button for adult persons 20 times
    And clicks the plus button for adult persons 20 more times
    Then the maximum number of adult persons should be 30

#  Scenario: Checking maximum number of children
#    Given the user is on the homepage
#    When the user clicks the plus button for children 8 times
#    And clicks the plus button for children 8 more times
#    Then the maximum number of child rooms should be 12
