package lesson4;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by vasuha on 30.01.2019.
 */
public class SelenideIndexPage {

    private SelenideIndexPage indexPage;

    @BeforeMethod
    public void initTest (){
        indexPage = page(SelenideIndexPage.class);
    }


    @AfterMethod
    public void classClose() {
        close();
    }


    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "[id='password']")
    private SelenideElement passswordField;

    @FindBy(className = "submit")
    private SelenideElement submitButton;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;


    public  void  login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passswordField.sendKeys(password);
        submitButton.click();
    }


    public void openIndexPage () {
        open("https://epam.github.io/JDI/index.html");
    }


    @Test
    public void SimpleTest(){
        indexPage.login("epam", "1234");
    }
}
