
  Feature: US_05 sort and filter
    Background:
      Given go to the Amazon url
      And enter "Lenovo" into search box
      And click the search button

      @TC_06
      Scenario: User should be able to sort a product price Low to High
        When click sort by button
        And select Low to High
        Then verify items are sorted correctly