package homeworks.hw6.steps;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import homeworks.hw6.GherkinDifferentElementsPage;
import homeworks.hw6.GherkinIndexPage;
import homeworks.hw6.GherkinUsersPage;
import homeworks.hw6.enums.*;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class AssertionSteps {
    private GherkinIndexPage indexPage = page(GherkinIndexPage.class);
    private GherkinDifferentElementsPage differentElementsPage = page(GherkinDifferentElementsPage.class);
    private GherkinUsersPage usersTablePage = page(GherkinUsersPage.class);

    @Then("^Browser title should be '([^\"]*)'$")
    public void checkBrowserTitle(MainPageData title) {
        indexPage.checkTitle(title.toString());
    }

    @And("^Home Page contains required elements$")
    public void checkMainPage() {
        indexPage.checkMainPage();
    }

    @Then("^User name should be '([^\"]*)'$")
    public void checkUserName(Users user) {
        indexPage.checkLogin(user);
    }

    @Then("^Header dropdown contains options:$")
    public void checkHeaderDropdownOptions(Texts[] elements) {
        indexPage.checkHeaderDropdown(elements);
    }

    @Then("^Left dropdown contains options:$")
    public void checkLeftDropdownOptions(Texts[] elements) {
        indexPage.checkLeftDropdown(elements);
    }

    @Then("^Different Elements Page contains requared elements$")
    public void differentElementsPageContainsAllNeededElements() {
        differentElementsPage.mainElementsCheck();
    }

    @And("^Right section exists$")
    public void checkRightSectionExistance() {
        differentElementsPage.checkRightSection();
    }

    @And("^Left section exists$")
    public void thereIsLeftSection() {
        differentElementsPage.checkLeftSection();
    }

    @Then("^They are marked as '([^\"]*)' on logs:$")
    public void checkElementsAreMarkedAsTrue(String condition, DifferentElements elements) {
        differentElementsPage.checkCheckboxLogs("true", elements);
    }

    @Then("^Log is correct for '([^\"]*)'$")
    public void logIsCorrectForMetal(DifferentElements metal) {
        differentElementsPage.checkRadioLogs(metal);
    }

    @Then("^Log is correct for '([^\"]*)'$")
    public void logIsCorrectForColor(DifferentElements color) {
       differentElementsPage.checkDropdownLogs(color);
    }

    @And("^(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page$")
    public void checkDropdownAreDisplayed(int quantity) {
        usersTablePage.checkDropdown(quantity);
    }

    @And("^(\\d+) User names are displayed on Users Table on User Table Page$")
    public void checkUsernamesAreDisplayed(int number) {
        usersTablePage.checkUsernames(number);
    }

    @And("^(\\d+) Description images are displayed on Users Table on User Table Page$")
    public void checkDescriptionsAreDisplayed(int number) {
        usersTablePage.checkImages(number);
    }

    @And("^(\\d+) Description texts under images are displayed on Users Table on User Table Page$")
    public void checkImagesAreDisplayed(int number) {
        usersTablePage.checkDescriptions(number);
    }

    @And("^(\\d+) checkboxes are displayed on Users Table on User Table Page$")
    public void checkboxesAreDisplayed(int quantity) {
        usersTablePage.checkboxesCheck(quantity);
    }

    @And("^User table contains following values:$")
    public void userTableContainsValues(List<SuperHeroes> heroes) {
        usersTablePage.checkSuperHeroes(heroes);
    }

    @Then("^(\\d+) log row has \"Vip: condition changed to\" \'([^\"]*)\' text in log section$")
    public void logHasText(int logSize, boolean condition) {
        usersTablePage.checkLogs(logSize, condition);
    }

    @Then("^droplist contains values$")
    public void droplistContainsValues(List<UsersOptions> options) {
        usersTablePage.checkDroplistValues(options);
    }

}
