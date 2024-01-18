package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[@id='submit']")
	WebElement signInButton;
	
	@FindBy(xpath = "//img[@alt='User Avatar']")
	WebElement myProfile;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div[2]/div[1]/div/a[5]")
	WebElement logout;
	
	public void signIn(String username,String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		signInButton.click();
	}
	
	
	public void logout() {
	myProfile.click();
	logout.click();
	}
	
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	

}
