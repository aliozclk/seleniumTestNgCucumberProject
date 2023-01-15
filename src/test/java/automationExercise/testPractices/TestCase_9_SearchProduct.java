package automationExercise.testPractices;

import automationExercise.utilities.BrowserUtils;
import automationExercise.utilities.Driver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.List;


public class TestCase_9_SearchProduct extends BaseTest{
//
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

    SoftAssert softAssert = new SoftAssert();

    String searchedProduct = "Dress";



    @Test(priority = 0)
    public void searchProductTest(){
        //3. Verify that home page is visible successfully
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://automationexercise.com/");

        //4. Click on 'Products' button
        pages.getHomePage().clickOnProductsButton();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        softAssert.assertTrue(pages.getProductsPage().getSearchProductBox().isDisplayed());

        //6. Enter product name in search input and click search button
        pages.getProductsPage().searchProduct(searchedProduct);
        pages.getProductsPage().clickOnSearch();

        //7. Verify 'SEARCHED PRODUCTS' is visible
        String searchedProductsText = pages.getProductsPage().getSearchedProductsText().getText();

        //8. Verify all the products related to search are visible
        List<WebElement> productNameElements = pages.getProductsPage().getProductNameElements();
        int matchedProducts = (int) productNameElements.stream().filter(name -> name.getText().contains(searchedProduct)).count();
        softAssert.assertTrue(matchedProducts == productNameElements.size());

        BrowserUtils.wait(2);

        //softAssert.assertAll();



    }


}
