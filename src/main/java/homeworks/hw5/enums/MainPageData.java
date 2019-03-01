package homeworks.hw5.enums;


public enum MainPageData {
    URL("https://epam.github.io/JDI/"),
    PAGE_TITLE("Home Page");

    private String text;

    MainPageData(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
