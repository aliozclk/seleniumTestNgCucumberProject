package cucumberPractice.smartbearsoftware.assessment.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebOrdersPage extends BasePage {

    @FindBy(xpath = "//div[@class='login_info']")
    private WebElement displayedUserName;

    @FindBy(xpath = "//h1")
    private WebElement levelOneHeader;

    @FindBy(id = "ctl00_logout")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[@href='Default.aspx']")
    private WebElement viewAllOrdersButton;

    @FindBy(xpath = "//a[@href='Products.aspx']")
    private WebElement viewAllOProductsButton;

    @FindBy(xpath = "//a[@href='Process.aspx']")
    private WebElement orderButton;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td")
    List<WebElement> lastOrderLogs;

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getDisplayedUserName(){
        return displayedUserName.getText();
    }

    public String getHeaderAsString(Integer levelOfHeader){
        String result = null ;
        switch (levelOfHeader){
            case 1:
                result = levelOneHeader.getText();
                break;
        }
        return result;
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public boolean isVerticalMenuBarItemDisplayed(String verticalMenuBarItem){
        boolean result = false;

        switch (verticalMenuBarItem){
            case "View all orders":
                result = viewAllOrdersButton.isDisplayed();
                break;
            case "View all products":
                result = viewAllOProductsButton.isDisplayed();
                break;
            case "Order":
                result = orderButton.isDisplayed();
                break;
        }
        return result;
    }

    public String getCustomerNameLog(){
        return lastOrderLogs.get(2).getText();
    }

    public String getProductNameLog(){
        return lastOrderLogs.get(3).getText();
    }

    public String getQuantityLog(){
        return lastOrderLogs.get(4).getText();
    }
    public String getDateLog(){
        return lastOrderLogs.get(5).getText();
    }
    public String getStreetLog(){
        return lastOrderLogs.get(6).getText();
    }

    public String getCityLog(){
        return lastOrderLogs.get(7).getText();
    }

    public String getStateLog(){
        return lastOrderLogs.get(8).getText();
    }
    public String getZipLog(){
        return lastOrderLogs.get(9).getText();
    }
    public String getCardNameLog(){
        return lastOrderLogs.get(10).getText();
    }
    public String getCardNumLog(){
        return lastOrderLogs.get(11).getText();
    }
}
