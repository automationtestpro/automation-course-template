Feature: Login Feature

    Scenario: verify login success
        Given browser is opened
        When enter email "testtest@gmail.com"
        And enter password "testtest"
        And click submit
        Then verify login successfully