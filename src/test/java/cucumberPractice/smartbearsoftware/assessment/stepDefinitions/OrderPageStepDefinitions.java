package cucumberPractice.smartbearsoftware.assessment.stepDefinitions;

import cucumberPractice.smartbearsoftware.assessment.utilities.BrowserUtils;
import cucumberPractice.smartbearsoftware.assessment.utilities.ConfigurationReader;
import cucumberPractice.smartbearsoftware.assessment.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OrderPageStepDefinitions extends BaseStep{
    @Given("^the user is on the login page$")
    public void the_user_is_on_the_login_page(){
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        System.out.println("Page : " + URL );
        BrowserUtils.wait(2);
    }

    @When("^the user is on the order page$")
    public void the_user_is_on_the_order_page(){
        BrowserUtils.wait(1);
        Assert.assertEquals(pages.getWebOrdersPage().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
    }

    @And("^the user sets product type as (.+)$")
    public void the_user_sets_product_type_as(String productname){
        pages.getOrderPage().selectProduct(productname);
    }

    @Then("^the user is on the web orders page$")
    public void the_user_is_on_the_web_orders_page(){
        BrowserUtils.wait(1);
        Assert.assertEquals(pages.getWebOrdersPage().getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Default.aspx");
    }

    @And("the user clicks on the order link")
    public void the_user_clicks_on_the_order_link() throws InterruptedException {
        Thread.sleep(1000);
        pages.getWebOrdersPage().clickOnOrderButton();
    }

    @Then("^the user calculates order : product cost X (.+)$")
    public void the_user_calculates_order_product_cost_x_quantity(String quantity){
        String price = pages.getOrderPage().getPrice();
        int pricePerUnit = Integer.parseInt(price);
        int amount = Integer.parseInt(quantity);
        int totalAmount = pricePerUnit * amount;
        Assert.assertTrue(Integer.parseInt(price) == totalAmount );
    }

    @Then("the user gets {string} message")
    public void the_user_gets_message(String message){
        Assert.assertEquals(message,pages.getOrderPage().getSuccessMessage());
    }

    @And("^the user logged in with valid credentials, (.+) as username and (.+) as password$")
    public void the_user_logged_in_with_valid_credentials_as_username_and_as_password(String username, String password){
        pages.getLoginPage().enterUserNameValue(username);
        pages.getLoginPage().enterPasswordValue(password);
        pages.getLoginPage().clickLoginButton();
    }

    @And("^the user sets address infos (.+) , (.+), (.+) , (.+) , (.+)$")
    public void the_user_sets_address_infos_(String customername, String street, String city, String state, String zipcode) throws Throwable {
        pages.getOrderPage().setCustomerName(customername);
        pages.getOrderPage().setStreet(street);
        pages.getOrderPage().setCity(city);
        pages.getOrderPage().setStateBox(state);
        pages.getOrderPage().setZipBox(zipcode);
    }

    @And("^the user sets (.+) of product$")
    public void the_user_sets_quantity_of_product(String quantity){
        pages.getOrderPage().setQuantity(quantity);
    }

    @And("^the user clicks on the calculate button$")
    public void the_user_clicks_on_the_calculate_button(){
        pages.getOrderPage().clickOnCalculate();
    }

    @And("^the user sets card type (.+), (.+), (.+)$")
    public void the_user_sets_card_type_(String cardtype, String cardnumber, String expiredate){
        pages.getOrderPage().setCardNumber(cardnumber);
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
        pages.getOrderPage().setExpireDateBox(expiredate);

    }

    @And("^the user clicks on process button$")
    public void the_user_clicks_on_process_button(){
        pages.getOrderPage().clickOnProcessButton();
    }

    @Then("^the user should see order infos on the table : (.+), (.+), (.+), (.+), (.+), (.+), (.+),(.+),(.+),(.+)$")
    public void the_user_sees_order_infos_on_the_table_(String customername, String productname, String quantity,
                                                        String street, String city, String state, String zip, String cardtype, String cardnumber, String expiredate){
        Assert.assertEquals(customername,pages.getWebOrdersPage().getCustomerNameLog());
        Assert.assertEquals(productname,pages.getWebOrdersPage().getProductNameLog());
        Assert.assertEquals(quantity,pages.getWebOrdersPage().getQuantityLog());
        Assert.assertEquals(street,pages.getWebOrdersPage().getStreetLog());
        Assert.assertEquals(city,pages.getWebOrdersPage().getCityLog());
        Assert.assertEquals(state,pages.getWebOrdersPage().getStateLog());
        Assert.assertEquals(zip,pages.getWebOrdersPage().getZipLog());
        Assert.assertEquals(cardtype,pages.getWebOrdersPage().getCardNameLog());
        Assert.assertEquals(cardnumber,pages.getWebOrdersPage().getCardNumLog());
        Assert.assertEquals(expiredate,pages.getWebOrdersPage().getExpireDate());
    }


}
