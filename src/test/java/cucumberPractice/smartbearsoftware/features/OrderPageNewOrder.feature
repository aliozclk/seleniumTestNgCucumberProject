@orderPage
  Feature: Order Page New Order Feature

    Background:
      Given the user is on the login page
      And the user logged in with valid credentials, "Tester" as username and "test" as password
      Then the user is on the web orders page
      And the user clicks on the order link


      Scenario Outline: The user selects product and quantity then calculates total price.
        #Product entries

        When the user is on the order page
        And the user sets product type as "<productName>"
        And the user sets "<quantity>" of product
        And the user clicks on the calculate button
        Then the user calculates order : product cost X "<quantity>"

        #User gives Address Information
        And the user sets address infos <customerName> , <street>, <city> , <state> , <zipCode>

        #User gives payment Information
        And the user sets card type <cardType>, <cardNumber>, <expireDate>
        And the user clicks on process button
        Then the user gets "New order has been successfully added." message

        #User navigates to the web order page
        When the user is on the web orders page
        Then the user should see order infos on the table : <customerName>, <productName>, <quantity>, <street>, <city>, <state>, <zip>,<cardType>,<cardNumber>,<expireDate>


        Examples:
          | productName | quantity | customerName | street   | city  | state  | zipCode  | cardType   | cardNumber | expireDate |  |
          | MyMoney     | 5        | Customer-1   | Street-1 | city1 | state1 | zipcode1 | Visa       | 123456789  | 08/25      |  |
          | FamilyAlbum | 3        | Customer-2   | Street-2 | city2 | state2 | zipcode2 | MasterCard | 123456781  | 09/26      |  |



