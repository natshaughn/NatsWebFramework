Feature: ProductPriceCSV
  Scenario: Using .csv file to confirm product prices
    Given I have logged in
    When I am on the inventory page
    Then the price of all products will be correct