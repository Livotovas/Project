package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    private WebElement headerItems;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> iconTexts;

    @FindBy(css = ".main-title.text-center")
    private WebElement firstMainHeader;

    @FindBy(css = ".main-txt.text-center")
    private WebElement secondMainHeader;

    @FindBy(css = "[id='iframe']")
    private WebElement iframe;

    @FindBy(css ="[id='epam_logo']")
    private WebElement epamLogo;

    @FindBy(css = ".text-center a")
    private WebElement subHeader;

    @FindBy(css = ".sidebar-menu")
    private WebElement leftSection;

    @FindBy(css = ".footer-bg")
    private WebElement footer;



    public enum HeaderItemsText {
        HOME("HOME"),
        CONTACT_FORM("CONTACT FORM"),
        SERVICE("SERVICE"),
        METALS_AND_COLORS("METALS & COLORS");

        private String text;

        HeaderItemsText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public enum UnderIconsText {
        FIRST_TEXT("To include good practices\n" +  "and ideas from successful\n" + "EPAM project"),
        SECOND_TEXT("To be flexible and\n" + "customizable"),
        THIRD_TEXT("To be multiplatform"),
        FOURTH_TEXT("Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");

        private String text;

        UnderIconsText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }


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

    public void checkHeaderSection (HeaderItemsText[] items){
        for (HeaderItemsText item : items) {
            assertTrue(headerItems.getText().contains(item.toString()));
        }
    }

    public void checkImagesDisplay () {
        for (WebElement image : images) {
        assertTrue(image.isDisplayed()); }
    }

    public void checkUnderIconText (UnderIconsText[] texts){
        for (int j =0; j<texts.length; j++ ){
            assertEquals(iconTexts.get(j).getText() , texts[j].toString());
        }
    }

    public void checkFirstMainHeader (){
        assertTrue(firstMainHeader.isDisplayed());
        assertEquals(firstMainHeader.getText(), "EPAM FRAMEWORK WISHES…");
    }

    public void checkSecondMainHeader ()  {
        assertTrue(secondMainHeader.isDisplayed());
        assertEquals(secondMainHeader.getText(), "LOREM IPSUM DOLOR SIT AMET, " + "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA " +"ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP " + "EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE " + "CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    public void checkIframe () {
        assertTrue(iframe.isDisplayed());
    }

    public void checkEpamLogo() {
        assertTrue(epamLogo.isDisplayed());
    }

    public void checkSubHeader (){
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    public void checkLeftSection (){
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter () {
        assertTrue(footer.isDisplayed());
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
