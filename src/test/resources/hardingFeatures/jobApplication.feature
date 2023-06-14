
Feature: Job Application

  Background: same steps before coming to application form
    Given user navigates to Harding homepage
    When user hoovers Career link and click Landside link
    Then user verifies landside career page
    When user clicks See Vacancies button
    Then user verifies landside department page
    And user searches for "Procurement Coordinator" job in the search bar
    Then user verifies the job
    When user clicks Apply button
    Then user verifies personal information title


#HAppy Path Scenario
  Scenario: submit job application
    Then user fills in the mandatory fields with the provided data and a valid file
    And user clicks next button
    When user fills the Equal Opportunities Section
    And user fills About my Application Section
    When user clicks submit application button
    Then user verifies application completed message
    And close driver


# accepts PNG, PDF, WORD for CV
  Scenario Outline:submit job application with different CV formats
    Then user fills in the mandatory fields with the provided data and "<different valid files>"
    And user clicks next button
    When user fills the Equal Opportunities Section
    And user fills About my Application Section
    When user clicks submit application button
    Then user verifies application completed message
    And close driver

    Examples:
      | different valid files |
      | WORD                  |
      | PNG                   |
      | PDF                   |


  @JobApplication
#missing mandatory fields gives error message
  Scenario Outline: testing mandatory fields
    Then user fills the mandatory fields with "<firstname>", "<surname>", "<email>", "<phoneNumber>", "<file>", "<address>"
    And user clicks next button
    Then user should see error message
    And close driver

    Examples:
      | firstname | surname | email            | phoneNumber | file | address |
      |           | Nemeth  | agnes1@gmail.com | 07777111111 | WORD | Bristol |
      | Agnes     |         | agnes2@gmail.com | 07777111111 | WORD | Bristol |
      | Agnes     | Nemeth  |                  | 07777111111 | WORD | Bristol |
      | Agnes     | Nemeth  | agnes3@gmail.com |             | WORD | Bristol |
      | Agnes     | Nemeth  | agnes5@gmail.com | 07777111111 | WORD |         |
      | Agnes     | Nemeth  | agnes4@gmail.com | 07777111111 |      | Bristol |


#Cover letters in PNG, EXE and BAT format should give error, but PNG file format fails
  Scenario Outline:submit job application with different cover letter formats
    Then user fills in the mandatory fields with the provided data and a valid file
    And user clicks next button
    When user fills the Equal Opportunities Section
    And user fills About my Application Section with "<invalid file format>" for cover letter
    And close driver
    Examples:
      | invalid file format |
      | EXE                 |
      | BAT                 |
      | CoverLetterPNG      |






