Feature: Test HTTP POST method for creating a 'Nace record'

  Scenario: Create nace record with correct request body
    Given I set POST nace for 'addNace' endpoint
    When I set post request headers
    And Send a POST HTTP request with body
    Then I get a response code 200
