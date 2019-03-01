package homeworks.hw4.enums;


public enum Logs {
    ELEMENTS(": condition changed to "),
    METAL("metal: value changed to "),
    COLOR("Colors: value changed to ");

    private String text;

    Logs(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
