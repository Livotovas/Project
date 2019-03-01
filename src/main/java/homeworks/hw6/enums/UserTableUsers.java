package homeworks.hw6.enums;


public enum UserTableUsers {
    ROMAN(1, "Roman"),
    SERGEY_IVAN(2, "Sergey Ivan"),
    VLADZIMIR(3, "Vladzimir"),
    HELEN_BENNETT(4, "Helen Bennett"),
    YOSHI_TANNAMURI(5, "Yoshi Tannamuri"),
    GIOVANNI_ROVELLI(6, "Giovanni Rovelli");

    public int number;
    private String name;

    UserTableUsers(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
