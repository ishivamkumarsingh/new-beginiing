Feature: Search for a course in the iframe

  Scenario: Verify course search functionality inside iframe
    Given I am on the Let's Kode It practice page
    When I switch to the iframe
    And I search for "Selenium"
    Then No courses should be displayed
