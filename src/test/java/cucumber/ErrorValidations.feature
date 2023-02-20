@tag
Feature: Error validation

  Background: I landed on Ecommerce page

  @ErrorValidation
  Scenario Outline:
    Given I landed on Ecommerce page
    When When logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed

      Examples:
      //its just like data provider
        | name          | password |
        | test@test.com | Test123. |