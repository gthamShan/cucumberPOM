Feature: Product Page Feature

  Background: 
    Given user has already logged into application
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario: Products Page Title
    Given user is on Products page
    Then page title should be "Swag Labs"

  Scenario: Products List and count
    Given user is on Products page
    Then below are the products
      | Sauce Labs Backpack               | $29.99 |
      | Sauce Labs Bike Light             | $9.99  |
      | Sauce Labs Bolt T-Shirt           | $15.99 |
      | Sauce Labs Fleece Jacket          | $49.99 |
      | Sauce Labs Onesie                 | $7.99  |
      | Test.allTheThings() T-Shirt (Red) | $15.99 |
    And products count should be 6
