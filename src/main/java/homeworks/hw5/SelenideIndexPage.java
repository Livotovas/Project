package homeworks.hw5;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homeworks.hw4.enums.HeaderItems.SERVICE;
import static org.testng.Assert.assertEquals;

public class SelenideIndexPage {
    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = ".m-l8 .dropdown")
    private SelenideElement headerServiceDropdown;

    @FindBy(css = ".dropdown-menu li a")
    private ElementsCollection serviceDropdown;

    @FindBy(css = ".menu-title:nth-of-type(3) ul a")
    private ElementsCollection leftServiceDropdown;

    @FindBy(css = ".sidebar-menu li")
    private ElementsCollection leftSectionElements;

    @FindBy(css = ".menu-title:nth-of-type(3) ul a")
    private ElementsCollection leftDropdownElements;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(id = "user-name")
    private SelenideElement userName;



    @Step("Login")
    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    @Step("Login as user")
    public void login(homeworks.hw5.enums.Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }


    @Step("Check \"Service\" category in the header")
    public void checkHeaderDropdown(homeworks.hw5.enums.Texts[] text) {
        headerServiceDropdown.click();
        for (int i = 0; i < text.length; i++) {
            serviceDropdown.get(i).shouldHave(text(text[i].toString()));
        }
    }

    @Step("Checking \"Service\" category in the left section")
    public void checkLeftDropdown(homeworks.hw5.enums.Texts[] text){
        leftSectionElements.findBy(text(SERVICE.toString())).click();
        for (int i = 0; i < text.length; i++) {
            leftDropdownElements.get(i).shouldHave(text(text[i].toString()));
        }
    }

    @Step("Check browser title")
    public void titleCheck(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }


    @Step("Check that user is logged")
    public void checkLogin (homeworks.hw5.enums.Users user) {
        userName.shouldBe(visible);
        userName.shouldHave(text(user.username));
    }


    @Step("Open service dropdown")
    public void openServicePage(homeworks.hw5.enums.Texts pageName) {
        headerServiceDropdown.click();
        serviceDropdown.findBy(text(pageName.toString())).click();
    }






}


