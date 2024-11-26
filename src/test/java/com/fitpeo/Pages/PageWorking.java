package com.fitpeo.Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PageWorking {
	WebDriver driver;
	int i = 0;

	public void screenshotTaker() throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotName = "screenshot" + (i += 1) + ".png";
		File destination = new File("Screenshot/" + screenshotName);
		FileUtils.copyFile(screenshot, destination);
	}

	public void setUpTheBrowserAndLaunchTheHomePage() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fitpeo.com/");
		screenshotTaker();
	}

	public void navigateToRevenueCalculatorPage() throws IOException {
		driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]")).click();
		screenshotTaker();
	}

	public void navigateToSlider() throws InterruptedException, IOException {
		Thread.sleep(4000);
		Actions navigateToSliderAction = new Actions(driver);
		navigateToSliderAction.moveToElement(driver.findElement(By.xpath("(//*[contains(@class,'css-1msk7rm')])[3]")))
				.perform();
		screenshotTaker();
	}

	public void adjustTheSlider() throws IOException {

		WebElement slider = driver.findElement(By.xpath("//*[contains(@class,'css-1sfugkh')]/input"));
		Actions scrollActionofSlider = new Actions(driver);
		scrollActionofSlider.clickAndHold(slider).moveByOffset(93, 0)
				.sendKeys(Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT).perform();
		String inputBoxValue = driver.findElement(By.xpath("//input[contains(@class,'css-1o6z5ng')]"))
				.getAttribute("value");
		Assert.assertEquals(slider.getAttribute("aria-valuenow"), inputBoxValue, "Test case Pass");
		screenshotTaker();
	}

	public void enterValueInInputBox() throws IOException {
		WebElement inputBox = driver.findElement(By.xpath("//input[contains(@class,'css-1o6z5ng')]"));
		inputBox.click();
		inputBox.sendKeys(Keys.CONTROL, "A");
		inputBox.sendKeys("560", Keys.ENTER);
		WebElement slider = driver.findElement(By.xpath("//*[contains(@class,'css-1sfugkh')]/input"));
		String valueName = slider.getAttribute("value");
		Assert.assertEquals(valueName, "560", " Test case Failed");
		screenshotTaker();
		inputBox.click();
		inputBox.sendKeys(Keys.CONTROL, "A");
		inputBox.sendKeys("820", Keys.ENTER);

	}

	public void cptCode() throws IOException {
		driver.findElement(By.xpath("(//*[contains(@class,'css-1m9pwf3')])[1]")).click();
		driver.findElement(By.xpath("(//*[contains(@class,'css-1m9pwf3')])[2]")).click();
		screenshotTaker();
		driver.findElement(By.xpath("(//*[contains(@class,'css-1m9pwf3')])[3]")).click();
		driver.findElement(By.xpath("(//*[contains(@class,'css-1m9pwf3')])[8]")).click();
		screenshotTaker();

	}

	public void totalRecussingReimbursementForAllPatientsPerMonth() throws IOException {
		String result = driver.findElement(By.xpath("(//*[contains(@class,'css-1xroguk')])[4]")).getText();
		String[] result1 = result.split("\n");
		Assert.assertEquals(result1[0], "Total Recurring Reimbursement for all Patients Per Month:",
				"Test Case Failed");
		Assert.assertEquals(result1[1], "$110700", "Test case failed");
		screenshotTaker();
	}

	public void tearDown() {
		driver.quit();
	}

}
