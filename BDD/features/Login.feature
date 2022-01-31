Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on log out link
    Then page title should be "Your store. Login"
    And close browser

#  Scenario Outline: Successful Login with Valid Credentials
#    Given User Launch Chrome Browser
#    When User opens URL "https://admin-demo.nopcommerce.com/login"
#    And User enters email as "<email>" and password as "<password>"
#    And Click on Login
#    Then page title should be "Dashboard / nopCommerce administration"
#    When user click on log out link
#    Then page title should be "Your store. Login"
#    And close browser
#
#    Examples:
#      | email | password |
#      | admin@yourstore.com | admin |
#      | admin@yourstore1.com | admin123 |

