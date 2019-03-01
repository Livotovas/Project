package homeworks.hw5;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SelenideDataPage {
    @FindBy(css = ".ui-slider-handle span")
    private ElementsCollection sliders;

    @FindBy(css = "main .uui-slider")
    private SelenideElement sliderBase;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    public void moveSlider(int leftPosition, int rightPosition) {
        Actions builder = new Actions(getWebDriver());
        int leftStop = (leftPosition - Integer.valueOf(sliders.get(0).text())) *
                sliderBase.getSize().width / 100 - 1;
        int rightStop = (rightPosition - Integer.valueOf(sliders.get(1).text())) *
                sliderBase.getSize().width / 100 - 1;
        builder.clickAndHold(sliders.get(0)).moveByOffset(leftStop, 0).release().build().perform();
        builder.clickAndHold(sliders.get(1)).moveByOffset(rightStop, 0).release().build().perform();
    }

    public void checkLogs(int start, int finish) {
        logs.get(0).shouldHave(text(String.valueOf(finish)));
        logs.get(1).shouldHave(text(String.valueOf(start)));

    }
}
