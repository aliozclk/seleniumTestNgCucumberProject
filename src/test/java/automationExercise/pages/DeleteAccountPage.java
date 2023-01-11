package automationExercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    private WebElement accountDeletedMessage;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    private WebElement continueButton;

    public DeleteAccountPage(){

    }

    public WebElement getAccountDeletedMessage() {
        return accountDeletedMessage;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }
}
