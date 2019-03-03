package base.jdi.lesson1.entities;
//import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class User {

    public static User PETER = new User("epam", "1234", "PETER CHAVLOVSKY");

    public String login;
    public String password;
    public String username;

    public User(String login, String password, String s1) {
        this.login = login;
        this.password = password;
        this.username = s1;
    }

}
