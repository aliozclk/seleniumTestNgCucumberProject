package automationExercise.testPractices;

import automationExercise.utilities.BrowserUtils;
import automationExercise.utilities.Driver;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class RegistrationTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();



    @Test(priority = 0)
    public void TestCase_1_Registiration() {
        // 2. Navigate to url 'http://automationexercise.
        //3. Verify that home page is visible successfully

        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/");

        //4. Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();

        //5.Verify 'New User Signup!' is visible
        String newUserSignUpMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignUpMessage, "New User Signup!", "Test Case 1 - Verify 'New User Signup!' is visible");

        //6. Enter name and email address
        String name = "Ali";
        pages.getLoginPage().setSignupNewUserName(name);

        pages.getLoginPage().setSignupEmailAddressBox("gfhfgfgj@gmail.com");
        //7. Click 'Signup' button
        pages.getLoginPage().clickSignupButton();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualEnterAccountInformationTitle = pages.getSignupPage().getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle, "ENTER ACCOUNT INFORMATION", "ERROR : Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible\n");

        // 9.Fill details: Title, Name, Email, Password, Date of birth
        pages.getSignupPage().selectTitleMen();
        pages.getSignupPage().setPassword("hacasdf");
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

        //17. Click 'Delete Account' button
        pages.getHomePage().getDeleteAccountBtn().click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String msgDeleted = pages.getDeleteAccountPage().getAccountDeletedMessage().getText();
        softAssert.assertEquals(msgDeleted,"ACCOUNT DELETED!");
        pages.getDeleteAccountPage().getContinueButton().click();

        BrowserUtils.wait(6);

        softAssert.assertAll(); // NOTE: don't import to execute 'assertAll' at the end.


    }


}
