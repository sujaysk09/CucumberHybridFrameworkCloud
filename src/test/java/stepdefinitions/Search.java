package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
	//Hooks and tagged hooks
	//Hooks - @Before and @After
	//tagged hooks - @Before()
	//it is before and after hook, imported from io.cucumber.java
	//it is applicable for every scenario in every feature file
	//we can define it in any step definition class, it will be applicable for all
	
//	@Before("@search")
//	public void setup()
//	{
//		System.out.println("browser is opened");
//	}
//	
//	@After("@search")
//	public void tearDown()
//	{
//		System.out.println("browser is closed");
//	}
	
	//before step and after step hook will run before and after every step in the feature file
//	@BeforeStep("@search")
//	public void beforeEveryStep()
//	{
//		System.out.println("Before every step");
//	}
//	
//	@AfterStep("@search")
//	public void afterEveryStep()
//	{
//		System.out.println("After every step");
//	}
	
	WebDriver driver;
	HomePage home;
	SearchResultsPage searchResultsPage;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		
		driver=DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into Search field")
	public void user_enters_valid_product_into_search_field(String validProduct) {
	    home=new HomePage(driver);
	    home.enterProductIntoSearchBox(validProduct);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		searchResultsPage=home.clickOnSearchButton();
	}

	@Then("Valid product should display in search results")
	public void valid_product_should_display_in_search_results() {
	    Assert.assertTrue(searchResultsPage.displayStatusOfValidProduct());
	    Assert.fail();
	}

	@When("User enters non-existing product {string} into Search field")
	public void user_enters_non_existing_product_into_search_field(String invalidProduct) {
		home=new HomePage(driver);
		home.enterProductIntoSearchBox(invalidProduct);
	}

	@Then("Proper message informing the user about no product matching should be displayed")
	public void proper_message_informing_the_user_about_no_product_matching_should_be_displayed() {
	   Assert.assertEquals("There is no product that matches the search criteria.",searchResultsPage.getMessageText() );
	}

	@When("User dont enter any product into Search field")
	public void user_dont_enter_any_product_into_search_field() {
	    home=new HomePage(driver);
	}

}
