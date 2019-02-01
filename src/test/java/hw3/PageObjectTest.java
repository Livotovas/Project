package hw3;

import base.SeleniumBase;
import lesson3.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by vasuha on 31.01.2019.
 */
public class PageObjectTest {
    private WebDriver driver;
    private IndexPage indexPage ;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @BeforeMethod
    public void initTest(){
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MINUTES);
    }

    @AfterMethod
    public void closeTest(){
        driver.close();
    }


    @Test
    public  void simpleTest () {
        //0 Open test site
        indexPage.open();

        //1 Assert Browser Title
        indexPage.checkDriver();

        //2 Perform login
        indexPage.login("epam", "1234");


        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkItems("[id='user-name']", "PITER CHAILOVSKII");



        //4 Assert that there are 4 items on the header section are displayed and they have proper texts
        indexPage.checkItems("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(1) > a", "HOME");
        indexPage.checkItems("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(2) > a","CONTACT FORM");
        indexPage.checkItems("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown > a", "SERVICE");
        indexPage.checkItems("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4) > a", "METALS & COLORS");


        //5 Assert that there are 4 images on the Index Page and they are displayed
        List <String> itemsCss = new ArrayList<String>();

        itemsCss.add(0, "body > div > div.uui-main-container > main > div.main-content > div > div:nth-child(1) > div > div > span");
        itemsCss.add(1, "body > div > div.uui-main-container > main > div.main-content > div > div:nth-child(2) > div > div > span");
        itemsCss.add(2, "body > div > div.uui-main-container > main > div.main-content > div > div:nth-child(3) > div > div > span");
        itemsCss.add(3, "body > div > div.uui-main-container > main > div.main-content > div > div:nth-child(4) > div > div");
        indexPage.checkDisplayed(itemsCss);

        //6 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> BenefitTxt = new ArrayList<WebElement>(driver.findElements(By.className("benefit-txt")));
        assertEquals(BenefitTxt.size(), 4);
        List <String> textToCheck = new ArrayList<String>();
        textToCheck.add("To include good practices\n" +  "and ideas from successful\n" + "EPAM project");
        textToCheck.add("To be flexible and\n" + "customizable");
        textToCheck.add("To be multiplatform");
        textToCheck.add("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
        indexPage.checkText(BenefitTxt, textToCheck);


        //7 Assert a text of the main headers
        indexPage.checkItems("body > div > div.uui-main-container > main > div.main-content > h3.main-title.text-center", "EPAM FRAMEWORK WISHES…");
        indexPage.checkItems("body > div > div.uui-main-container > main > div.main-content > p", "LOREM IPSUM DOLOR SIT AMET, " + "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +"ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " + "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " + "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //8 Assert that there is the iframe in the center of page
        indexPage.checkInvividualByCss("[id='iframe']");

        //9 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        indexPage.switchPage("[id='iframe']");
        indexPage.checkInvividualByCss("[id='epam_logo']");

        //10 Switch to original window back
        indexPage.backToParent();

        //11 Assert a text of the sub header
        indexPage.checkItems("body > div > div.uui-main-container > main > div.main-content > h3:nth-child(3) > a", "JDI GITHUB");

        //12 Assert that JDI GITHUB is a link and has a proper URL
        indexPage.checkURL("body > div > div.uui-main-container > main > " +
                "div.main-content > h3:nth-child(3) > a", "https://github.com/epam/JDI");

        //13 Assert that there is Left Section
        indexPage.checkInvividualByClass("sidebar-menu");

        //14 Assert that there is Footer
        indexPage.checkInvividualByClass("footer-bg");
    }

}
