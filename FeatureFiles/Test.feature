Feature: Test Revenue Calculation
  @test1
  Scenario: Revenue Calculation Navigation and Validaiton
    Given Loading the home page
    And Navigation to the reveneue page
    When Scroll down to the slider bar
    Then Validate the slider movement to impact the test box
 		And Validate the text box value update impact the slider
 		Then Move to the CPT Selection and check CPT checkboxes we want
 		Then Validate the TotalRecurring Reimbursment and it value

