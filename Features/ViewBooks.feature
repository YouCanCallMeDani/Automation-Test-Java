Feature: View Books
  Scenario: I want to view book on demoqa
    Given User go to View Books
    When User in Book Store page
    And User search book Git Pocket Guide
    And User click book Git Pocket Guide
    Then User see Git Pocket Guide