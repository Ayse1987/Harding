@TC_05
  Feature:US_03 Select A department from All menu
    Background:
    Given go to the Amazon url

    Scenario: User should access the "Smart Home" department from all menu and
    see the correct list of Smart Home sub-categories

      When click All menu
      And click "Smart Home" department
      And Verify that there are 16 subcategories under the "Smart Home" department
      Then close driver
