package homeworks.hw6.enums;


public enum UsersOptions {
    ADMIN("Admin"),
    USER("User"),
    MANAGER("Manager");

    private String text;

    UsersOptions(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
