package homeworks.hw6.steps;


import cucumber.api.java.en.When;
import homeworks.hw6.GherkinDifferentElementsPage;
import homeworks.hw6.GherkinIndexPage;
import homeworks.hw6.GherkinUsersPage;
import homeworks.hw6.enums.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static homeworks.hw6.enums.DifferentElements.*;

public class ActionSteps {
    private GherkinIndexPage indexPage = page(GherkinIndexPage.class);
    private GherkinDifferentElementsPage differentElementsPage = page(GherkinDifferentElementsPage.class);
    private GherkinUsersPage userTablePage = page(GherkinUsersPage.class);

    @When("^I login as user '([^\"]*)'$")
    public void loginAsUser(Users user) {
        indexPage.login(user);
    }

    @When("^I click on \'([^\"]*)\' category in the header$")
    public void clickOnSubcategoryInTheHeader(HeaderItems headerItem) {
        indexPage.headerNavigation(headerItem);
    }

    @When("^I click on \"([^\"]*)\" category in the left section$")
    public void clickOnSubcategoryInTheLeftSection(HeaderItems headerItem) {
        indexPage.leftNavigation(headerItem);
    }

    @When("^I click on '([^\"]*)' in the header \"Service\" menu$")
    public void openService(Texts item) {
        indexPage.openServicePage(item);
    }

    @When("^I select elements:$")
    public void selectElements(DifferentElements elements) {
        differentElementsPage.selectElements(WATER, WIND);
    }

    @When("^I select '([^\"]*)'$")
    public void selectMetal(DifferentElements metal) {
        differentElementsPage.selectMetal(SELEN);
    }

    @When("^I select color '([^\"]*)'$")
    public void selectColor(DifferentElements color) {
        differentElementsPage.selectColor(color);
    }

    @When("^I select 'vip' checkbox for \'([^\"]*)\'$")
    public void selectCheckboxFor(UserTableUsers user) {
        userTablePage.selectVip(user);
    }

    @When("^I click on dropdown in column \"NumberType\" for user \'([^\"]*)\'$")
    public void clickOnDropdown(UserTableUsers user) {
        userTablePage.numberTypeSelect(user);
    }
}
