package petSevaPomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PetsevaLogin {

	WebDriver driver;
	public PetsevaLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Login / Signup']")
	private WebElement loginOption;
	
	public WebElement getLoginOption() {
		return loginOption;
	}

	public void setLoginOption(WebElement loginOption) {
		this.loginOption = loginOption;
	}
	
	@FindBy(id = "idMobile")
	private WebElement mobileNoTextfield;
	
	public WebElement getMobileNoTextfield() {
		return mobileNoTextfield;
	}

	public void setMobileNoTextfield(WebElement mobileNoTextfield) {
		this.mobileNoTextfield = mobileNoTextfield;
	}

	public WebElement getLoginWithPasswordButton() {
		return loginWithPasswordButton;
	}

	public void setLoginWithPasswordButton(WebElement loginWithPasswordButton) {
		this.loginWithPasswordButton = loginWithPasswordButton;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public void setPasswordTextfield(WebElement passwordTextfield) {
		this.passwordTextfield = passwordTextfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	@FindBy(xpath = "//button[text()='Login with Password']")
	private WebElement loginWithPasswordButton;
	
	@FindBy(id = "password")
	private WebElement passwordTextfield;
	
	@FindBy(css = "button[type='submit']")
	private WebElement loginButton;
	
}
