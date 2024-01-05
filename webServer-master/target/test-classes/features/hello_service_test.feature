Feature: hello service

  Scenario Outline: hello service retuns correct answer
    When I call the hello service
    Then I get the answer <string>
    Examples:
      | string           |
      | "Hello RESTEasy" |