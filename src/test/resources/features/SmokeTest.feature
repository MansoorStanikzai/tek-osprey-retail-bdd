@Smoke
Feature: Major Functionalities for Smoke Test

  @Story_1
  Scenario: Validate Home page title
    Then Validate top left corner is "TEKSCHOOL"

      @Story_2
    Scenario: Validate Home page title and sign in button
      Then Validate top left corner is "TEKSCHOOL"
      Then Validate Sign In Button is Enabled
