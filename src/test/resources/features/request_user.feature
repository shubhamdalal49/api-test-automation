@reqres @smoke
Feature: Reqres User API automation

  @get @regression
  Scenario: Get user list
    Given I set GET endpoint for "users" in ReqRes API
    When I send a GET HTTP request
    Then the response status code should be 200
    And response should match JSON schema "reqres_users_schema.json"

  @post @smoke
  Scenario Outline: Create a new user
    Given I set POST endpoint for "users" in ReqRes API
    And I provide JSON payload from "<datafile>"
    When I send a POST HTTP request
    Then the response status code should be 201

    Examples:
      | datafile                    |
      | create_user_1.json          |

  @put @json @regression
  Scenario: Update a user
    Given I set PUT endpoint for "users/2" in ReqRes API
    And I provide JSON payload from "update_user.json"
    When I send a PUT HTTP request
    Then the response status code should be 200

  @delete @regression
  Scenario: Delete a user
    Given I set DELETE endpoint for "users/2" in ReqRes API
    When I send a DELETE HTTP request
    Then the response status code should be 204
