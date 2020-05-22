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



