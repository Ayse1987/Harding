Feature: search results
  Background:
    Given go to the Amazon url
    
    @TC_04
    Scenario: User should see the each search result includes the word searched
      When enter "Lenovo" into search box
      And click the search button
      Then verify that all the products listed includes "Lenovo"
      Then close driver
