package hw2;

import base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasuha on 30.01.2019.
 */
public class SecondTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public  void afterMethod() {
        driver.close();
    }

    //List<WebElement> BenefitTxt = new ArrayList<WebElement>(driver.findElements(By.className("benefit-txt")));


    @DataProvider
    private Object [][] SecondDataProvider (){
        List<WebElement> BenefitTxt = new ArrayList<WebElement>(driver.findElements(By.className("benefit-txt")));
        return new Object[][] {
                {BenefitTxt.get(0).getText(), "To include good practices\n" +  "and ideas from successful\n" + "EPAM project"},
                {BenefitTxt.get(1).getText(), "To be flexible and\n" + "customizable"},
                {BenefitTxt.get(2).getText(), "To be multiplatform"},
                {BenefitTxt.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }
    @Test(dataProvider = "SecondDataProvider")
    public void SecondTestWithDataProvider (String s1, String s2) {
        //asserting 4 texts below 4 pictures on the Index Page
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        Assert.assertEquals(s1, s2);
    }
}
