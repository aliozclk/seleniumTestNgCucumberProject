package automationExercise.pages;
import automationExercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class ProductsPage extends BasePage{
    @FindBy(id = "search_product")
    private WebElement searchProductBox;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    private WebElement searchedProductsText;

    @FindBy(xpath = "//div[@class='overlay-content']/p")
    private List<WebElement> productNameElements;


    public void searchProduct(String productName){
        searchProductBox.sendKeys(productName);
    }

    public WebElement getSearchProductBox() {
        return searchProductBox;
    }

    public void clickOnSearch(){
        searchButton.click();
    }

    public WebElement getSearchedProductsText() {
        return searchedProductsText;
    }

    public List<WebElement> getProductNameElements() {
        return productNameElements;
    }
}