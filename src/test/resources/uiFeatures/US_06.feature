Feature: US_06 Adding product to basket

  Background:
    Given go to the Amazon url
    And enter "Lenovo" into search box
    And click the search button

    @TC_07
    Scenario: User should be able to see that total price of the products added to basket is correct.

      When Select first three products and add them to basket
      And Navigate to basket page
      And Verify the subtotal is correct
      Then close driver

