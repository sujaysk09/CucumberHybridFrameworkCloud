package stepdefinitions;


import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import util.CommonUtils;

public class Register {
	
//	@Before(order=0)
//	public void setupOne()
//	{
//		System.out.println("++setup one++");
//	}
//
//	@Before(order=1)
//	public void setupTwo()
//	{
//		System.out.println("++setup two++");
//	}
//	
//	@Before(order=2)
//	public void setupThree()
//	{
//		System.out.println("++setup three++");
//	}
//	
//	@After(order=2)
//	public void tearDownOne()
//	{
//		System.out.println("--tear down one--");
//	}
//	
//	@After(order=1)
//	public void tearDownTwo()
//	{
//		System.out.println("--tear down two--");
//	}
//	
//	@After(order=0)
//	public void tearDownThree()
//	{
//		System.out.println("--tear down three--");
//	}
	WebDriver driver;
	RegisterPage register;
	AccountSuccessPage accountPage;
	CommonUtils commonUtil;
	
	@Given("User navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		driver=DriverFactory.getDriver();
		HomePage home=new HomePage(driver);
		home.clickOnMyAccount();
		register=home.clickOnRegisterBtn();
	}

	@When("User enters below details into fields")
	public void User_enters_below_details_into_fields(DataTable dataTable) throws InterruptedException {
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		register.enterFirstName(map.get("firstname"));
		register.enterlastName(map.get("lastname"));
		commonUtil=new CommonUtils();
		register.enterEmailAddress(commonUtil.getEmailWithTimeStamp());
		register.enterTelephoneNumber(map.get("telephone"));
		register.enterPassword(map.get("password"));
		register.enterConfirmPassword(map.get("password"));		
	}
	
	@When("User enters below details into fields with duplicate email")
	public void User_enters_below_details_into_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		register.enterFirstName(map.get("firstname"));
		register.enterlastName(map.get("lastname"));
		register.enterEmailAddress(map.get("email"));
		register.enterTelephoneNumber(map.get("telephone"));
		register.enterPassword(map.get("password"));
		register.enterConfirmPassword(map.get("password"));		
	}

	@When("Selects Privacy Policy field")
	public void selects_privacy_policy_field() {
		register.selectPrivacyPolicy();
	}

	@When("Clicks on Continue button")
	public void clicks_on_continue_button() throws InterruptedException {
		accountPage=register.clickOnContinueBtn();
	}

	@Then("Account should be successfully created")
	public void account_should_be_successfully_created() {
	    Assert.assertEquals("Your Account Has Been Created!",accountPage.getPageHeading());
	}

	@When("Selects Yes for Newsletter")
	public void selects_yes_for_newsletter() {
		register.selectYesForNewsletter();
	
	}

	@When("User dont enter details into any fields")
	public void user_dont_enter_details_into_any_fields() {
		register.enterFirstName("");
		register.enterlastName("");
		register.enterEmailAddress("");
		register.enterTelephoneNumber("");
		register.enterPassword("");
		register.enterConfirmPassword("");	
	}

	@Then("Warning messages should be displyaed in the mandatory fields")
	public void warning_messages_should_be_displyaed_in_the_mandatory_fields() {
	    Assert.assertTrue(register.getWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", register.getFirstNameWarningMessage());
	}

	@When("Enters duplicate email address {string} into Email field")
	public void enters_duplicate_email_address_into_email_field(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}

	@Then("User should get proper warning messsage about duplicate email address")
	public void user_should_get_proper_warning_messsage_about_duplicate_email_address() {
		Assert.assertTrue(register.getWarningMessage().contains("Warning: E-Mail Address is already registered!"));
	}

}
