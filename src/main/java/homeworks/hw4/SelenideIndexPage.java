package homeworks.hw4;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw4.enums.HeaderItems;
import homeworks.hw4.enums.Texts;
import homeworks.hw4.enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homeworks.hw4.enums.HeaderItems.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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




    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void login(Users user) {
        loginIcon.click();
        userField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submitButton.click();
    }

    public void checkHeaderDropdown(Texts[] text) {
        headerServiceDropdown.click();
        for (int i = 0; i < text.length; i++) {
            serviceDropdown.get(i).shouldHave(text(text[i].toString()));
        }
    }

    public void checkLeftDropdown(Texts[] text){
        leftSectionElements.findBy(text(SERVICE.toString())).click();
        for (int i = 0; i < text.length; i++) {
            leftDropdownElements.get(i).shouldHave(text(text[i].toString()));
        }
    }


    public void titleCheck(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }


    public void checkLogin (Users user) {
        userName.shouldBe(visible);
        userName.shouldHave(text(user.username));
    }

    public void checkLeftServiceDropdown(Texts[] serviceText) {
        for (int j = 0; j < serviceText.length; j++) {
            leftServiceDropdown.get(j).shouldHave(text(serviceText[j].toString()));
        }
    }



    public void openServicePage(Texts pageName) {
        headerServiceDropdown.click();
        serviceDropdown.findBy(text(pageName.toString())).click();
    }






}


