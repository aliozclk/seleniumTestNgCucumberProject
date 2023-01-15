package cucumberPractice.smartbearsoftware.assessment.stepDefinitions;

import cucumberPractice.smartbearsoftware.assessment.utilities.BrowserUtils;
import cucumberPractice.smartbearsoftware.assessment.utilities.ConfigurationReader;
import cucumberPractice.smartbearsoftware.assessment.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginProcessStepDefs extends BaseStep {

    @Given("the user is on the login page")
    public void user_is_on_the_login_page(){

        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        System.out.println("Page : " + URL );
        BrowserUtils.wait(2);
    }

    @When("the user enters username {string}")
    public void user_enters_username(String usernameValue){
        pages.getLoginPage().enterUserNameValue(usernameValue);
    }

    @When("the user enters password as {string}")
    public void user_enters_password(String password){
        pages.getLoginPage().enterPasswordValue(password);
    }

    @When("the user clicks on the Login")
    public void user_clicks_on_the_login(){
        pages.getLoginPage().clickLoginButton();
    }

    @Then("the user should be logged in")
    public void the_user_should_be_logged_in(){
        BrowserUtils.wait(1);
        Assert.assertEquals(pages.getWebOrdersPage().getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }

    @Then("the user arrives at the home page and welcome text containing the username {string}")
    public void the_user_arrives_at_the_home_page_and_welcome_text_containing_the_username(String enteredUserNameValue) {
        String displayedUsername = pages.getWebOrdersPage().getDisplayedUserName();
        System.out.println(enteredUserNameValue);
        System.out.println(displayedUsername);
        Assert.assertTrue(displayedUsername.contains(enteredUserNameValue));
    }

    @Then("the user should not be able to login and {string} error must be displayed")
    public void the_user_should_not_be_able_to_login_and_error_must_be_displayed(String errorMessage){
        String actualMessage = pages.getLoginPage().getErrorMessage();
        Assert.assertTrue(actualMessage.contentEquals(errorMessage));
    }




}
