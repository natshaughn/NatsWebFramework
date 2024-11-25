Feature: Failure
  @Failure
  Scenario: Fail Test
    Given I am on the login page
    When I enter the username 'standard_user'
    And I enter the password 'secret_saucessss'
    And I click the login button
    Then I am on the inventory page