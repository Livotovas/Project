package hw1;


import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstTest extends SeleniumBase{
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public  void afterMethod() {
        //15 Close driver
        driver.close();
    }


    @Test
    public  void simpleTest () {
        //0 Open test site
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //1 Assert Browser Title
        assertEquals(driver.getTitle(), "Home Page");

        //2 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();

        //3 Assert User name in the left-top side of screen that user is loggined
        assertEquals(driver.findElement(By.cssSelector("[id='user-name']")).getText(), "PITER CHAILOVSKII");

        //4 Assert that there are 4 items on the header section are displayed and they have proper texts
        assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(1) > a")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(1) > a")).getText(), "HOME");
        assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(2) > a")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(2) > a")).getText(), "CONTACT FORM");
        assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown > a")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown > a")).getText(), "SERVICE");
        assertTrue(driver.findElement(By.cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4) > a")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li:nth-child(4) > a")).getText() , "METALS & COLORS");

        //5 Assert that there are 4 images on the Index Page and they are displayed
        assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > div > div:nth-child(1) > div > div > span")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > div > div:nth-child(2) > div > div > span")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > div > div:nth-child(3) > div > div > span")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > div > div:nth-child(4) > div > div")).isDisplayed());

        //6 Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> BenefitTxt = new ArrayList<WebElement>(driver.findElements(By.className("benefit-txt")));
        assertEquals(BenefitTxt.size(), 4);
        assertEquals(BenefitTxt.get(0).getText(), "To include good practices\n" +  "and ideas from successful\n" + "EPAM project");
        assertEquals(BenefitTxt.get(1).getText(), "To be flexible and\n" + "customizable");
        assertEquals(BenefitTxt.get(2).getText(), "To be multiplatform");
        assertEquals(BenefitTxt.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        //7 Assert a text of the main headers
        assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > h3.main-title.text-center")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > h3.main-title.text-center")).getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > p")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > p")).getText(), "LOREM IPSUM DOLOR SIT AMET, " + "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +"ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " + "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " + "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //8 Assert that there is the iframe in the center of page
        assertTrue(driver.findElement(By.cssSelector("[id='iframe']")).isDisplayed());

        //9 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("[id='iframe']")));
        assertTrue(driver.findElement(By.cssSelector("[id='epam_logo']")).isDisplayed());

        //10 Switch to original window back
        driver.switchTo().parentFrame();

        //11 Assert a text of the sub header
        assertTrue(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > h3:nth-child(3) > a")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > div.main-content > h3:nth-child(3) > a")).getText(), "JDI GITHUB");

        //12 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(By.cssSelector("body > div > div.uui-main-container > main > " +
                        "div.main-content > h3:nth-child(3) > a")).getAttribute("href"),
                "https://github.com/epam/JDI");

        //13 Assert that there is Left Section
        assertTrue(driver.findElement(By.className("sidebar-menu")).isDisplayed());


        //14 Assert that there is Footer
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());
    }


}
