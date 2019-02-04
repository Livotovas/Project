package hw2.Exercise1;

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

public class TestWithDataProvider {
 private static final String URL = "https://epam.github.io/JDI/index.html";

    private WebDriver driver;

 @BeforeMethod
    public void beforeMethod () {
     driver = new ChromeDriver();
     driver.manage().window().maximize();
 }

 @AfterMethod
 public void afterMethod () {
     driver.close();
 }

    @DataProvider
    private Object[][] SimpleDataProvider() {
        return new Object[][]{
                {0, "To include good practices\n" + "and ideas from successful\n" + "EPAM project"},
                {1, "To be flexible and\n" + "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…"}
        };
    }

    @Test(dataProvider = "SimpleDataProvider")
    public void SimpleTest (int num, String txt){
     driver.navigate().to(URL);
     List<WebElement> benefitTexts = new ArrayList<WebElement>(driver.findElements(By.className("benefit-txt")));
        Assert.assertEquals(benefitTexts.get(num).getText(), txt);
    }



}
