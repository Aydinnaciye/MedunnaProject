@user_registration
Feature: registration feature

  Scenario Outline: User should be able to  register

    #Firstly I create a feature file
    #I will write my test cases by using Gerkhin language as it helps everyone to understand test cases.
    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    And user enters firstname as "<firstName>" and lastname as "<lastName>"
    And user provides address "<address>"
    And user provides phoneNumber "<phoneNumber>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the firstPassword as "<firstPassword>" and secondPassword as "<secondPassword>"
    Then  user clicks on the register button and see the success message as "<successMessage>"

    Examples: user info
      |SSN|firstName|lastName|address|phoneNumber|username|email|firstPassword|secondPassword|successMessage|
      |883-05-1709|New User|last|Milky way|456-279-5588|utilisateur|kalin54@gmail.com|Utilisateur123.|Utilisateur123.|successfully registered|