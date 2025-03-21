package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import util.CommonUtils;

public class Login {
	
	WebDriver driver;
	LoginPage login;
	AccountPage accountPage;
	CommonUtils commonUtils;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver=DriverFactory.getDriver();
		HomePage home=new HomePage(driver);
		home.clickOnMyAccount();
		login=home.clickOnLoginBtn();	
	}

	@When("^User enters valid email address (.+)$")
	public void user_enters_valid_email_address(String email) {
		login.enterEmail(email);
	}

	@And("^User enters valid password (.+)$")
	public void user_enters_valid_password(String password) {
		login.enterPassword(password);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		accountPage = login.clickOnLoginBtn();
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
	    Assert.assertTrue(accountPage.displayEditYourAccountInfo());
	}

	@When("User enters invalid email address")
	public void user_enters_invalid_email_address() {
		commonUtils=new CommonUtils();
		login.enterEmail(commonUtils.getEmailWithTimeStamp());
	}

	@And("User enters invalid password {string}")
	public void user_enters_invalid_password(String invalidPassword) {
		login.enterPassword(invalidPassword);
	}

	@Then("User should get proper warning messsage")
	public void user_should_get_proper_warning_messsage() {
		
	    Assert.assertTrue(login.getWarningMesssage().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User do not enter email address")
	public void user_do_not_enter_email_address() {
		login.enterEmail("");
		Assert.fail();
	}

	@And("User do not enter password")
	public void user_do_not_enter_password() {
		login.enterPassword("");
	}

}
