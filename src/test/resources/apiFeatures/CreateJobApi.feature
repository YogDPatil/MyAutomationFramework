#Author: ydpatil.it@gmail.com
@sanity @api @regression
Feature: To test crate job api request

  Scenario: To validate that user can create job using api and job id is created
    Given The base url of the application is "http://139.59.91.96:9000/v1"
    And The header of the request is
      | Key           | Value            |
      | Content-Type  | application/json |
      | Authorization | randomToken      |
    And The request body is
      | CustomerFName | CustomerLName | IMEI            | ProductName | MobileNumber | DOP        | Email    |
      | Yogesh        | Patil         | 123456789012345 | Google      | Nexus2       | 13/01/2024 | ab@bc.de |
    And The post request with the endpont "/job/create"
    Then Job nunber needs to create
    And Status code of create job api request should be 200
