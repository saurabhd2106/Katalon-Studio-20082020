@FeatureA
Feature: Login to Guru99 Application

  Background: 
    Given User navigates to demo application login page

  Scenario: User logins with correct credentials
    When User enters username as mngr279003
    And User enters password as yhuravY
    And User click login button
    Then User successfully logins to the application

	@RegressionTest
  Scenario: User logins with incorrect credentials
    When User enters username as mngr279004
    And User enters password as ruewr
    And User click login button
    Then User gets an invalid user message

	@SanityTest
  Scenario Outline: User logins with multiple credentials
    When User enters username as <username>
    And User enters password as <userpassword>
    And User click login button
    Then User successfully logins to the application

    Examples: 
      | username   | userpassword |
      | mngr279003 | yhuravY      |
      | mngr279003 | yhuravY      |
      | mngr279003 | yhuravY      |
