package testPages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.SignInPage;
import pageFactory.TestBase;
import utilities.ExcelReader;
import utilities.RetryLogic;

public class SignInPage_Test extends TestBase{

	SignInPage sip;
	
	@BeforeMethod
	public void setup()
	{	
		sip = new SignInPage(driver);
	}
	
	@Test(dataProvider = "testdata",retryAnalyzer = RetryLogic.class)
	public void testmultipleLogin(String u, String p)
	{
		sip.signIn(u, p);
		try {
		sip.logout();
		}
		catch(Exception e)
		{
			//assertTrue(false);
			Assert.fail("Logout is not possible ,Not a browser issue try with valid credentials - Hence Unsuccessful SignIn");
		}
	}
	
	@DataProvider(name="testdata")
	public Object[][] datasupplier() throws EncryptedDocumentException, IOException
	{
		
		Object input[][] = ExcelReader.getTestData("J:\\MPHASIS\\RLL\\SignInDbankDemo.xlsx");
		return input;
		
	}
	
}
