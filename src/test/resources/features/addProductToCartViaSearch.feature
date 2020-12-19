@Cart @Catalog @Search
Feature: User Cart and adding a product via search
  Product can be added to the cart, after direct search of the specified item.

  Scenario: Adding product to cart via search
    Given I open main page
    Then I use search to find product: Apple AirPods
    Then I add a Apple AirPods to the cart
    And I proceed to cart from modal window
    Then I verify the Apple AirPods added to the cart

     #Cleaning data after test
  Scenario: Empty Cart
    Given Open cart page
    And Empty the cart