package homeworks.hw3.enums;

public enum UnderIconsText {
    FIRST_ICON_TEXT("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    SECOND_ICON_TEXT("To be flexible and\n" +
            "customizable"),
    THIRD_ICON_TEXT("To be multiplatform"),
    FOURTH_ICON_TEXT("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    private String text;

    UnderIconsText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
