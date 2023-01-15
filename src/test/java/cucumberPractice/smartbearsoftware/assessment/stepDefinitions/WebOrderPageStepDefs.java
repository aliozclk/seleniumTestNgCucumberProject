package cucumberPractice.smartbearsoftware.assessment.stepDefinitions;

import cucumberPractice.smartbearsoftware.assessment.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class WebOrderPageStepDefs extends BaseStep {


    @Given("the user logged in with valid credentials, {string} as username and {string} as password")
    public void the_user_logged_in_with_valid_credentials_as_username_and_as_password(String usernameValue,String passwordValue){
        pages.getLoginPage().enterUserNameValue(usernameValue);
        pages.getLoginPage().enterPasswordValue(passwordValue);
        pages.getLoginPage().clickLoginButton();
    }

    @Given("the user is on the web orders page")
    public void the_user_is_on_the_web_orders_page(){
        BrowserUtils.wait(1);
        Assert.assertEquals(pages.getWebOrdersPage().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
    }

    @Then("the user views the level {int} header is displayed as {string}")
    public void the_user_views_the_level_1_header_is_displayed_as(Integer levelOfHeader, String header){
        String actualHeader = pages.getWebOrdersPage().getHeaderAsString(levelOfHeader);
        Assert.assertTrue(actualHeader.contentEquals(header));
    }

    @Then("the user should be able to see {string} section in vertical menu bar")
    public void the_user_should_be_able_to_see_section_in_vertical_menu_bar(String verticalMenuBarItem){
        Assert.assertTrue(pages.getWebOrdersPage().isVerticalMenuBarItemDisplayed(verticalMenuBarItem));
    }

    @When("the user clicks on the logout button")
    public void the_user_clicks_on_the_logout_button(){
        pages.getWebOrdersPage().clickLogoutButton();
    }

    @Then("the user logs out and navigates to the login page")
    public void the_user_logs_out_and_navigates_to_the_login_page(){
        Assert.assertEquals("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx",
                pages.getLoginPage().getCurrentUrl());
    }
}
