package homeworks.hw6;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import homeworks.hw6.enums.Logs;
import homeworks.hw6.enums.SuperHeroes;
import homeworks.hw6.enums.UserTableUsers;
import homeworks.hw6.enums.UsersOptions;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

//for commit
public class GherkinUsersPage {

    @FindBy(css = "select")
    private ElementsCollection dropdowns;

    @FindBy(css = "[type='checkbox']")
    private ElementsCollection checkboxes;

    @FindBy(css = "td a")
    private ElementsCollection usernames;

    @FindBy(css = "td img")
    private ElementsCollection images;

    @FindBy(css = ".user-descr")
    private ElementsCollection descriptions;

    @FindBy(css = "tr")
    private ElementsCollection usersTableRows;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;


    @FindBy(css = "select:nth-of-type(1) option")
    private ElementsCollection droplistValues;


    public void selectVip(UserTableUsers user) {
        checkboxes.get(user.number - 1).click();
    }

    public void numberTypeSelect(UserTableUsers user) {
        dropdowns.get(user.number - 1).click();
    }

    public void checkDropdown(int number) {
        dropdowns.shouldHave(size(number));
        for (SelenideElement dropdown : dropdowns) {
            dropdown.shouldBe(visible);
        }
    }

    public void checkUsernames(int number) {
        usernames.shouldHave(size(number));
        for (SelenideElement username : usernames) {
            username.shouldBe(visible);
        }
    }

    public void checkImages(int number) {
        images.shouldHave(size(number));
        for (SelenideElement image : images) {
            image.shouldBe(visible);
        }
    }

    public void checkDescriptions(int number) {
        descriptions.shouldHave(size(number));
        for (SelenideElement text : descriptions) {
            text.shouldBe(visible);
        }
    }

    public void checkboxesCheck(int quantity) {
        checkboxes.shouldHave(size(quantity));
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(visible);
        }
    }

    public void checkSuperHeroes(List<SuperHeroes> heroes) {
        for (SuperHeroes hero : heroes) {
            usersTableRows.findBy(text(String.valueOf(hero.number))).shouldHave(text(hero.user), text(hero.description));
        }
    }

    public void checkLogs(int logSize, boolean condition) {
        logs.filterBy(text(Logs.VIP.toString() + condition)).shouldHave(size(logSize));
    }

    public void checkDroplistValues(List<UsersOptions> options) {
        for (int i = 0; i < options.size(); i++) {
            droplistValues.get(i).shouldHave(text(options.get(i).toString()));
        }
    }


}
