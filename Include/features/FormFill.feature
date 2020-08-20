Feature: Register User

  Scenario: User fills up the users detail
    Given User navigate to test qatechhub website
    When User enters all the required details
      | FirstName   | Saurabh               |
      | LastName    | Dhingra               |
      | EmailId     | saurabh@qatechhub.com |
      | PhoneNumber |            9454390654 |
      | Gender      | Male                  |
      | Course      | Cypress               |
    And User clicks on submit button
    Then Success message appears on the screen
