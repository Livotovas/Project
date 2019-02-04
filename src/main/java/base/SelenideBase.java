package base;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

import static com.codeborne.selenide.Selenide.*;

public class SelenideBase {
    @BeforeSuite
    public void beforeSuite(){
        Configuration.browser = Browsers.CHROME;
    }
}
