package lesson4;


import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.collections.SizeLessThanOrEqual;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.*;

public class SelenideIndexPage {
    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown > a")
    private SelenideElement service;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".main-content .uui-form-element")
    private ElementsCollection dropdown;

    @FindBy(css = ".main-content .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "#mCSB_1_container > ul > li:nth-child(3) > a")
    private SelenideElement sideService;

    @FindBy(css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(7)")
    private SelenideElement differentElements;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logs;

    public enum DifferentElements {
        WATER,
        EARTH,
        WIND,
        FIRE,
        GOLD,
        SILVER,
        BRONZE,
        SELEN
    }

    public enum DropdownElements {
        RED,
        GREEN,
        BLUE,
        YELLOW
    }


    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void clickService() {
        service.click();
    }

    public void clickSideService() {
        sideService.click();
    }

    public void clickDifferentElements() {
        differentElements.click();
    }


    public void checkBy(String url, String txt) {
        $(url).shouldHave(text(txt));
    }


    public void checkList(List<String> url, List<String> txt) {
        for (int j = 0; j < url.size(); j++) {
            $(url.get(j)).shouldHave(text(txt.get(j)));
        }
    }

    public void checkVisible(String url) {
        $(url).should(visible);
    }

    public void checkMenu() {
        checkBoxes.shouldHave(sizeGreaterThanOrEqual(4));
        radios.shouldHave(sizeGreaterThanOrEqual(4));
        dropdown.shouldHave(sizeGreaterThanOrEqual(1));
        buttons.shouldHave(sizeGreaterThanOrEqual(2));

    }

    public void clickCheckbox(DifferentElements[] elem) {
        for (DifferentElements el : elem) {
            checkBoxes.findBy(text(el.toString())).$("input").click();
        }
    }

    public void clickRadio(DifferentElements[] elem) {
        for (DifferentElements el : elem) {
            radios.findBy(text(el.toString())).$("input").click();
        }
    }

    public void clickDropdown(DropdownElements[] elem) {
        for (DropdownElements el : elem) {
            dropdown.findBy(text(el.toString())).$("input").click();
        }
    }


    public void checkCheckboxLogs(DifferentElements[] elem) {

        for (int j = 0; j < elem.length; j++) {
            logs.get(elem.length - 1 - j).shouldBe(visible);
            assertTrue(logs.get(elem.length - 1 - j).text().toUpperCase().contains(elem[j].toString()));
            if (logs.get(elem.length - 1 - j).text().contains("true")) {
                checkBoxes.findBy(text(elem[j].toString())).$("input").shouldBe(Condition.selected);
            } else {
                checkBoxes.findBy(text(elem[j].toString())).$("input").shouldNotBe(Condition.selected);
            }
        }
    }

    public void checkRadioLogs(DifferentElements[] elem) {

        for (int j = 0; j < elem.length; j++) {
            logs.get(elem.length - 1 - j).shouldBe(visible);
            assertTrue(logs.get(elem.length - 1 - j).text().toUpperCase().contains(elem[j].toString()));
            if (logs.get(elem.length - 1 - j).text().contains("true")) {
                radios.findBy(text(elem[j].toString())).$("input").shouldBe(Condition.selected);
            } else {
                radios.findBy(text(elem[j].toString())).$("input").shouldNotBe(Condition.selected);
            }
        }
    }

    public void checkDropdownLogs(DropdownElements[] elem) {

        for (int j = 0; j < elem.length; j++) {
            logs.get(elem.length - 1 - j).shouldBe(visible);
            assertTrue(logs.get(elem.length - 1 - j).text().toUpperCase().contains(elem[j].toString()));
        }
    }
}


