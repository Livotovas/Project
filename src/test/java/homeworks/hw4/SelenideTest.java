package homeworks.hw4;

import base.SelenideBase;
import base.SeleniumBase;

import homeworks.hw4.enums.DifferentElements;
import homeworks.hw4.enums.MainPageData;
import homeworks.hw4.enums.Texts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static homeworks.hw4.enums.DifferentElements.*;
import static homeworks.hw4.SelenideIndexPage.*;
import static homeworks.hw4.enums.MainPageData.*;
import static homeworks.hw4.enums.Users.*;

public class SelenideTest extends SelenideBase{
    private SelenideIndexPage indexPage;
    private SelenideDifferentElementsPage differentElementsPage;


    @BeforeMethod
    public void initTest(){
        //1 Open test site by URL
        open(MainPageData.URL.toString());
        indexPage = page(SelenideIndexPage.class);
        differentElementsPage = page(SelenideDifferentElementsPage.class);

    }

    @AfterMethod
    public void closeTest(){
        close();
    }

    @Test
    public void simpleTest() {
        //2 Assert Browser title
        indexPage.titleCheck(PAGE_TITLE.toString());

        //3 Perform login
        indexPage.login(PETER);

        //4 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkLogin(PETER);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkHeaderDropdown(Texts.values());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkLeftDropdown(Texts.values());

        //7 Open through the header menu Service -> Different Elements Page
        indexPage.openServicePage(Texts.DIFFERENT_ELEMENTS);

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
