Feature: Login User

  Scenario Outline: User can fill in New addresses form on mystore-testlab.coderslab.pl


    Given an open browser mystore-testlab.coderslab.pl
    When user loggs in with email "<email>" and password "<password>"
    Then fill in formula address with "<alias>" "<address>" "<zip>" "<city>" "<country>" "<phone>"
    And verify data in YourAddress "<alias>" "<address>" "<zip>" "<city>" "<country>" "<phone>"

    Examples:
      | email              | password  | alias  | address| zip     | city      | country        | phone      |
      | hkowalska123@wp.pl | Paulina94 | Flower | Garden | SW175BU | Liverpool | United Kingdom | 7788993322 |




