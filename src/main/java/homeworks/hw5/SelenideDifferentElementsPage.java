package homeworks.hw5;

import homeworks.hw5.enums.DifferentElements;
import homeworks.hw5.enums.Logs;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

public class SelenideDifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".main-content .uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".main-content .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "[name='log-sidebar']")
    private SelenideElement rightSection;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".logs > li")
    private ElementsCollection logs;


    @Step("Check Main Elements")
    public void mainElementsCheck(){
        checkboxes.shouldHave(size(4));
        radios.shouldHave(size(4));
        dropdown.shouldBe(visible);
        buttons.shouldHave(size(2));
    }

    @Step("Check Right Section")
    public void checkRightSection(){
        rightSection.shouldBe(visible);
    }

    @Step("Check Left Section")
    public void checkLeftSection(){
        leftSection.shouldBe(visible);
    }

    @Step("Select elements")
    public void selectElements(DifferentElements... elements) {
        for (DifferentElements element : elements) {
            checkboxes.find(text(element.toString())).click();
        }
    }

    @Step("Check if checkbox logs are correct")
    public void checkCheckboxLogs(String condition, DifferentElements... elements) {
        for (int i = 0; i < elements.length; i++) {
            logs.get(elements.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(elements.length - 1 - i).getText()
                    .contains(elements[i].toString() + Logs.ELEMENTS + condition));
        }
    }

    @Step("Select radio")
    public void selectMetal(DifferentElements... elements) {
        for (DifferentElements element : elements) {
            radios.find(text(element.toString())).click();
        }
    }

    @Step("Check if radio logs are correct")
    public void checkRadioLogs(DifferentElements... elements) {
        for (int i = 0; i < elements.length; i++) {
            logs.get(elements.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(elements.length - 1 - i).getText()
                    .contains(Logs.METAL + elements[i].toString()));
        }
    }

    @Step("Select color")
    public void selectColor(DifferentElements... element) {
        dropdown.click();
        dropdown.selectOption(element.toString());
    }

    @Step("Check if dropdown logs are correct")
    public void checkDropdownLogs(DifferentElements... elements) {
        for (int i = 0; i < elements.length; i++) {
            logs.get(elements.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(elements.length - 1 - i).getText()
                    .contains(Logs.COLOR + elements[i].toString()));
        }
    }





}
