package homeworks.hw3;

import base.SeleniumBase;
import lesson3.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static lesson3.IndexPage.*;
import static org.testng.Assert.assertEquals;

public class PageObjectTest extends SeleniumBase{
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
       indexPage.checkHeaderSection(HeaderItemsText.values());

        //5 Assert that there are 4 images on the Index Page and they are displayed
        indexPage.checkImagesDisplay();

        //6 Assert that there are 4 texts on the Index Page under icons and they have proper text
       indexPage.checkUnderIconText(UnderIconsText.values());

        //7 Assert a text of the main headers
       indexPage.checkFirstMainHeader();
       indexPage.checkSecondMainHeader();

        //8 Assert that there is the iframe in the center of page
        indexPage.checkIframe();

        //9 Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        indexPage.switchPage("[id='iframe']");
        indexPage.checkEpamLogo();

        //10 Switch to original window back
        indexPage.backToParent();

        //11 Assert a text of the sub header
        indexPage.checkSubHeader();

        //12 Assert that JDI GITHUB is a link and has a proper URL
        indexPage.checkURL("body > div > div.uui-main-container > main > " +
                "div.main-content > h3:nth-child(3) > a", "https://github.com/epam/JDI");

        //13 Assert that there is Left Section
        indexPage.checkLeftSection();

        //14 Assert that there is Footer
        indexPage.checkFooter();
    }
}
