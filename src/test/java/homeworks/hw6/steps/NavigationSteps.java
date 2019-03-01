package homeworks.hw6.steps;
import static com.codeborne.selenide.Selenide.open;

import cucumber.api.java.en.Given;
import homeworks.hw6.enums.MainPageData;

public class NavigationSteps {
    @Given("^I am on HOME PAGE$")
    public void openSite() {
        open(MainPageData.URL.toString());
    }
}
