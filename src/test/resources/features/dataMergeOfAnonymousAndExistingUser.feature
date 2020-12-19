@Cart @UserSynchronization
Feature: Merging carts of anonymous and existing user
  Product can be added to the cart, after direct search of the specified item.

  Scenario: Adding product to cart via search
    Given I open main page
    Then I add a Apple AirPods to the cart
    And I proceed to cart from modal window
    Then I verify the Apple AirPods added to the cart
    When I verify that subtotal is present
    Then I change Apple AirPods quantity to 3
    Then I verify that subtotal value has multiplied by 3
    Then I Log in as existing user
    And I Verify carts of anonymous and logged in user are merged (3 of Apple AirPods are present in cart)

    #Cleaning data after test
    Scenario: Empty Cart
      Given Open cart page
      And Empty the cart