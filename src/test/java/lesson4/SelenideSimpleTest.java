package lesson4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by vasuha on 04.02.2019.
 */
public class SelenideSimpleTest {
    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = Browsers.CHROME;
    }


    @Test
    public void simpleTest() {

        open("https://epam.github.io/JDI/index.html");

        //assertEquals(get, "Home Page");

        $("[id='user-icon']").click();
        $("[id='name']").sendKeys("epam");
        $("[id='password']").sendKeys("1234");
        $("[id='login-button']").click();

        $("user-name").shouldHave(Condition.text("PETER CHAILOVSKII"));

        close();


    }
}
