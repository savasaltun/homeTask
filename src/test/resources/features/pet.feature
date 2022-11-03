Feature:

@pet
  Scenario: verify that pet is created
    Given the user create a pet
    When  the user get the created pet
    And verify that name is equal
    And status is "available"
