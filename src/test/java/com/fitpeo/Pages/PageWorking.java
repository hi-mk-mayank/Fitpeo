package com.fitpeo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class PageWorking {
	WebDriver driver;

		public void setUpTheBrowserAndLaunchTheHomePage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fitpeo.com/");

	}
	
	public void navigateToRevenueCalculatorPage() {
		driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
	}
	
	public void navigateToSlider() throws InterruptedException {
		Thread.sleep(4000);
		Actions navigateToSliderAction = new Actions(driver);
		navigateToSliderAction.moveToElement(driver.findElement(By.xpath("(//*[contains(@class,'css-1msk7rm')])[3]"))).perform();
	}
	
	public void adjustTheSlider() throws InterruptedException {
		WebElement slider = driver.findElement(By.xpath("//*[contains(@class,'css-1sfugkh')]/input"));
		Actions scrollActionofSlider = new Actions(driver);
		scrollActionofSlider.clickAndHold(slider).moveByOffset(93, 0).sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();
		String inputBoxValue = driver.findElement(By.xpath("//input[contains(@class,'css-1o6z5ng')]")).getAttribute("value");
		
		Assert.assertEquals(slider.getAttribute("aria-valuenow"), inputBoxValue,"Test case Pass");

	}
	
	public void enterValueInInputBox() throws InterruptedException {
		WebElement inputBox = driver.findElement(By.xpath("//input[contains(@class,'css-1o6z5ng')]"));
		inputBox.click();
		inputBox.sendKeys(Keys.CONTROL, "A");
		inputBox.sendKeys("560", Keys.ENTER);
		WebElement slider = driver.findElement(By.xpath("//*[contains(@class,'css-1sfugkh')]/input"));
		String valueName = slider.getAttribute("value");
		Assert.assertEquals(valueName, "560","Test Case Pass");
		inputBox.click();
		inputBox.sendKeys(Keys.CONTROL, "A");
		inputBox.sendKeys("820", Keys.ENTER);
	}
	
	public void cptCode() throws InterruptedException {
		driver.findElement(By.xpath("(//*[contains(@class,'css-1m9pwf3')])[1]")).click();
		driver.findElement(By.xpath("(//*[contains(@class,'css-1m9pwf3')])[2]")).click();
		driver.findElement(By.xpath("(//*[contains(@class,'css-1m9pwf3')])[3]")).click();
		driver.findElement(By.xpath("(//*[contains(@class,'css-1m9pwf3')])[8]")).click();
	}
	
	public void totalRecussingReimbursementForAllPatientsPerMonth() throws InterruptedException {
		String result = driver.findElement(By.xpath("(//*[contains(@class,'css-1xroguk')])[4]")).getText();
		String[] result1 = result.split("\n");
		Assert.assertEquals(result1[0], "Total Recurring Reimbursement for all Patients Per Month:", "Test Case Pass");
		Assert.assertEquals(result1[1], "$110700", "Test case Pass");
	}

	public void tearDown() {
		driver.quit();
	}

}
