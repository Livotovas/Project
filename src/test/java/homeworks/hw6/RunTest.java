package homeworks.hw6;


import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "classpath:hw6",
        glue = "classpath:hw6.steps"
)
public class RunTest extends AbstractTestNGCucumberTests {
    @BeforeSuite()
    public void driverSetUp() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 500000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }

}
