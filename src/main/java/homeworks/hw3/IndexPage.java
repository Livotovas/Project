package homeworks.hw3;

import homeworks.hw3.enums.HeaderItemsText;
import homeworks.hw3.enums.MainHeaders;
import homeworks.hw3.enums.UnderIconsText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static homeworks.hw3.enums.MainHeaders.*;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {
    @FindBy(css = ".profile-photo")
    private WebElement loginIcon;

    @FindBy(css = "[id='name']")
    private WebElement userField;

    @FindBy(css = "[id='password']")
    private WebElement passwordField;

    @FindBy(css = "[id='login-button']")
    private WebElement submitButton;

    @FindBy(css = ".m-l8")
    private WebElement header;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> icons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> underIconTexts;

    @FindBy(css = ".main-title.text-center")
    private WebElement firstMainHeader;

    @FindBy(css = ".main-txt.text-center")
    private WebElement secondMainHeader;

    @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css = ".text-center a")
    private WebElement subHeader;

    @FindBy(css = ".sidebar-menu")
    private WebElement leftSection;

    @FindBy(css = ".footer-bg")
    private WebElement footer;


    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }
    private WebDriver driver;

    public void checkItems (String u, String item) {
        assertTrue(driver.findElement(By.cssSelector(u)).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector(u)).getText(), item);
    }

    public void open() {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public  void  checkDriver () {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkHeaderSection(HeaderItemsText[] texts){
        assertTrue(header.isDisplayed());
        for (HeaderItemsText text : texts){
            assertTrue(header.getText().contains(texts.toString()));
        }
    }

    public void checkImagesDisplay() {
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }
    }

    public void checkUnderIconText (UnderIconsText[] items) {
        int i = 0;
        for (WebElement text : underIconTexts) {
            assertTrue(text.isDisplayed());
            assertEquals(text.getText(), items[i++].toString());
        }
    }

    public void checkFirstMainHeader(){
        assertEquals(firstMainHeader.getText(), FIRST_MAIN_HEADER.toString());
    }

    public void checkSecondMainHeader(){
        assertEquals(secondMainHeader.getText(), SECOND_MAIN_HEADER.toString());
    }

    public void checkIframe(){
        assertTrue(iframe.isDisplayed());
    }

    public void switchPage (){
    driver.switchTo().frame(iframe);
    }

    public void checkEpamLogo (){}

    public void backToParent () {
        driver.switchTo().parentFrame();
    }

    public void checkSubHeader () {
        assertTrue(subHeader.isDisplayed());
    }

    public void checkURL (){
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkLeftSection(){
     assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter(){
        assertTrue(footer.isDisplayed());
    }



}
