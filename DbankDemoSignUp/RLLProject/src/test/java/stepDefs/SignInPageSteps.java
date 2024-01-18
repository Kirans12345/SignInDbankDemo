package stepDefs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.SignInPage;

public class SignInPageSteps {

    BaseClass b;
    SignInPage s;
    SoftAssert soft = new SoftAssert();
    
    @Given("I open my dbankdemo website on chrome browser")
    public void open_Browser(){
    	
    	BaseClass.setUp();
    	s=new SignInPage(BaseClass.getDriver());
    }

    @When("I entered the login credentials from Excel {string} and i clicked on signin")
    public void iHaveValidLoginCredentialsFromExcel(String excelFilePath) throws IOException {

        ExcelReader excelReader = new ExcelReader();
        Object[][] testData = excelReader.getTestData(excelFilePath);

        for (Object[] row : testData) {
            String username = String.valueOf(row[0]); // Assuming username is in the first column
            String password = String.valueOf(row[1]); // Assuming password is in the second column

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

            //s = new SignInPage(BaseClass.getDriver());
            
            s.signIn(username, password);
            
            try {
                s.logout();
            } catch (Exception ex) {
                ex.getMessage();
            }
        }
    }

    @Then("I close my browser")
    public void iEnterTheLoginCredentials() {
        // Your logic for clicking on signIn and verifying successful login
    	//String actual=driver.getTitle();
    	//System.out.println(actual);
    	String actual=BaseClass.getDriver().getTitle();
    	//System.out.println(actual);
    	String expected="Digital Bank";
    	Assert.assertEquals(actual, expected);
    	BaseClass.tearDown();
    }
}
