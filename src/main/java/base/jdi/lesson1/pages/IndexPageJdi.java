package base.jdi.lesson1.pages;

import base.jdi.lesson1.LoginForm;
import base.jdi.lesson1.entities.User;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.complex.Checklist;
import com.epam.jdi.light.ui.html.complex.Menu;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import org.openqa.selenium.support.FindBy;
import com.epam.jdi.light.ui.html.common.Icon;


public class IndexPageJdi extends WebPage {

    LoginForm loginForm;

    @FindBy(xpath = "//ul[@class='sidebar-menu'] //span[text()='%s']")
    public Menu menu;

    @FindBy(css = "[id='user-icon']")
    private Icon loginIcon;

    @UI("[name=checks-group]")
    public static Checklist weather;

    @UI("[name=colors]")
    public static RadioButtons colors;

    @FindBy(css = "p input[type='checkbox']")
    public Checklist checklist = new HtmlChecklist() {
        @Override
        public void check(String... names) {
            super.check(names);
        }
    };

    @JTable
    Table userTable;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }
}
