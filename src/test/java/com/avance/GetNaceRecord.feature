Feature: Test HTTP GET method for retrieving a 'Nace record'

  Scenario: Retrieve a Nace recorde with correct OrderId
    When I set get request headers
    And Send a GET HTTP request with existing OrderId
    Then I get a response code