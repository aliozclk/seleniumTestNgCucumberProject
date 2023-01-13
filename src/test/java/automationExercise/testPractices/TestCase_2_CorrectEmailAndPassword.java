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

public class TestCase_2_CorrectEmailAndPassword extends BaseTest {


    SoftAssert softAssert = new SoftAssert();
    String emailAdress = "namename@gmail.com";
    String password = "passpassword";

    String name = "Ali";

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
    public void signupNewUser(){
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/");

        //4. Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();

        //5.Verify 'New User Signup!' is visible
        String newUserSignUpMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignUpMessage, "New User Signup!", "Test Case 1 - Verify 'New User Signup!' is visible");

        //6. Enter name and email address
        pages.getLoginPage().setSignupNewUserName(name);

        pages.getLoginPage().setSignupEmailAddressBox(emailAdress);
        //7. Click 'Signup' button
        pages.getLoginPage().clickSignupButton();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualEnterAccountInformationTitle = pages.getSignupPage().getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle, "ENTER ACCOUNT INFORMATION", "ERROR : Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible\n");

        // 9.Fill details: Title, Name, Email, Password, Date of birth
        pages.getSignupPage().selectTitleMen();
        pages.getSignupPage().setPassword(password);
        pages.getSignupPage().setDateOfBirt("12", "April", "1945");

        //10. Select checkbox 'Sign up for our newsletter!'
        pages.getSignupPage().selectNewsletterCheckbox();

        //11. Select checkbox 'Receive special offers from our partners!'
        pages.getSignupPage().selectSpecialOffersCheckBox();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        pages.getSignupPage().setFirstName("Ali D.");
        pages.getSignupPage().setLastName("LastName");
        pages.getSignupPage().setAddress("Address Street No");
        pages.getSignupPage().selectCountry("Canada");
        pages.getSignupPage().setState("State");
        pages.getSignupPage().setCity("Toronto");
        pages.getSignupPage().setZipcode("123456");
        pages.getSignupPage().setMobileNumber("123456789");

        //13. Click 'Create Account button'
        pages.getSignupPage().getCreateAccountBtn().click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        String message = pages.getAccountCreatedPage().getAccountCreatedMessage().getText();
        softAssert.assertEquals(message, "ACCOUNT CREATED!");
        //15. Click 'Continue' button
        pages.getAccountCreatedPage().getContinueButton().click();

        //16. Verify that 'Logged in as username' is visible
        String username = pages.getHomePage().getLoggedUser().getText();
        softAssert.assertTrue(username.contains(name));

        //click on log out btn
        pages.getHomePage().getLogoutBtn().click();

        //softAssert.assertAll();
    }

    @Test(priority = 1)
    public void correctEmailAndPasswordTest(){
        //            3. Verify that home page is visible successfully
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/");

        //4. Click on 'Signup / Login' button
        pages.getHomePage().getSignupLoginButton().click();

        //5. Verify 'Login to your account' is visible
        String loginMessage = pages.getLoginPage().getLoginMessage().getText();
        softAssert.assertEquals(loginMessage,"Login to your account");

        //6. Enter correct email address and password
        pages.getLoginPage().setLoginEmailAddress(emailAdress);
        pages.getLoginPage().setLoginEmailPassword(password);

        //7. Click 'login' button
        pages.getLoginPage().clickLoginButton();

        //8. Verify that 'Logged in as username' is visible
        String username = pages.getHomePage().getLoggedUser().getText();
        softAssert.assertTrue(username.contains(name));

        //9. Click 'Delete Account' button
        pages.getHomePage().getDeleteAccountBtn().click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        String msgDeleted = pages.getDeleteAccountPage().getAccountDeletedMessage().getText();
        softAssert.assertEquals(msgDeleted,"ACCOUNT DELETED!");
        pages.getDeleteAccountPage().getContinueButton().click();

        //softAssert.assertAll(); // NOTE: don't import to execute 'assertAll' at the end.
    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }

}
