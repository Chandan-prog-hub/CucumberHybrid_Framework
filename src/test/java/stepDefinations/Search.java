package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;

public class Search {
	
	WebDriver driver;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		driver=DriverFactory.getDriver();
		
	   
	}

	@When("User enters a valid product {string} in to the search field")
	public void user_enters_a_valid_product_in_to_the_search_field(String validproductname) {
	 driver.findElement(By.name("search")).sendKeys(validproductname);
	}

	@And("User clicks on the search button")
	public void user_clicks_on_the_search_button() {
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	   
	}

	@Then("User should get valid product to be displayed on the search results")
	public void user_should_get_valid_product_to_be_displayed_on_the_search_results() {
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("User enters a invalid product {string} into the search field")
	public void user_enters_a_invalid_product_into_the_search_field(String invalidproduct) {
		driver.findElement(By.name("search")).sendKeys(invalidproduct);
		
	}
	
	

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).isDisplayed());
	  
	}

	@When("User enters nothing in to the search field")
	public void user_enters_nothing_in_to_the_search_field() {
		
		//intentionally kept blank
	  
	}


}
