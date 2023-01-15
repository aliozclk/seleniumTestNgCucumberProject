package automationExercise.testPractices;

import automationExercise.utilities.BrowserUtils;
import automationExercise.utilities.Driver;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestCase_3_IncorrectEmailAndPassword extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    String email = "wrong@email.com";

    String password = "password";


    //    1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'



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

}
