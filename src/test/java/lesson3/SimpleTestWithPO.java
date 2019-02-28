package lesson3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class SimpleTestWithPO {
    private WebDriver driver;
    private IndexPage indexPage ;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @BeforeMethod
    public void initTest(){
        // driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MINUTES);
    }

    @AfterMethod
    public void closeTest(){
        driver.close();
    }

    @Test
    public void SimpleTest(){
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        indexPage.login("epam", "1234");
    }
}
