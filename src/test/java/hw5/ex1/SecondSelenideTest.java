package hw5.ex1;

import base.SelenideBase;
import homeworks.hw4.enums.Texts;
import homeworks.hw5.AllureListener;
import homeworks.hw5.SelenideDifferentElementsPage;
import homeworks.hw5.SelenideIndexPage;
import homeworks.hw5.enums.DifferentElements;
import homeworks.hw5.enums.Users;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import static homeworks.hw5.enums.DifferentElements.SELEN;
import static homeworks.hw5.enums.DifferentElements.WATER;
import static homeworks.hw5.enums.DifferentElements.WIND;
import static homeworks.hw5.enums.MainPageData.PAGE_TITLE;
import static homeworks.hw5.enums.Texts.*;
import static homeworks.hw5.enums.Users.*;
import static homeworks.hw5.enums.Users.PETER;
import static homeworks.hw5.enums.DifferentElements.*;


@Feature("\"Different Elements\" page test")
@Listeners(AllureListener.class)
public class SecondSelenideTest extends SelenideBase {
    private homeworks.hw5.SelenideIndexPage indexPage;
    private SelenideDifferentElementsPage differentElementsPage;


    @BeforeMethod
    public void initTest(){
        //1 Open test site by URL
        open("https://epam.github.io/JDI/index.html");
        indexPage = page(SelenideIndexPage.class);
        differentElementsPage = page(SelenideDifferentElementsPage.class);
    }

    @AfterMethod
    public void closeTest(){
        close();
    }


    @Story("Test \"Home Page\" Service menus and \"Different Elements\" page main interface")
    @Test
    public void simpleTest() {
        indexPage.titleCheck(PAGE_TITLE.toString());

        //3 Perform login
        indexPage.login(PETER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkLogin(PETER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkHeaderDropdown(homeworks.hw5.enums.Texts.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkLeftDropdown(homeworks.hw5.enums.Texts.values());

        //7 Open through the header menu Service -> Different Elements Page
        indexPage.openServicePage(homeworks.hw5.enums.Texts.DIFFERENT_ELEMENTS);

        //8 Assert that there is Right Section
        differentElementsPage.mainElementsCheck();

        //9 Assert that there is Left Section
        differentElementsPage.checkLeftSection();

        //10 Select checkboxes
        differentElementsPage.selectElements(WATER, WIND);

        //11 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkCheckboxLogs("true", WATER, WIND);

        //12 Select radio
        differentElementsPage.selectMetal(SELEN);

        //13 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkRadioLogs(SELEN);

        //14 Select in dropdown
        //differentElementsPage.selectColor(YELLOW);

        //15 Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        //differentElementsPage.checkDropdownLogs(YELLOW);

        //16 Unselect and assert checkboxes
        differentElementsPage.selectElements(WATER, WIND);

        //17 Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkCheckboxLogs("false", WATER, WIND);

    }
}
