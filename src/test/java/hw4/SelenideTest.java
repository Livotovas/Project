package hw4;

import base.SeleniumBase;
import com.codeborne.selenide.Configuration;
import lesson4.SelenideIndexPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static lesson4.SelenideIndexPage.*;

// TODO Where is second part of HW ?
public class SelenideTest extends SeleniumBase {
    private SelenideIndexPage indexPage;


    //@BeforeSuite
    //public void beforeSuite() {
    //  Configuration.browser = Browsers.CHROME;
    //}

    @BeforeMethod
    public void initTest() {
        Configuration.browser = "chrome";
        //1 Open test site by URL
        open("http://epam.github.io/JDI/index.html");
        indexPage = page(SelenideIndexPage.class);
        // driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MINUTES);
    }

    @AfterMethod
    public void closeTest() {
        close();
    }

    // TODO This test wont work for me
    //    Element should not be selected {input}
    //    Element: '<input name="metal" type="radio" value="on" selected:true></input>'
    //    Actual value:true
    // TODO PO method should be parametrise by ENUMS

    @Test
    public void simpleTest() {
        //2 Assert Browser title
        Assert.assertEquals(getWebDriver().getTitle(), "Home Page");

        //3 Perform login
        indexPage.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkBy("#user-name", "Piter Chailovskii");

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.clickService();
        indexPage.checkServiceDropdown(Texts.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.clickSideService();
        indexPage.checkLeftServiceDropdown(Texts.values());

        //7 Open through the header menu Service -> Different Elements Page
        // TODO You should not open page directly, use menu
        open("https://epam.github.io/JDI/different-elements.html");
        indexPage.checkMenu();

        //8 Assert that there is Right Section
        // TODO Locators should not be here
        indexPage.checkVisible("#mCSB_2_container > section:nth-child(1) > div.info-panel-body.info-panel-body-log");

        //9 Assert that there is Left Section
        indexPage.checkVisible("#mCSB_1_container > ul > li.menu-title.active > ul > li:nth-child(6) > a");

        //10 Select checkboxes
        // TODO You can pass different amount of arguments into method
        indexPage.clickCheckbox(new DifferentElements[]{DifferentElements.WATER, DifferentElements.WIND});

        //11 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        indexPage.checkCheckboxLogs(new DifferentElements[]{DifferentElements.WATER, DifferentElements.WIND});


        //12 Select radio
        indexPage.clickRadio(new DifferentElements[]{DifferentElements.SELEN});

        //13 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        indexPage.checkRadioLogs(new DifferentElements[]{DifferentElements.SELEN});

        //14 Select in dropdown
        indexPage.clickDropdown(new DropdownElements[]{DropdownElements.YELLOW});

        //15 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        indexPage.checkDropdownLogs(new DropdownElements[]{DropdownElements.YELLOW});

        //16 Unselect and assert checkboxes
        indexPage.clickCheckbox(new DifferentElements[]{DifferentElements.WATER, DifferentElements.WIND});

        //17 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        indexPage.checkCheckboxLogs(new DifferentElements[]{DifferentElements.WATER, DifferentElements.WIND});

    }
}
