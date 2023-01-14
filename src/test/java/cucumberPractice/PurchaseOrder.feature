@tag
 Feature: Purchase the order from E-commerce website

  Background:
   Given I landed on page

  @tag2
  Scenario Outline: Positive Test of Submitting the order
   Given Logged in with username <name> and password <password>
   When I add product <brandName> to Cart
   And Checkout <brandName> and submit the order
   Then I verify the <status> in step

   Examples:
    | name           | password  | brandName |  |
    | name@email.com | pass-word | POLO      |  |