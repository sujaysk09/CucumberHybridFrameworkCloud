package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginDropMenu;
	
	@FindBy(linkText="Register")
	private WebElement registerDropMenu;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void clickOnMyAccount() {
		myAccountDropMenu.click();
	}
	
	public LoginPage clickOnLoginBtn() {
		loginDropMenu.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegisterBtn() {
		registerDropMenu.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBox(String productText) {
		searchBoxField.sendKeys(productText);
	}
	
	public SearchResultsPage clickOnSearchButton() {
		searchButton.click();
		return new SearchResultsPage(driver);
	}


}
