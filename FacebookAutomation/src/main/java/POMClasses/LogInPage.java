package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	WebDriver driver;
	@FindBy (xpath="//input[@id='email']")
	private WebElement userName;
	
	@FindBy (xpath= "//input[@id='pass']")
	private WebElement passWord;
	
	@FindBy(xpath ="//button[text()='Log in']")
	private WebElement loginButton;
	
	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendUsername(String username) {
		userName.sendKeys(username);
	}
//	public void sendUsername() {
//		userName.sendKeys("Atul");
//	}
	public void sendPassword(String password) {
		passWord.sendKeys(password);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}

}
