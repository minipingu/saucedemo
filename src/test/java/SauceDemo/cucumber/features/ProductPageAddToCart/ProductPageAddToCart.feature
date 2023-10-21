Feature: Product Page add to cart and remove button

Scenario Outline: To ensure product page add to cart and remove button are working
 Given user is on SauceDemo login page
  When user input <username> as email
  And user input <password> as password
  Then user click submit
  When user click product
  And user click <button> add to cart or remove
  Then user verify <shopping_cart_badge> added or removed

  Examples:

  |username     |password    |button     |shopping_cart_badge|
  |standard_user|secret_sauce|Add To Cart|added              |
  |standard_user|secret_sauce|Remove     |empty              |