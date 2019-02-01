package hw4;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lesson4.SelenideIndexPage;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by vasuha on 01.02.2019.
 */
public class SelenideTest {

    private SelenideIndexPage indexPage;


    //@BeforeSuite
    //public void beforeSuite() {
      //  Configuration.browser = Browsers.CHROME;
    //}

    @BeforeMethod
    public void initTest(){
        //1 Open test site by URL
         open("https://epam.github.io/JDI/index.html");
        indexPage = page(SelenideIndexPage.class);
    }

    @AfterMethod
    public void closeTest(){
        close();
    }

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
       List<String> serviceUrls = new ArrayList<String>();
       List<String> texts = new ArrayList<String>();
       serviceUrls.add("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(1) > a");
       serviceUrls.add("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(2) > a");
       serviceUrls.add("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(3) > a");
       serviceUrls.add("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(4) > a");
       serviceUrls.add("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(5) > a");
       serviceUrls.add("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(6) > a");
       serviceUrls.add("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(7) > a");
       serviceUrls.add("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(8) > a");
       texts.add("Support");
       texts.add("Dates");
       texts.add("Complex Table");
       texts.add("Simple Table");
       texts.add("User Table");
       texts.add("Table with pages");
       texts.add("Different elements");
       texts.add("Performance");
       indexPage.checkList(serviceUrls, texts);

        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.clickSideService();
        List <String> sideUrls = new ArrayList<String>();
        sideUrls.add("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(1) > a > p > span");
        sideUrls.add("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(2) > a");
        sideUrls.add("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(3) > a > span");
        sideUrls.add("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(4) > a > span");
        sideUrls.add("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(5) > a > span");
        sideUrls.add("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(6) > a > span");
        sideUrls.add("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(7) > a > span");
        sideUrls.add("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(8) > a");
        indexPage.checkList(sideUrls, texts);

        //7 Open through the header menu Service -> Different Elements Page
        open("https://epam.github.io/JDI/different-elements.html");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(2) > label:nth-child(1) > input[type=\"checkbox\"]");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(2) > label:nth-child(2) > input[type=\"checkbox\"]");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(2) > label:nth-child(3) > input[type=\"checkbox\"]");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(2) > label:nth-child(4) > input[type=\"checkbox\"]");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(3) > label:nth-child(1) > input[type=\"radio\"]");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(3) > label:nth-child(2) > input[type=\"radio\"]");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(3) > label:nth-child(3) > input[type=\"radio\"]");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > div:nth-child(3) > label:nth-child(4) > input[type=\"radio\"]");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > button");
        indexPage.checkVisible("body > div > div.uui-main-container.page-inside > main > div.main-content > div > input");

    }
}
