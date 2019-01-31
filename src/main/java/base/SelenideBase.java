package base;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by vasuha on 30.01.2019.
 */
public class SelenideBase {
    @BeforeSuite
    public void beforeSuite(){
        Configuration.browser = Browsers.CHROME;
    }
}
