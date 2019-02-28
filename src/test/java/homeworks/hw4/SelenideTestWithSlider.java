package homeworks.hw4;


import base.SelenideBase;
import homeworks.hw4.enums.MainPageData;
import homeworks.hw4.enums.Texts;
import homeworks.hw4.enums.Users;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SelenideTestWithSlider extends SelenideBase {
    private SelenideIndexPage indexPage;
    private SelenideDataPage slidersPage;

    @BeforeMethod
    public void beforeMethod() {
        //1 Open test site by URL
        open(MainPageData.URL.toString());
        indexPage = page(SelenideIndexPage.class);
        slidersPage = page(SelenideDataPage.class);
    }

    @AfterMethod
    public void afterMethod() {
        close();
    }

    @Test
    public void TestWithSliders() {
        //2 Assert Browser title
        indexPage.titleCheck(MainPageData.PAGE_TITLE.toString());

        //3 Perform login
        indexPage.login(Users.PETER);

        //4 Assert User name in the left-top side of screen that user is logged
        indexPage.checkLogin(Users.PETER);

        //5 Open through the header menu Service -> Dates Page
        indexPage.openServicePage(Texts.DATES);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        slidersPage.moveSlider(0, 100);


        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
       slidersPage.checkLogs(0, 100);


        //8 Using drag-and-drop set Range sliders. left sliders - the most left position,right slider - the most left position.
       // slidersPage.moveSlider(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        //slidersPage.checkLogs(0, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position,right slider - the most rigth position.
        slidersPage.moveSlider(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        slidersPage.checkLogs(100, 100);

        //12 Using drag-and-drop set Range sliders.
      // slidersPage.moveSlider(20, 60);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        //slidersPage.checkLogs(20, 60);
    }

}

