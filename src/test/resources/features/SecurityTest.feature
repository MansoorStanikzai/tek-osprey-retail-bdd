@Regression
Feature: Sign in page

  Background: Description about the background
    When Navigate to sign in page

    @Security_Positive
    Scenario Outline: Sign in and Validate
      And User enter "<email>" and "<password>"
      Then Log in
      Then Validate that you sign in successfully, find the logout button

      Examples:
      | email             | password  |
      | mansoor@gmail.com | Ruya@2014 |
      | vsvp4321@live.com | Ruya@2014 |

      @Security_Negative
      Scenario Outline: Validate Sign in with Invalid Credentials
        And User enter "<email>" and "<password>"
        Then Log in
        Then validate error message "<errorMessage>"

        Examples:
          | email             | password      | errorMessage                |
          | wrong@email.com   | Ruya@2014     | wrong username or password  |
          | mansoor@gmail.com | wrongPassword | wrong username or password  |
          | wrong@gmail.com   | wrongPasword  | wrong username or password  |
