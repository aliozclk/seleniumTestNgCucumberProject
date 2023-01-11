package automationExercise.pages;

import automationExercise.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    private WebElement SignupLoginButton;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a")
    private WebElement productButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    private WebElement loggedUser;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
    private WebElement deleteAccountBtn;


    public void clickSignupLoginButton() {
        SignupLoginButton.click();
    }

    public void clickProductButton(){
        BrowserUtils.verifyElementDisplayed(productButton);
        productButton.click();
    }

    public WebElement getSignupLoginButton() {
        return SignupLoginButton;
    }

    public WebElement getProductButton() {
        return productButton;
    }

    public WebElement getLoggedUser() {
        return loggedUser;
    }

    public WebElement getDeleteAccountBtn() {
        return deleteAccountBtn;
    }
}