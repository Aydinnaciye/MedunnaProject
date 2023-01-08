Feature: database features
@db_customer_ssn
  Scenario:TCO1_read_customer_ınformatıon_ssn
    Given user connects to the database
    And user gets the "*" from "tp_customer" table
    #Select  *from tp_customer;Select all column from tp_customer
  And user reads all the "ssn" column data
  Then  close the database connectıon

  @db_customer_address
  Scenario:TCO2_read_customer_information_address
    Given user connects to the database
    And user gets the "*" from "tp_customer" table
    #Select  *from tp_customer;Select all column from table
    And user reads all the "address" column data
    Then  close the database connection

  @db_customer_email
  Scenario:TCO3_read_customer_information_email
    Given user connects to the database
    And user gets the "*" from "tp_customer" table
    And user reads all the "email" column data
    Then  close the database connection

    Scenario Outline: database_connectivity
      Given user connects to the database
      And user gets the "*" from "tp_customer" table
      And user reads all the "column" column data
      Then  close the database connection

      Examples: Column Data
     |  column|
     |  ssn   |
     |  address|
     |  emaıl  |

  #jhi_user  --table name
  @db_user_email
  Scenario:TCO4_read_user_information_email
    Given user connects to the database
    And user gets the "*" from "jhi_user" table
    And user reads all the "email" column data
    Then  close the database connection

  @db_user_login
  Scenario:TCO6_verify_user_information_login
    Given user connects to the database
    And user gets the "*" from "jhi_user" table
    And user reads all the "login" column data
    Then  verify jhi_user table login column contains "sherlockholmes"
    Then  close the database connection


  @db_user_login
  Scenario:TCO7_verify_user_information_login_multiple_data
    Given user connects to the database
    And user gets the "*" from "jhi_user" table
    And user reads all the "login" column data
    Then  verify jhi_user table login column contains "data"
    Then  close the database connection
    Examples:Multiple login data
    |  data         |
    |   sherlockholmes  |
    |   ozzy        |

  @db_user_email
  Scenario:TCO8_read_user_information_email
    Given user connects to the database
    And user gets the "*" from "jhi_user" table
    Then verify "jhi_user" table "email" column contains  "foreachlop2020@gmail.com"
    Then  close the database connection

    @db_account_type
    Scenario:TCO9_verify_account_information_type
      Given user connects to the database
      And user gets the "*" from "tp_account" table
      Then verify the row count
      Then verify "tp_account" table "account_type" column contains  "CHECKING"
      Then verify "tp_account" table "account_type" column contains  "CREDIT_CARD"
      Then verify "tp_account" table "account_type" column contains  "INVESTING"
      Then  close the database connection

  @db_account_registration
  Scenario:TCO8_read_user_information_email
    Given user connects to the database
    And user gets the "*" from "tp_account_registration" table
    And verify the row  count
    Then verify the column names of "tp_account_registration" table
    Then  close the database connection
