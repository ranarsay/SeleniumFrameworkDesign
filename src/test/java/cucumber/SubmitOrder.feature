@tag
  Feature: Purchase the order from E-commerce Website

    Background:
      Given I landed on E-commerce page

    @Regression
    Scenario Outline: Positive test of submitting the order
      Given Logged in with user name <name> and password <password>
      When I add product <productName> from Cart
      And Checkout <productName> and submit the order
      Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page
      Examples:
      //its just like data provider
        | name           | password | productName |
        | hilal@test.com | Test123. | ZARA COAT 3 |


