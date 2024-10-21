package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	
	WebDriver driver;
	
	
	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		
		driver=DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
	}
	
	@When("User enters valid email {string} into the email field")
	public void User_enters_valid_email_into_the_email_field(String email) {
		
		driver.findElement(By.id("input-email")).sendKeys(email);
		
	}
	
	@And("User enters the valid password {string} into the password field")
	public void user_enters_the_valid_password_into_the_password_field(String password) {
	   
		driver.findElement(By.id("input-password")).sendKeys(password);
	}

	@And("User clicks on the login button")
	public void user_clicks_on_the_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	}

	@Then("User should get successfully loggedin")
	public void user_should_get_successfully_loggedin() {
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	   
	}

	
	@When("User enters  invalid email {string} into the email field")
	public void user_enters_invalid_email_ito_the_email_field(String invalidemail) {
		driver.findElement(By.id("input-email")).sendKeys(invalidemail);
	    
	}

	@And("User enters the invalid password {string} into the password field")
	public void user_enters_the_invalid_password_into_the_password_field(String invalidpassword) {
	   driver.findElement(By.id("input-password")).sendKeys(invalidpassword);
	}



	@Then("user should get a proper waring msg about credentials mismatch")
	public void user_should_get_a_proper_waring_msg_about_credentials_mismatch() {
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	  
	}

	
	@When("User doesnot enter email adress in to the email adress field")
	public void user_doesnot_enter_email_adress_in_to_the_email_adress_field() {
		
		driver.findElement(By.id("input-email")).sendKeys("");
	   
	}

	@When("User doesnot enter password  in to the password field")
	public void user_doesnot_enter_password_in_to_the_password_field() {
		
		driver.findElement(By.id("input-password")).sendKeys("");
	  
	}

}
