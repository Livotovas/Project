package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by vasuha on 28.01.2019.
 */
public class IndexPage {
    @FindBy(css = ".profile-photo")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;


    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }
    private WebDriver driver;

    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkItems (String u, String item) {
        assertTrue(driver.findElement(By.cssSelector(u)).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(u)).getText(), item);
    }

    public void open() {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void checkDisplayed (List<String> s) {
        for (int j = 0; j < s.size(); j++) {
            assertTrue(driver.findElement(By.cssSelector(s.get(j))).isDisplayed());
        }
    }

    public void checkText (List<WebElement> s1, List <String> s2)   {
            for (int j = 0; j<s1.size(); j++) {
                assertEquals(s1.get(j).getText(), s2.get(j));
            }
    }

    public void checkInvividualByClass (String s1){
        assertTrue(driver.findElement(By.className(s1)).isDisplayed());
    }

    public  void  checkDriver () {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkInvividualByCss (String s1){
        assertTrue(driver.findElement(By.cssSelector(s1)).isDisplayed());
    }

    public void switchPage (String s) {
        driver.switchTo().frame(driver.findElement(By.cssSelector(s)));
    }

    public void backToParent () {
        driver.switchTo().parentFrame();
    }

    public void checkURL (String s1, String s2) {
        assertEquals(driver.findElement(By.cssSelector(s1)).getAttribute("href"),
                s2);
    }


}




