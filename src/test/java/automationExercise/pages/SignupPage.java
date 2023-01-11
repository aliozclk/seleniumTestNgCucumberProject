package automationExercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class SignupPage extends BasePage {


    //Fill details: Title, Name, Email, Password, Date of birth
    @FindBy(xpath = "//*[@id='form']/div/div/div/div[1]/h2")
    private WebElement enterAccountInformationTitle;

    @FindBy(xpath = "//*[@id='id_gender1']")
    private WebElement id_genderMR;

    @FindBy(xpath = "//*[@id='id_gender2']")
    private WebElement id_genderMRS;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//*[@data-qa='days']")
    private WebElement dateOfBirt_DAYs;
    @FindBy(xpath = "//*[@data-qa='months']")
    private WebElement dateOfBirt_MONTHs;

    @FindBy(xpath = "//*[@data-qa='years']")
    private WebElement dateOfBirt_YEARs;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
    private WebElement productsPageButton;
    
    @FindBy(xpath = "//*[@id='country']")
    private WebElement country;

    @FindBy(xpath = "//*[@id='last_name']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='first_name']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='address1']")
    private WebElement address;

    @FindBy(xpath = "//*[@id='state']")
    private WebElement state;

    @FindBy(xpath = "//*[@id='city']")
    private WebElement city;

    @FindBy(xpath = "//*[@id='zipcode']")
    private WebElement zipcode;

    @FindBy(xpath = "//*[@id='mobile_number']")
    private WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa=\"create-account\"]")
    private WebElement createAccountBtn;

    @FindBy(xpath = "//*[@id=\"newsletter\"]")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckBox;
    


    public SignupPage() {
    }


    public String getEnterAccountInformationTitle() {
        return enterAccountInformationTitle.getText();

    }

    public void selectTitleMen() {
        id_genderMR.click();
    }

    public void selectTitleWomen() {
        id_genderMRS.click();
    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);
    }

    public void setDateOfBirt(String day, String month, String year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }



    private void setDay(String day) {
        Select select = new Select(dateOfBirt_DAYs);
        select.selectByVisibleText(day);
    }

    private void setMonth(String month) {
        Select select = new Select(dateOfBirt_MONTHs);
        select.selectByVisibleText(month);
    }

    private void setYear(String year) {
        Select select = new Select(dateOfBirt_YEARs);
        select.selectByVisibleText(year);

    }

    public void selectProductsPageButton() {
        productsPageButton.click();
    }

    public WebElement getCountryElement(){
        return country;
    }

    public void selectCountry(String chosenCountry){
        Select dropdown = new Select(getCountryElement());
        dropdown.selectByVisibleText(chosenCountry);
    }

    public void setState(String state){
        this.state.sendKeys(state);
    }

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void setAddress(String address){
        this.address.sendKeys(address);
    }

    public void setCity(String city){
        this.city.sendKeys(city);
    }

    public void setZipcode(String zipcode){
        this.zipcode.sendKeys(zipcode);
    }

    public void setMobileNumber(String number){
        mobileNumber.sendKeys(number);
    }

    public WebElement getCreateAccountBtn(){
        return createAccountBtn;
    }

    public void selectNewsletterCheckbox(){
        newsletterCheckbox.click();
    }

    public void selectSpecialOffersCheckBox(){
        specialOffersCheckBox.click();
    }


}