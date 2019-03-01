package homeworks.hw4.enums;


public enum Users {
    PETER("epam", "1234", "PITER CHAILOVSKII");

    public final String login;
    public final String password;
    public final String username;

    Users(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }
}
