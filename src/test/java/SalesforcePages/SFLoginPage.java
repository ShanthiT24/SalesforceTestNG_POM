package SalesforcePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SalesforceBasePage.SFBasePage;

public class SFLoginPage extends SFBasePage{

	@FindBy(id="username")
	public
	WebElement userNameTB;
	@FindBy(id="password")
	public
	WebElement passwordTB;
	@FindBy(id="Login")
	public
	WebElement loginButton;
	@FindBy(xpath="//div[text()='Please enter your password.']")
	WebElement pwErrText;
	@FindBy(id="rememberUn") WebElement rememberMeCB;
	@FindBy(id="idcard-identity") WebElement uNameTB2_RMCked;
	@FindBy(id="forgot_password_link") WebElement forgotPwdLink;
	@FindBy(id="un") WebElement userEmailTB_FYP;
	@FindBy(id="continue") WebElement continueButton_FYP;
	@FindBy(xpath="//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	@FindBy(id="error") WebElement errorText_WrongUnPw;
	
	
		
	public SFLoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	public void enterText_userNameTB(String txt)
	{
		userNameTB.clear();
		enterTextWE(userNameTB,txt);
	}
	
	public void clear_userNameTB()
	{
		userNameTB.clear();
		
	}
	
	
	public void enterText_userEmailTB_FYP(String txt)
	{
		userNameTB.clear();
		enterTextWE(userEmailTB_FYP,txt);
	}
	
	
	public void enterText_passwordTB(String txt)
	{
		passwordTB.clear();
		enterTextWE(passwordTB,txt);
	}
	
	public String getPsWdErrText()
	{
		String errText=getTextWE(errorText_WrongUnPw);
		return errText;
	}
	
	public WebDriver clickloginButton()
	{
		WebDriver driver = clickWE(loginButton);
		return driver;
	}
	
	public WebDriver clickRememberMeCB()
	{
		WebDriver driver = clickWE(rememberMeCB);
		return driver;
	}
	
	public String getTextuNameTB2_RMCked()
	{
		String inText=getTextWE(uNameTB2_RMCked);
		return inText;
	}
	
	public WebDriver clickforgotPwdLink()
	{
		WebDriver driver = clickWE(forgotPwdLink);
		return driver;
	}
	
	public WebDriver click_continueButton_FYP()
	{
		WebDriver driver = clickWE(continueButton_FYP);
		return driver;
	}
	
	
	
}
