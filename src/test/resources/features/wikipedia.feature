@wikipedia
Feature:User is on the wikipedia home page


  Background: user is the wikipedia home page
    Given user navigate to wikipedia


  Scenario:navigate to wikipedia
    When User can verify the Wikipedia logo


    Scenario:User search anything on the wikipedia
      When User writes "William Shakespeare"
      And User clicks search button
      Then verify that User should be able to see the page title
