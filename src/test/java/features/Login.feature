Feature: Login

  Scenario: Login
    Given I am on the login page
    When I enter the username
    And I enter the password 'secret_sauce'
    And I click the login button
    Then I am on the inventory page