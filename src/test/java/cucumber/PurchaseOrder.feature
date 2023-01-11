@tag
 Feature: Purchase the order from E-commerce website

  Background:
   Given I landed on page

  @tag2
  Scenario Outline: Positive Test of Submitting the order
   Given Logged in with username "name@email.com" and password "pass-word"
   When I add product <productName> to Cart
   And Checkout <productName> and submit the order
   Then I verify the <status> in step

   Examples:
    | name           | password  | productName |
    | name@email.com | pass-word |