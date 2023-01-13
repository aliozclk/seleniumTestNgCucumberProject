package automationExercise.testPractices;

import automationExercise.utilities.BrowserUtils;
import automationExercise.utilities.ConfigurationReader;
import automationExercise.utilities.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.Set;

public class TestCase_3_IncorrectEmailAndPassword extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    String email = "wrong@email.com";

    String password = "password";


    //    1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'


    @BeforeSuite
    public void setUpSuite() {

        String url = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");

        Driver.getDriver().get(url);
        System.out.println("-----------TEST INFO --------------\n\tURL : " + url + "\n\tBrowser : " + browser);
        BrowserUtils.wait(1);

        //ByPass AdBlocker-Extension page
        Set<String> handles = Driver.getDriver().getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        Driver.getDriver().switchTo().window(parentWindow);

        Driver.getDriver().manage().deleteAllCookies();
    }

    @Test(priority = 0)
    public void  loginWıthIncorrectEmailAndPasswordTest(){
        //3. Verify that home page is visible successfully
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/");


        //4. Click on 'Signup / Login' button
        pages.getHomePage().getSignupLoginButton().click();

        //5. Verify 'Login to your account' is visible
        String loginMessage = pages.getLoginPage().getLoginMessage().getText();
        softAssert.assertEquals(loginMessage,"Login to your account");

        //6. Enter incorrect email address and password
        pages.getLoginPage().setLoginEmailAddress(email);
        pages.getLoginPage().setLoginEmailPassword(password);

        //7. Click 'login' button
        pages.getLoginPage().clickLoginButton();

        //8. Verify error 'Your email or password is incorrect!' is visible
        String errorMessage = pages.getLoginPage().getLoginErrorMessage().getText();
        softAssert.assertEquals(errorMessage,"Your email or password is incorrect!");

        BrowserUtils.wait(2);

        softAssert.assertAll(); // NOTE: don't import to execute 'assertAll' at the end.


    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
