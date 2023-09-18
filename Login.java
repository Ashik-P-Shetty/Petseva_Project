package petseva;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.qsp.trello.genericutility.BaseClass;

public class Login extends BaseClass {

//	@FindBy(xpath = "//a[text()='Login / Signup']")
//	private WebElement loginOption;
//	
//	@FindBy(id = "idMobile")
//	public WebElement mobileNoTextfield;
//	
//	@FindBy(linkText = "Login with Password")
//	public WebElement loginButton;
	
	@Test
	
	public void petsevaLogin() throws IOException, Throwable {
		
		//Navigate to login page
		WebElement loginOption=driver.findElement(By.xpath("//a[text()='Login / Signup']"));
		loginOption.click();
		
		//Login to petseva with password
		WebElement mobileNoTextfield= driver.findElement(By.id("idMobile"));
		mobileNoTextfield.sendKeys(fileUtils.readTheDataFromPropertyFile("mobile"));
		
		WebElement loginWithPasswordButton= driver.findElement(By.xpath("//button[text()='Login with Password']"));
		loginWithPasswordButton.click();
		
		WebElement passwordTextfield= driver.findElement(By.id("password"));
		passwordTextfield.sendKeys(fileUtils.readTheDataFromPropertyFile("password"));
		
		WebElement loginButton= driver.findElement(By.cssSelector("button[type='submit']"));
		loginButton.click();
		
		//Manage clinics
		WebElement manageClinics= driver.findElement(By.cssSelector("a[href='/clinic']"));
		manageClinics.click();
		
		WebElement editOption= driver.findElement(By.cssSelector("a[href='clinic/235/edit']"));
		editOption.click();
		
		//Edit Profile
		WebElement shortAboutclinicTF= driver.findElement(By.xpath("//textarea[@id='idShortDescription']"));
		shortAboutclinicTF.clear();
		shortAboutclinicTF.sendKeys(fileUtils.readTheDataFromPropertyFile("about"));
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,600)");
		WebElement submitButton= driver.findElement(By.xpath("//button[text()='Submit']"));
		//jse.executeScript("arguments[0].click();", submitButton);
		submitButton.submit();
		jse.executeScript("window.scrollBy(0,-600)");
		
		//Edit the profile photo
		WebElement editPhoto= driver.findElement(By.xpath("//a[text()='Edit Photo']"));
		editPhoto.click();
		//Upload the photo from device
		WebElement choosePhoto= driver.findElement(By.id("uploadClinicImage"));
		choosePhoto.sendKeys("/Users/ashik/Downloads/Pug.jpeg");
		WebElement cropUploadButton= driver.findElement(By.xpath("//button[text()='Crop & Upload Image']"));
		cropUploadButton.click();
		Thread.sleep(5000);
		
		//Manage doctors
		WebElement manageDoctors= driver.findElement(By.xpath("//a[@href='/clinic-doctor/235']"));
		manageDoctors.click();
		
		//Add doctors
		WebElement addDoctor= driver.findElement(By.cssSelector("a[href='/clinic-doctor/235/create']"));
		addDoctor.click();
		//Search doctors
		WebElement doctorNameTF= driver.findElement(By.id("idDoctorName"));
		doctorNameTF.sendKeys(fileUtils.readTheDataFromPropertyFile("doctor_name"));
		Thread.sleep(5000);
		//Select from drop down
		WebElement doctorDropdown= driver.findElement(By.xpath("//li[@class='ui-autocomplete-row ui-menu-item']"));
		//select wont work here because this drop down is made of li tag
		doctorDropdown.click();
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//navigate back to window if doctor is already added
		String actmessage=driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText(); 
		String expmessage="Clinic with this doctor id already exists.";
		if (actmessage.equals(expmessage)) {
			driver.navigate().back();
			driver.navigate().back();
		}
		//Click on clinic languages
		driver.findElement(By.xpath("//a[text()='Clinic Languages']")).click();
		driver.findElement(By.xpath("//input[@id='idLanguage3']")).click();
		jse.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Click on clinic services
		driver.findElement(By.xpath("//a[text()='Clinic Services']")).click();
		driver.findElement(By.id("idMedicalService9")).click();
		jse.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//select city 
		driver.findElement(By.xpath("//a[@href='/select-city']")).click();
		driver.findElement(By.xpath("//a[text()='Bantwal']")).click();
		
		//Doctors in selected location
		String actUrl= driver.getCurrentUrl();
		String expUrl= "https://www.dev.petseva.com/bantwal/veterinary-doctors";
		if (actUrl.equals(expUrl)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		} 
	}
	
}
