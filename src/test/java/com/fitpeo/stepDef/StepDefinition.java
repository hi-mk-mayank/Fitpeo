package com.fitpeo.stepDef;

import java.io.IOException;

import com.fitpeo.Pages.PageWorking;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	PageWorking pw = new PageWorking();

	@Given("Load Fitpeo home page")
	public void load_fitpeo_home_page() throws IOException {
		pw.setUpTheBrowserAndLaunchTheHomePage();
	}

	@Given("Navigate to revenue calculation page")
	public void navigate_to_revenue_calculation_page() throws IOException {
		pw.navigateToRevenueCalculatorPage();
	}

	@When("Scroll down to slider section")
	public void scroll_down_to_slider_section() throws InterruptedException, IOException {
		pw.navigateToSlider();
	}

	@Then("Validate slider movement is reflecting in the text box")
	public void validate_slider_movement_is_reflecting_in_the_text_box() throws IOException {
		pw.adjustTheSlider();
	}

	@Then("Validate text box value is udpating the slider width")
	public void validate_text_box_value_is_udpating_the_slider_width() throws IOException {
		pw.enterValueInInputBox();
	}

	@Then("Move to CPT Selection and check CPT checkboxes")
	public void move_to_cpt_selection_and_check_cpt_checkboxes() throws IOException {
		pw.cptCode();
	}

	@Then("Validate the TotalRecurring Reimbursment value")
	public void validate_the_total_recurring_reimbursment_value() throws IOException {
		pw.totalRecussingReimbursementForAllPatientsPerMonth();
	}

	@After
	public void terminate() {
		pw.tearDown();
	}

}
