package SalesforceTestModules;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;

import SalesforceBaseTest.SFBaseTest;
import SalesforcePages.SFHomePage;
import SalesforcePages.SFLoginPage;
import SalesforcePages.SF_CheckYourEmailPage;
import SalesforcePages.SF_ForgotPasswordPage;
import SalesforceUtilities.PropertiesUtility;
import SalesforceUtilities.SFConstants;

public class SFLoginTCs extends SFBaseTest{

protected Logger SFLoginLog = LogManager.getLogger();

	

	@Test
	public void sfLoginTC1() throws InterruptedException{
		SFLoginPage sflp = new SFLoginPage(driver);
		SoftAssert sftAsrt = new SoftAssert();
		String loginPgTitle = sflp.getTitle();
		sftAsrt.assertEquals( loginPgTitle,"Login | Salesforce", "ERROR: Salesforce login page NOT displayed");
		sflp.enterText_userNameTB("User@gmail.com");
		Thread.sleep(5000);
		String uName=sflp.userNameTB.getAttribute("value");
		SFLoginLog.info("INFO: user name value:"+uName);
		extentReport.logTestInfo(("INFO: user name value:"+uName));
		sftAsrt.assertEquals( uName,"User@gmail.com", "Error User name not displayed");
		sflp.enterText_passwordTB("");
		Thread.sleep(5000);
		String pwText=sflp.passwordTB.getAttribute("value");
		sftAsrt.assertEquals(pwText,"", "ERROR: password input box is NOT empty");
		WebDriver driver=sflp.clickloginButton();
		String pwTextErr = sflp.getPsWdErrText();
		sftAsrt.assertEquals( pwTextErr,"Please enter your password.","FAIL: password Error Msg not displayed or different ");
		extentReport.logTestInfo("password error msg displayed is "+pwTextErr);
		sftAsrt.assertAll();
		
	}
	
	@Test
	public void sfLoginTC2() throws InterruptedException
	{
		SFLoginPage sflp = new SFLoginPage(driver);
		sflp.sfLogin();
		
	}
	
	@Test
	public void sfLoginTC3() throws InterruptedException
	{
		String username=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"username");
		String password1=PropertiesUtility.readDataFromPropertyFile(SFConstants.APPLICATION_PROPERTIES,"password");
		SFLoginPage sflp = new SFLoginPage(driver);
		SoftAssert sftAsrt1= new SoftAssert();
		sflp.enterText_userNameTB(username);
		Thread.sleep(5000);
		sflp.enterText_passwordTB(password1);
		sflp.clickRememberMeCB();
		Thread.sleep(5000);
		WebDriver driver=sflp.clickloginButton();
		Thread.sleep(5000);
		
		SFHomePage sfhp = new SFHomePage(driver);
		String hPage= driver.getTitle();
		sftAsrt1.assertEquals(hPage.contains("Home Page"),true,"ERROR: salesforce Home page NOT displayed");
		Thread.sleep(5000);
		sfhp.sfLogoutClassic();
		Thread.sleep(5000);
		
		SFLoginPage sflp1 = new SFLoginPage(driver);
		String loginPgTitle = driver.getTitle();
		sftAsrt1.assertEquals(loginPgTitle,"Login | Salesforce","ERROR: Salesforce login page NOT displayed");
		SFLoginLog.info("INFO: Salesforce login page displayed after logout");
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		String userNameTB2=sflp.getTextuNameTB2_RMCked();
		SFLoginLog.info("INFO: user name value seen in username TB :"+userNameTB2);
		SFLoginLog.info("INFO: expected user name value is 'renu@xyzcorp.com'");
		sftAsrt1.assertEquals(userNameTB2, "renu@xyzcorp.com","FAIL: User name entered not displayed on selecting remember me CB");
		sftAsrt1.assertAll();		
	}
	
	
	@Test
	public void sfLoginTC4A() throws InterruptedException
	{
		//WebDriver driver;
		SFLoginPage sflp = new SFLoginPage(driver);
		SoftAssert sftAsrt1= new SoftAssert();
		Thread.sleep(5000);
		//WebElement forgotPwdLink = driver.findElement(By.id("forgot_password_link"));
		driver=sflp.clickforgotPwdLink();
		Thread.sleep(5000);
		SF_ForgotPasswordPage sffpw = new SF_ForgotPasswordPage(driver);
		String forgotPwdPage = driver.getTitle();
		SFLoginLog.info("INFO: Forgot your passwd page title : "+forgotPwdPage);
		sftAsrt1.assertEquals(forgotPwdPage.contains("Forgot Your Password"), true, "ERROR: Forgot your passwd page NOT displayed");
		Thread.sleep(5000);
		sffpw.enterText_userEmailTB_FYP("renu@xyzcorp.com");
		//sffpw.enterText_userEmailTB_FYP("renu@xyzcorp.com");
		driver = sffpw.click_continueButton_FYP();
		Thread.sleep(5000);
		SF_CheckYourEmailPage sfchkemail = new SF_CheckYourEmailPage(driver);
		String chkYourEmailPge = driver.getTitle();
		sftAsrt1.assertEquals(chkYourEmailPge.contains("Check Your Email"),true, "ERROR: check your email page is NOT displayed");
		SFLoginLog.info("INFO: check your email page is displayed");
		sftAsrt1.assertEquals(sflp.returnToLoginButton.isDisplayed(),true,"PASS: check your email page with 'return to login' button displayed");
		sftAsrt1.assertAll();			
	}
	
	@Test
	public void sfLoginTC4B() throws InterruptedException
	{
		SFLoginPage sflp = new SFLoginPage(driver);
		SoftAssert sftAsrt1= new SoftAssert();
		launchBrowser("Chrome");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		Thread.sleep(5000);
		sflp.enterText_userNameTB("Username 123");
		Thread.sleep(5000);
		sflp.enterText_passwordTB("22131");
		//sflp.clickRememberMeCB();
		Thread.sleep(5000);
		WebDriver driver=sflp.clickloginButton();
		Thread.sleep(5000);
		String errText = sflp.getPsWdErrText();
		String expErrText ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		sftAsrt1.assertEquals(errText,expErrText,"FAIL: error msg is NOT displayed if wrong username/password is entered to login");
		sftAsrt1.assertAll();
	}
	
	
	/*public static void main(String[] args) throws InterruptedException 
	{
		SFLoginTCs sfLogin = new SFLoginTCs();
		//sfLogin.sfLoginTC1();
		//sfLogin.sfLoginTC2("Chrome","renu@xyzcorp.com","salesforce24");
		//sfLogin.sfLoginTC3();
		//sfLogin.sfLoginTC4A();
		sfLogin.sfLoginTC4B();
		
	}*/

}
