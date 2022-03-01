Feature: US_09 Add product to shopping list and delete it
  Background:
    Given go to the Amazon url
    And navigate to sign in page
    And enter valid email address to the email box
    And click continue button
    And enter valid password to the password box
    And click sign-in button

    @TC_10
    Scenario:User should be able to add products to the created list and remove it

      And select Create a List from Account & Lists menu
      And click create list button in page
      And enter "Grocery List" to the List name box
      And click create List button
      And enter "cheddar cheese" into search box
      And click the search button
      And add the first product to "Grocery List"
      And verify the product in the list
      And clic view your list button
      And click Remove button for added product
      Then verify that product is removed
      And click Manage List from More menu
      And click Delete list button
