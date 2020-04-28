Feature: create a new user
  Scenario: happy user
    Given user is on "https://forumet.vimla.se/register"
    And has entered username "TestLong18UserName"
    And has entered email "email"
    And has entered password "password"
    And has entered confirmed password "confirmedPassword"
    When he clicks to registrate
    Then he gets "TC2:Användarnamnet är för långt"