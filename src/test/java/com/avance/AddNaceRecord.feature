Feature: Test HTTP POST method for creating a 'Nace record'

  Scenario: Create nace record with correct request body
    Given I set POST nace for 'addNace' endpoint
    When I set request headers
    And Send a POST HTTP request with body
    Then I get a response code 200

  Scenario: When creating Nace object ensure OrderId is not negative number and is greater than 1
    Given I set POST Nace for 'addNace' endpoint
    When  I set orderId as negative number on Nace request
    And Send a POST HTTP request
    Then I receive a response code 200