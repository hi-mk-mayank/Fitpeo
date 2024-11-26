Feature: Test Revenue Calculation
  @test1
  Scenario: Revenue Calculation Navigation and Validaiton
    Given Load Fitpeo home page
    And Navigate to revenue calculation page
    When Scroll down to slider section
    Then Validate slider movement is reflecting in the text box
 		And Validate text box value is udpating the slider width
 		Then Move to CPT Selection and check CPT checkboxes
 		Then Validate the TotalRecurring Reimbursment value

