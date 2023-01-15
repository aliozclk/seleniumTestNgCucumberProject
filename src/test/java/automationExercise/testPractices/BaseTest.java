package automationExercise.testPractices;

import automationExercise.utilities.BrowserUtils;
import automationExercise.utilities.ConfigurationReader;
import automationExercise.utilities.Driver;
import automationExercise.utilities.Pages;
import com.aventstack.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class BaseTest {
    protected Pages pages = new Pages();

    @BeforeSuite
    public void setUpSuite() {

        String url = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");

        Driver.getDriver().get(url);
        System.out.println("-----------TEST INFO --------------\n\tURL : " + url + "\n\tBrowser : " + browser);
        BrowserUtils.wait(1);

        //ByPass AdBlocker-Extension page
        Set<String> handles = Driver.getDriver().getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        Driver.getDriver().switchTo().window(parentWindow);
    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException{
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source,file);
        return file.getPath();
    }

}
