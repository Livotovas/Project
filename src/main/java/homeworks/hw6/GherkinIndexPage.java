package homeworks.hw6;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import homeworks.hw6.enums.HeaderItems;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static homeworks.hw6.enums.HeaderItems.*;
import static org.testng.Assert.assertEquals;

//for commit
public class GherkinIndexPage {

    @FindBy(css = "#user-icon")
    private SelenideElement loginIcon;

    @FindBy(css = "#name")
    private SelenideElement userField;

    @FindBy(css = "#password")
    private SelenideElement passwordField;

    @FindBy(css = "#login-button")
    private SelenideElement submitButton;

    @FindBy(css = "#user-name")
    private SelenideElement userName;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection icons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection iconTexts;

    @FindBy(css = ".main-title")
    private SelenideElement title;

    @FindBy(css = ".main-txt")
    private SelenideElement titleText;

    @org.openqa.selenium.support.FindBy(css = ".m-l8 .dropdown")
    private SelenideElement headerServiceDropdown;

    @org.openqa.selenium.support.FindBy(css = ".dropdown-menu li a")
    private ElementsCollection serviceDropdown;

    @FindBy(css = ".m-l8 > li")
    private ElementsCollection headerNavigationSection;

    @org.openqa.selenium.support.FindBy(css = ".menu-title:nth-of-type(3) ul a")
    private ElementsCollection leftDropdownElements;


    @org.openqa.selenium.support.FindBy(css = ".sidebar-menu li")
    private ElementsCollection leftSectionElements;

    @FindBy(css = ".sidebar-menu li")
    private ElementsCollection leftNavigationSection;


    public void login(String login, String password) {
        loginIcon.click();
        userField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void login(homeworks.hw6.enums.Users user) {
        login(user.getLogin(), user.getPassword());
    }

    public void checkLogin(homeworks.hw6.enums.Users user) {
        userName.shouldBe(visible);
        userName.shouldHave(text(user.getUsername()));
    }

    public void openServicePage(homeworks.hw6.enums.Texts pageName) {
        headerServiceDropdown.click();
        serviceDropdown.findBy(text(pageName.toString())).click();
    }

    public void headerNavigation(HeaderItems headerItem) {
        headerNavigationSection.find(text(headerItem.toString())).click();
    }

    public void leftNavigation(HeaderItems leftItem) {
        leftNavigationSection.find(text(leftItem.toString())).click();
    }

    public void checkHeaderDropdown(homeworks.hw6.enums.Texts[] text) {
        headerServiceDropdown.click();
        for (int i = 0; i < text.length; i++) {
            serviceDropdown.get(i).shouldHave(text(text[i].toString()));
        }
    }

    public void checkLeftDropdown(homeworks.hw6.enums.Texts[] text) {
        leftSectionElements.findBy(text(SERVICE.toString())).click();
        for (int i = 0; i < text.length; i++) {
            leftDropdownElements.get(i).shouldHave(text(text[i].toString()));
        }
    }

    public void checkTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

    public void checkMainPage() {
        for (SelenideElement icon : icons) {
            icon.shouldBe(visible);
        }
        for (SelenideElement text : iconTexts) {
            text.shouldBe(visible);
        }
        title.shouldBe(visible);
        titleText.shouldBe(visible);
    }


}
