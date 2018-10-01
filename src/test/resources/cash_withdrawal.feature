Feature: Cash withdrawal
  Scenario: Successful withdrawal from an account in credit
    Given my account has been credited with $100.00
    When I withdraw $20.00
    Then $20.00 should be dispensed
    And the balance of my account should be $80.00

  Scenario: Unscuccessful withdrawal from an account below credit
    Given my account has been credited with $100.00
    When I withdraw $150.00
    Then I am notified about unsufficient balance
    And no money is dispensed

#@admin
#Feature: Testing hooks
#
#  Scenario: Simple hooks
#    Given I do nothing
#    When I print something
#    Then something is printed
#
#  Scenario: Same thing again without tag
#    Given I do nothing
#    When I print something
#    Then something is printed
