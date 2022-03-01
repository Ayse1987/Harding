Feature: US_08_Create a Shopping list and delete it
  Background:
    Given go to the Amazon url
    And navigate to sign in page
    And enter valid email address to the email box
    And click continue button
    And enter valid password to the password box
    And click sign-in button

    @TC_09
    Scenario:User should be able to create a shopping list and delete it.

    And select Create a List from Account & Lists menu
    And click create list button in page
    And enter "Grocery List" to the List name box
    And click create List button
    And verify that "Grocery List" is created
    And click Manage List from More menu
    And click Delete list button
    Then verify the list is deleted

