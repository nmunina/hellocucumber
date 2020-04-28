Feature: create a new user
  Scenario Outline: happy user
    Given user is on "https://forumet.vimla.se/register"
    And has test case <"testCase">
    And has entered username <"username">
    And has entered email <"email">
    And has entered password <"password">
    And has entered confirmed password <"confirmedPassword">
    When he clicks to registrate
    Then he gets <"result">

    Examples:
    |"testCase"|"username"               |"email"                |"password"|"confirmedPassword"|"result"|
    |"TC1"     |"TestUserName"           |"mawer30474@jasia.com" |"aaabbbcc"|"aaabbbcc"         |"https://forumet.vimla.se/"|
    |"TC2"     |"TestLong18UserName"     |"mawer30474@jasia.com" |"aaabbbcc"|"aaabbbcc"         |"Användarnamnet är för långt"|
    |"TC3"     |"TestUserName"           |"mawer30374@jasia.com" |"aaabbbcc"|"ddaaabbb"         |"Lösenorden är inte likadana. Var god skriv dem på nytt."|
    |"TC4"     |"TestDoubleUser"         |"mawer30474@jasia.com" |"aaabbbcc"|"aaabbbcc"         |"Denna mailadress finns redan registrerad på ett forumkonto"|