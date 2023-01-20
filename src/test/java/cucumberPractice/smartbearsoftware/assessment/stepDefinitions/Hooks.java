package cucumberPractice.smartbearsoftware.assessment.stepDefinitions;

import cucumberPractice.smartbearsoftware.assessment.utilities.ConfigurationReader;
import cucumberPractice.smartbearsoftware.assessment.utilities.Driver;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println(":::: Starting test automation ::::");
        System.out.println("Browser type :: " + ConfigurationReader.getProperty("browser"));
        System.out.println("Environment :: " + ConfigurationReader.getProperty("url"));
        System.out.println("Test scenario :: " + scenario.getName());
        Driver.getDriver().manage().window().maximize();

//        Set<String> handles = Driver.getDriver().getWindowHandles();
//        Iterator<String> it = handles.iterator();
//        String parentWindow = it.next();
//        automationExercise.utilities.Driver.getDriver().switchTo().window(parentWindow);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(image,"image/png",scenario.getName());
        }

        Driver.closeDriver();


    }
}
