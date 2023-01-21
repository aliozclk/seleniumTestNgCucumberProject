package cucumberPractice.smartbearsoftware.assessment.stepDefinitions;

import cucumberPractice.smartbearsoftware.assessment.utilities.BrowserUtils;
import cucumberPractice.smartbearsoftware.assessment.utilities.ConfigurationReader;
import cucumberPractice.smartbearsoftware.assessment.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NewOrderProcessDefs  extends  BaseStep{
    @Given("^the user is on the login page$")
    public void the_user_is_on_the_login_page() throws Throwable {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        System.out.println("Page : " + URL );
        BrowserUtils.wait(2);
    }

    @When("^the user is on the order page$")
    public void the_user_is_on_the_order_page() throws Throwable {
        BrowserUtils.wait(2);
        Assert.assertEquals("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx",
                Driver.getDriver().getCurrentUrl());
    }

    @When("^the user is on the web orders page$")
    public void the_user_is_on_the_web_orders_page() throws Throwable {
        BrowserUtils.wait(2);
        Assert.assertEquals("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/",
                Driver.getDriver().getCurrentUrl());
    }


    @Then("^the user calculates order : product cost X (.+)$")
    public void the_user_calculates_order_product_cost_x_something(String quantity) throws Throwable {
        int price = Integer.parseInt(pages.getOrderPage().getPrice());
        int totalPrice = price * Integer.parseInt(quantity);
        Assert.assertEquals(totalPrice,Integer.parseInt(pages.getOrderPage().getTotalPrice()));
    }

    @Then("^the user gets (.+) message$")
    public void the_user_gets_something_message(String message) throws Throwable {
        BrowserUtils.wait(2);
        Assert.assertEquals(message,pages.getOrderPage().getSuccessMessage());
    }

    @Then("^the user should see order infos on the table : (.+), (.+), (.+), (.+), (.+), (.+), (.+),(.+),(.+),(.+)$")
    public void the_user_should_see_order_infos_on_the_table_(String customername, String productname, String quantity, String street, String city, String state,
                                                              String zip, String cardtype, String cardnumber, String expiredate) throws Throwable {
        BrowserUtils.wait(2);
        Assert.assertEquals(customername,pages.getWebOrdersPage().getCustomerNameLog());
        Assert.assertEquals(productname,pages.getWebOrdersPage().getProductNameLog());
        Assert.assertEquals(quantity,pages.getWebOrdersPage().getQuantityLog());
        Assert.assertEquals(street,pages.getWebOrdersPage().getStreetLog());
        Assert.assertEquals(state,pages.getWebOrdersPage().getStateLog());
        Assert.assertEquals(city,pages.getWebOrdersPage().getCityLog());
        Assert.assertEquals(zip,pages.getWebOrdersPage().getZipLog());
        Assert.assertEquals(cardtype,pages.getWebOrdersPage().getCardNameLog());
        Assert.assertEquals(cardnumber,pages.getWebOrdersPage().getCardNumLog());
        Assert.assertEquals(expiredate,pages.getWebOrdersPage().getExpireDate());


    }

    @Given("the user logged in with valid credentials, {string} as username and {string} as password")
    public void the_user_logged_in_with_valid_credentials_something_as_username_and_something_as_password(String username, String password) throws Throwable {
        pages.getLoginPage().enterUserNameValue(username);
        pages.getLoginPage().enterPasswordValue(password);
        pages.getLoginPage().clickLoginButton();
    }

    @Then("^the user clicks on the order link$")
    public void the_user_clicks_on_the_order_link() throws Throwable {
        BrowserUtils.wait(1);
        pages.getWebOrdersPage().clickOnOrderButton();
    }

    @When("^the user sets product type as (.+)$")
    public void the_user_sets_product_type_as_something(String productName) throws Throwable {
        pages.getOrderPage().selectProduct(productName);

    }

    @When("the user sets {string} of product")
    public void the_user_sets_something_of_product(String quantity) throws Throwable {
        pages.getOrderPage().setQuantity(quantity);
    }

    @When("^the user clicks on the calculate button$")
    public void the_user_clicks_on_the_calculate_button() throws Throwable {
        pages.getOrderPage().clickOnCalculate();
    }

    @Then("^the user sets address infos (.+) , (.+), (.+) , (.+) , (.+)$")
    public void the_user_sets_address_infos_(String customername, String street, String city, String state, String zipcode) throws Throwable {
        pages.getOrderPage().setCity(city);
        pages.getOrderPage().setCustomerName(customername);
        pages.getOrderPage().setStreet(street);
        pages.getOrderPage().setZipBox(zipcode);
        pages.getOrderPage().setStateBox(state);

    }

    @Then("^the user sets card type (.+), (.+), (.+)$")
    public void the_user_sets_card_type_(String cardtype, String cardnumber, String expiredate) throws Throwable {
        pages.getOrderPage().setCardNumber(cardnumber);
        pages.getOrderPage().setExpireDateBox(expiredate);

        switch (cardtype){
            case "Visa":
                pages.getOrderPage().clickOnVisaCard();
                break;
            case "MasterCard":
                pages.getOrderPage().clickOnMasterCard();
                break;
            case "AmericanExpress":
                pages.getOrderPage().clickOnAmericanExpressCard();
                break;
        }

    }

    @Then("^the user clicks on process button$")
    public void the_user_clicks_on_process_button() throws Throwable {
        pages.getOrderPage().clickOnProcessButton();
    }


}
