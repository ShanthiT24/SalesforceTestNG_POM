package SalesforcePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import SalesforceBasePage.SFBasePage;

public class SFHomePage extends SFBasePage{
	
	@FindBy(xpath="//div[@id='userNav']")
	WebElement userMenuLink_UM;
	@FindBy(xpath="//a[text()='My Profile']")
	WebElement myProfileLink_UM;
	@FindBy(xpath="//a[text()='My Settings']")
	WebElement mySettingsLink_UM;
	@FindBy(xpath="//a[text()='Developer Console']")
	WebElement devConLink_UM;
	@FindBy(xpath="//a[text()='Switch to Lightning Experience']")
	WebElement switchToLghtLink_UM;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutLink_UM;
	@FindBy(id="home_Tab")
	WebElement homeTab;
	
	
	
	public SFHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebDriver click_homeTab()
	{
		WebDriver driver = clickWE(homeTab);
		return driver;
	}
	
	
	public WebDriver click_userMenuLink_UM()
	{
		WebDriver driver = clickWE(userMenuLink_UM);
		return driver;
	}
	public WebDriver click_logout_UM()
	{
		WebDriver driver = clickWE(logoutLink_UM);
		return driver;
	}
	
}
