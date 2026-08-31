Feature: Login

  Background:
    Given user opens the login page

  Scenario Outline: Login with different credentials
    When user logs in with username "<username>" and password "<password>"
    Then products page is displayed

    Examples:
      | username      | password      |
      | standard_user | secret_sauce  |
      | problem_user  | secret_sauce  |
