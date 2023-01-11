package cucumber.stepDefinition;

import automationExercise.testPractices.BaseTest;
import automationExercise.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class StepDefinitionImplement extends BaseTest {

    public WebDriver driver;
    public String url;

    public SoftAssert softAssert = new SoftAssert();
    @Given("I landed on page")
    public void I_landed_on_Ecommerce_Page(){
        //code
        driver = Driver.getDriver();
        driver.get(url);
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username,String password){
        pages.getHomePage().clickSignupLoginButton();
        pages.getLoginPage().setSignupNewUserName(username);

        pages.getLoginPage().setSignupEmailAddressBox("gfhfgfgj@gmail.com");
        pages.getLoginPage().clickSignupButton();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualEnterAccountInformationTitle = pages.getSignupPage().getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle, "ENTER ACCOUNT INFORMATION", "ERROR : Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible\n");

        // 9.Fill details: Title, Name, Email, Password, Date of birth
        pages.getSignupPage().selectTitleMen();
        pages.getSignupPage().setPassword(password);
        pages.getSignupPage().setDateOfBirt("12", "April", "1945");


    }

}
