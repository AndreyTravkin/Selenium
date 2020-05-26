@sample_page
Feature: Training

  @sample1
  Scenario: Validate responsive UI behavior
    Given I go to the "sample" page
    When I change resolution to "Desktop" layout
    Then I verify that location date and time present
    When I change resolution to "Tablet" layout
    Then I verify that location date and time present
    When I change resolution to "Phone" layout
    Then I verify that location date and time not present


  @sample2
  Scenario: Validate error messages
    Given I go to the "sample" page
    When I click submit button
    Then I verify "username" error text is "This field is required."
    Then I verify "email" error text is "This field is required."
    Then I verify "password" error text is "This field is required."
    Then I verify "name" error text is "This field is required."
    Then I verify "Privacy Policy" error text is "Must check!"
    When I check privacyPolicy checkbox


  @sample3
  Scenario: Fill out and validate “Username” field
    Given I go to the "sample" page
    When I send text "a" into username field
    When I click submit button
    Then I verify username error text is "Please enter at least 2 characters."
    When I send text "Andrei" into username field
    Then I verify that error message is not present


  @sample4
  Scenario: Validate Email field behavior
    Given I go to the "sample" page
    When I send text "andrey@@gmail.com" into "email" field
    When I click submit button
    Then I verify "email" error text is "Please enter a valid email address."


  @sample5
  Scenario: Fill out and validate “Password” set of fields
    Given I go to the "sample" page
    Then I verify that confirmPassword field is disabled


  @smaple6
  Scenario: Validate “Name” field behavior
    Given I go to the "sample" page
    When I click on name field
    Then I verify that nameDialog is displayed
    When I send "Andrei" to the name field
    And I send "The Batya" to middle name field
    And I send "Travkin" to the last name field
    When I hit save button
    Then I verify that name "Andrei The Batya Travkin"


  @sample7
  Scenario: Fill out and verify whole form
    Given I go to the "sample" page
    When I send text "Andreika" into username field
    When I send text "andrey@gmail.com" into "email" field
    When I click on name field
    When I send "Andrei" to the name field
    And I send "The Batya" to middle name field
    And I send "Travkin" to the last name field
    When I hit save button
    When I check privacyPolicy checkbox
    When I fill out password field with "12345"
    When I fill out confirm password field "12345"
    When I fill out phone number field with "3467243437"
    When I select gender as "Male"
    When I select country Of Origin is "Russia"
    When I fill out the address with "140 S Santa Cruz Ave, Los Gatos, CA 95030"
    When I accept party agreement
    When I hit checkbox to allow to contact with me
    When I select my car makers "Toyota" and "Other"
    When I read related documents
    Then I verify that related documents contains "Document 1"
    When I select my date of birth as month "Aug" day "31" year "1992"
    When I fill out Additional Information with "Andrei" and "5105892769"
    When I upload a file
    When I submit the page

    Then I verify first name is "Andrei"




