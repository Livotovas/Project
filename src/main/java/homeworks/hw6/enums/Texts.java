package homeworks.hw6.enums;


public enum Texts {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGE("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    private String text;

    Texts(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
