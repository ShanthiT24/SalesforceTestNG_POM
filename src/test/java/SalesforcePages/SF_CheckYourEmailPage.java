package SalesforcePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SalesforceBasePage.SFBasePage;

public class SF_CheckYourEmailPage extends SFBasePage {

	@FindBy(xpath="//a[text()='Return to Login']")
	public WebElement returnToLoginButton;


		public SF_CheckYourEmailPage(WebDriver driver)
		{
			super(driver);
		}


}