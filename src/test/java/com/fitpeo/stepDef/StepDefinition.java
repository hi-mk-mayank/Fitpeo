package com.fitpeo.stepDef;

import com.fitpeo.Pages.PageWorking;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	PageWorking pw = new PageWorking();

	@Given("Loading the home page")
	public void loading_the_home_page() {
		pw.setUpTheBrowserAndLaunchTheHomePage();
	}

	@Given("Navigation to the reveneue page")
	public void navigation_to_the_reveneue_page() {
		pw.navigateToRevenueCalculatorPage();

	}

	@When("Scroll down to the slider bar")
	public void scroll_down_to_the_slider_bar() throws InterruptedException {
		pw.navigateToSlider();

	}

	@Then("Validate the slider movement to impact the test box")
	public void validate_the_slider_movement_to_impact_the_test_box() throws InterruptedException {
		pw.adjustTheSlider();

	}

	@Then("Validate the text box value update impact the slider")
	public void validate_the_text_box_value_update_impact_the_slider() throws InterruptedException {
		pw.enterValueInInputBox();

	}

	@Then("Move to the CPT Selection and check CPT checkboxes we want")
	public void move_to_the_cpt_selection_and_check_cpt_checkboxes_we_want() throws InterruptedException {
		pw.cptCode();
	}

	@Then("Validate the TotalRecurring Reimbursment and it value")
	public void validate_the_total_recurring_reimbursment_and_it_value() throws InterruptedException {

		pw.totalRecussingReimbursementForAllPatientsPerMonth();
	}

	@After
	public void terminate() {
		pw.tearDown();
	}

}
