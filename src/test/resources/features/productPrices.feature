@Catalog
Feature: Products prices
  Dollar symbol should be present to symbolize price in the catalog

  Scenario: Presence of $ symbol on the home page products
    Given I open main page
    Then I verify that dollar symbol is present before each price tag