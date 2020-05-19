Feature: Indigo Flight Search
Scenario: Search Flight
    Given launch site using "chrome"
    When click radio button "oneway"
    When enter from place "Goa"
    And enter to place "Mumbai"
    And enter from date "12-Jun-2020"
    And enter to date " "
    And click search
    And close site