@Regression @CreateAccount
Feature: Create New Account Page

  @CreateNewAccount
  Scenario: Create new Account
    Given Navigate to sign in page
    Given User click on Create Account
    When User fill Form "Mansoor" and "vsvp@gmail.com" and "Ruya@2014"
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Mansoor" and email in Account Page

    @CreateNewAccount_2
    Scenario: Create new Account with valid credential Using Map Data Table
      Given Navigate to sign in page
      Given User click on Create Account
      When User fill up Sign up Form
      | name     | Mansoor                |
      | email    | instructor@tekschool.us |
      | password | 123456Ab@               |
      When User Click on Sign up button
      Then User will navigate to Account Profile Page
      Then Validate "Mansoor" and email in Account Page

  @CreateNewAccount_3
  Scenario: Create new Account with valid credential Using Map Data Table
    Given Navigate to sign in page
    Given User click on Create Account
    When User fill up Sign up Form With List Data Table
      | Mansoor                |
      | instructor@tekschool.us |
      | 123456Ab@               |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "Mansoor" and email in Account Page

  @CreateNewAccount_4
  Scenario: Create new Account with valid credential Using List of Maps
    Given Navigate to sign in page
    Given User click on Create Account
    When User fill up Sign up Form With List Of Map Data Table
      | name | email             | password  |
      | John | john@tekschool.us | 123456Ab@ |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "John" and email in Account Page

  @CreateNewAccount_5
  Scenario: Create new Account with valid credential Using List of List
    Given Navigate to sign in page
    Given User click on Create Account
    When User fill up Sign up Form With List Of List Data Table
      | John | john@tekschool.us | 123456Ab@ |
    When User Click on Sign up button
    Then User will navigate to Account Profile Page
    Then Validate "John" and email in Account Page