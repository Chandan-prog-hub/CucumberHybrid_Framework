package stepDefinations;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Register {
	WebDriver driver;
	
	
	@Given("User navigates to the register page")
	public void user_navigates_to_the_register_page() {
		
		driver=DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	   
	}

	@When("User enters the below details into the respective fields")
	public void user_enters_the_below_details_into_the_respective_fields(DataTable dataTable) {
	  
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("Lastname"));
		driver.findElement(By.id("input-email")).sendKeys(datamap.get("Email"));
		driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("Telephone"));
		driver.findElement(By.id("input-password")).sendKeys(datamap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("password"));
	}

	@And("User checks the privace policy field")
	public void user_checks_the_privace_policy_field() {
		driver.findElement(By.name("agree")).click();
	  
	}

	@And("user clicks on the continue button")
	public void user_clicks_on_the_continue_button() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	  
	}

	@Then("user should land on the account success page")
	public void user_should_land_on_the_account_success_page() {
		Assert.assertEquals("Your Account Has Been Created!"
				, driver.findElement(By.xpath("//div[@id='content']/h1")).getText());
		
	  
	}

	@And("User opts yes for newsletter")
	public void user_opts_yes_for_newsletter() {
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	  
	}

	@Then("user should get a proper warning message about duplicate email")
	public void user_should_get_a_proper_warning_message_about_duplicate_email() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
				.getText().contains("Warning: E-Mail Address is already registered!"
				));
	  
	}

	@When("user does not enter any details to the fields")
	public void user_does_not_enter_any_details_to_the_fields() {
		
		//intentionally blank
	 
	}

	

	

	@Then("User should get proper warning message for every field")
	public void user_should_get_proper_warning_message_for_every_field() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"))
				.getText().contains("Warning: You must agree to the Privacy Policy!"
				));
		
		Assert.assertEquals("First Name must be between 1 and 32 characters!"
				, driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
	  
		
		Assert.assertEquals("Last Name must be between 1 and 32 characters!"
				, driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
		
		Assert.assertEquals("E-Mail Address does not appear to be valid!"
				
				, driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
		
        Assert.assertEquals("Telephone must be between 3 and 32 characters!"
        		
				, driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
        
        Assert.assertEquals("Password must be between 4 and 20 characters!"
        
        		, driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
        
	}


}
