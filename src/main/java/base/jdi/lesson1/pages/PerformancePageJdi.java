package base.jdi.lesson1.pages;

import base.jdi.lesson1.UserRow;
import base.jdi.lesson1.entities.UserInfo;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JTable;

public class PerformancePageJdi {
    @JTable(
            root = "#users-table",
            row = "//tr[%s]/td",
            column = "//tr/td[%s]",
            cell = "//tr[{1}]/td[{0}]",
            allCells = "td",
            headers = "th",
            header = {"Name", "Phone", "Email", "City"},
            rowHeader = "Name",
            size = 4
    )
    public static DataTable<UserRow, UserInfo> usersSetup;
}
