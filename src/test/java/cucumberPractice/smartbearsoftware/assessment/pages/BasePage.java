package cucumberPractice.smartbearsoftware.assessment.pages;

import cucumberPractice.smartbearsoftware.assessment.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver = Driver.getDriver();
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public BasePage() {
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    public void navigateTo(String component) {
        String locator = "//a[text() = '" + component + "']";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }

    public WebDriver giveDriver(){
        return driver;
    }
}