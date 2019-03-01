package homeworks.hw6.enums;


public enum DifferentElements {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    private String text;

    DifferentElements(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
