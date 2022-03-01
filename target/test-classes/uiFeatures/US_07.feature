Feature: US_07 links at the bottom of the page
  Background:
    Given go to the Amazon url

    Scenario: User should see that the second column of the links listed at the bottom
    of the home page navigate user to right pages.
      And scroll down to the bottom of the home page
      And click the links in the second column and verifies page name
      Then close driver
