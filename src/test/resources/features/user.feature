Feature:
  @user
  Scenario: verify that user is able to create a user
    When the user create a user
    Then verify that user is created and code is 200