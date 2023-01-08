
@employee_login_scenario_outline
Feature: employee_login
  Scenario Outline: login_with_employee_credentials
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user sends username "<username>"
    And user sends password "<password>"
    And user clicks on the login button
    Then close the application

    Examples: credentials
      |username                  |password              |
      |gino.wintheiser           |%B6B*q1!TH            |
      |dallas.batz               |dOWjuXz8*es6          |
      |leonel.skiles             |x3uvY0f8hw1T          |
      |freddy.veum               |*f**3dafHW3Jx         |
      |syble.jerde               |2*0R*!K&GB3T%G        |
      |julius.keebler            |F&134#R%0d            |

#1. create teh feature file
#2. Run runner and generate missing step definitions: @employee_login_scenario_outline
#3. Put the step definitions in the LoginStepDefs class
#4. Start writing Java code in the step definition
#5. Create page objects