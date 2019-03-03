package homeworks.hw3.enums;

public enum HeaderItemsText {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_COLORS("Metals&Colors");

    private String text;

    HeaderItemsText(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        return this.text;
    }

}
