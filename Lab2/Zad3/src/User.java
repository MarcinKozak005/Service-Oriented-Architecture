public class User
{
    private String login;
    private String password;
    private String name;
    private String surname;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name, String surname){
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        User left =  (User) obj;
        if (left.login.equals(this.login) && left.password.equals(this.password))
            return true;
        else
            return false;
    }
}
