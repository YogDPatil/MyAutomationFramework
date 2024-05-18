#Author: ydpatil.it@gmail.com
@sanity @smoke @regression
Feature: To test login api request feature

  Scenario: To validate that login using api request and generate access token
    Given The base url of the application is "http://139.59.91.96:9000/v1"
    And The header passed is "Content-Type" and "application/json"
    And Enter login credentials in body "iamfd" and "password"
    When Post api request with endpoint "/login"
    Then Validate status code of the login api request 200
    And Response time should be less than 1500
    And The response body should contains "Success" message
    And Token should be generated
