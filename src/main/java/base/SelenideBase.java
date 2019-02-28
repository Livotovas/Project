package base;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

import static com.codeborne.selenide.Selenide.*;

public abstract class SelenideBase {
    @BeforeSuite()
    public void beforeSuite() {
        //По умолчанию:
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 50000;
        Configuration.pollingInterval = 300;
        Configuration.startMaximized = true;
    }
}
