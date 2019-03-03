package homeworks.hw6;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homeworks.hw6.enums.DifferentElements;
import homeworks.hw6.enums.Logs;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertTrue;

//for commit
public class GherkinDifferentElementsPage {

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

    public void mainElementsCheck() {
        checkboxes.shouldHave(size(4));
        radios.shouldHave(size(4));
        dropdown.shouldBe(visible);
        buttons.shouldHave(size(2));
    }

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void selectElements(DifferentElements... elements) {
        for (DifferentElements element : elements) {
            checkboxes.find(text(element.toString())).click();
        }
    }

    public void checkCheckboxLogs(String condition, homeworks.hw6.enums.DifferentElements... elements) {
        for (int i = 0; i < elements.length; i++) {
            logs.get(elements.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(elements.length - 1 - i).getText()
                    .contains(elements[i].toString() + Logs.ELEMENTS + condition));
        }
    }


    public void selectMetal(homeworks.hw6.enums.DifferentElements... elements) {
        for (homeworks.hw6.enums.DifferentElements element : elements) {
            radios.find(text(element.toString())).click();
        }
    }


    public void checkRadioLogs(homeworks.hw6.enums.DifferentElements... elements) {
        for (int i = 0; i < elements.length; i++) {
            logs.get(elements.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(elements.length - 1 - i).getText()
                    .contains(Logs.METAL + elements[i].toString()));
        }
    }

    public void selectColor(homeworks.hw6.enums.DifferentElements... element) {
        dropdown.click();
        dropdown.selectOption(element.toString());
    }


    public void checkDropdownLogs(homeworks.hw6.enums.DifferentElements... elements) {
        for (int i = 0; i < elements.length; i++) {
            logs.get(elements.length - 1 - i).shouldBe(visible);
            assertTrue(logs.get(elements.length - 1 - i).getText()
                    .contains(Logs.COLOR + elements[i].toString()));
        }
    }

}
