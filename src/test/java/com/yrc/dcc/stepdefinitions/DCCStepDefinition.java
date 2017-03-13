package com.yrc.dcc.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.openqa.selenium.WebElement;

import com.seven20.picklejar.stepdefinitions.StepDefinition;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DCCStepDefinition extends StepDefinition {

	@Given("^the \"([^\"]*)\" web page is available$")
	public void the_web_page_is_available(String url) throws Throwable {
		if (!driver.getCurrentUrl().equals(url)) {
			signout();
			driver.get(url);
			assertEquals("YRC DCC", driver.getTitle());
		}
	}

	public void signout() {
		try {
			WebElement link = driver.find("dcc.signout.link");
			if (link != null) {
				link.click();
			}
		} catch (Exception e) {
			return;
		}

	}

	@When("^I log in using \"([^\"]*)\"$")
	public void i_log_in_using(String login) throws Throwable {
		driver.sendKeys("dcc.login.textbox.xpath", login );
		driver.click("dcc.login.button.selector");
		assertEquals("Dock Command Center", driver.find("Dock Command Center").getText());
	}
	
	@Then("^I should see \"([^\"]*)\"$")
	public void i_should_see(String arg1) throws Throwable {
		assertTrue(!driver.find(arg1).getText().equals(""));
	}

		@Then("^the following table elements from \"([^\"]*)\":$")
	public void the_following_table_elements_from(String lookup, DataTable expectedValues) throws Throwable {
		assertTrue(driver.validateAll(lookup, expectedValues));

	}

	@AfterClass
	public static void killDrivers() {
		killDrivers();
	}

}
