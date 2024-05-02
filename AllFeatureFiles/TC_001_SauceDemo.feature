@EndToEndTesting
Feature: Test Sauce Demo Application

  @Broswerfunctionality
  Scenario: Test Browser Functionlity
    Given user enter "chrome" browser and open login url

  @LoginPage
  Scenario: Test login functionlity
    When user enter valid credentials and click on login button
    Then user validate title
    And user validate url

  @HomePage
  Scenario Outline: Test Cart Page Functionlity
    Given user click on "<product1>", "<product2>"

    Examples: 
      | product1            | product2              |
      | Sauce Labs Backpack | Sauce Labs Bike Light |

  Scenario: User Validate add to cart functionality
    And user click on add to cart
    Then user click on checkout button
    Then user enter FirstName, LastName and PostalCode
    And click on continue button

  @CheckOutOverview
  Scenario: Your Info Page Functionlity
    Then user validate the quantity and price of the product
    Then user click on finish button
    Then user validate the thank you message
    Then user click on button
    Then user click on logout button
    Then user validate it
