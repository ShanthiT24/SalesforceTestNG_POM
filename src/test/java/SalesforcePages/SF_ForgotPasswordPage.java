package SalesforcePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import SalesforceBasePage.SFBasePage;

public class SF_ForgotPasswordPage extends SFBasePage{
 
	@FindBy(id="un") WebElement userEmailTB_FYP;
	@FindBy(id="continue") WebElement continueButton_FYP;



public SF_ForgotPasswordPage(WebDriver driver) {
	super(driver);
	// TODO Auto-generated constructor stub
}

public void enterText_userEmailTB_FYP(String txt)
{
	userEmailTB_FYP.clear();
	enterTextWE(userEmailTB_FYP,txt);
}

public WebDriver click_continueButton_FYP()
{
	WebDriver driver = clickWE(continueButton_FYP);
	return driver;
}

}