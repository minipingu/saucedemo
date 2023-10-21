Feature: Checkout Process
Scenario Outline: To ensure checkout feature are working
 Given user login using valid credential
  When user click one of product
  And user click add to cart
  Then user user click cart icon
  When user user click checkout
  And user filling <firstname> as firstname <lastname> as lastname <zipcode> as zipcode <field>
 Then can't continue and cant finish checkout if one of <field> are empty


 Examples:
  |firstname|lastname|zipcode|field      |
  |Feria    |Shen    |12345  |filled     |
  |Feria    |Shen    |       |not filled |