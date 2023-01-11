package automationExercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {


    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b" )
    private WebElement accountCreatedMessage;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    private WebElement continueButton;

    public AccountCreatedPage(){

    }
    public WebElement getAccountCreatedMessage() {
        return accountCreatedMessage;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }


}
