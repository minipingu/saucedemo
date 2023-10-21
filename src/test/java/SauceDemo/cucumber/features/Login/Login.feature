Feature: Login functionality

Scenario Outline: Ensure login functionality
 Given user is on SauceDemo login page
  When user input <username> as email
  And user input <password> as password
  When user click submit
  Then user verify <status> login result

  Examples:

  |username     |password    |status
  |standard_user|secret_sauce|success
  |standard_user|wrong       |failed