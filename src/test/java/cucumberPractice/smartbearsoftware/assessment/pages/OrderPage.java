package cucumberPractice.smartbearsoftware.assessment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrderPage extends BasePage{

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement dropdownElement;

    Select dropdown = new Select(dropdownElement);


    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantityBox;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/ol[1]/li[5]/input[2]")
    WebElement calculateButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    WebElement totalPrice;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    WebElement customerNameBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    WebElement streetBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    WebElement cityBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    WebElement stateBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visaCardCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCardCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpCardCheckbox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumberBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDateBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/input")
    WebElement resetButton;

    @FindBy(xpath = "//*[@id=\"ctl00_menu\"]/li[1]/a")
    WebElement viewAllOrdersLink;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")
    WebElement successMessage;

    public void selectProduct(String productName){
        dropdown.selectByVisibleText(productName);
    }

    public void setQuantity(String quantity){
        quantityBox.clear();
        quantityBox.sendKeys(quantity);
    }

    public void clickOnCalculate(){
        calculateButton.click();
    }

    public String getTotalPrice(){
        return totalPrice.getText();
    }

    public void setCustomerName(String customerName){
        customerNameBox.sendKeys(customerName);
    }

    public void setStreet(String street){
        streetBox.sendKeys(street);
    }

    public void setCity(String city){
        cityBox.sendKeys(city);
    }

    public void setStateBox(String state){
        stateBox.sendKeys(state);
    }

    public void setZipBox(String zip){
        zipBox.sendKeys(zip);
    }

    public void clickOnVisaCard(){
        visaCardCheckbox.click();
    }

    public void clickOnMasterCard(){
        masterCardCheckbox.click();
    }

    public void clickOnAmericanExpressCard(){
        americanExpCardCheckbox.click();
    }

    public void setCardNumber(String cardNumber){
        cardNumberBox.sendKeys(cardNumber);
    }

    public void setExpireDateBox(String expireDate){
        expireDateBox.sendKeys(expireDate);
    }

    public void clickOnProcessButton(){
        processButton.click();
    }

    public void clickOnResetButton(){
        resetButton.click();
    }

}
