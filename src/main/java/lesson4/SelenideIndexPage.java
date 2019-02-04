package lesson4;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelenideIndexPage {
    @FindBy(css = "[id='user-icon']")
    private SelenideElement loginIcon;

    @FindBy (css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown > a")
    private SelenideElement service;

    @FindBy (css = "#mCSB_1_container > ul > li:nth-child(3) > a")
    private SelenideElement sideService;

    @FindBy (css = "body > header > div > nav > ul.uui-navigation.nav.navbar-nav.m-l8 > li.dropdown.open > ul > li:nth-child(7)")
    private  SelenideElement differentElements;

    @FindBy(css = "[id='name']")
    private SelenideElement userField;

    @FindBy(css = "[id='password']")
    private SelenideElement passwordField;

    @FindBy(css = "[id='login-button']")
    private SelenideElement submitButton;

    public void login(String name, String password) {
        loginIcon.click();
        userField.sendKeys(name);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void clickService () {
        service.click();
    }
    public void clickSideService (){
        sideService.click();
    }
    public void clickDifferentElements () {
        differentElements.click();
    }


    public void checkBy (String url, String txt) {
        $(url).shouldHave(text(txt));
    }



    public void checkList (List<String> url, List <String> txt){
        for (int j = 0; j < url.size(); j++){
            $(url.get(j)).shouldHave(text(txt.get(j)));
        }
    }
    public void checkVisible (String url){
        $(url).should(visible);
    }

    public void checkCheckbox (String url) {
        $(url).shouldBe(checked);
    }

}

