
public class User extends Person implements Authonticate {
    private int userID;
    private String userName;
    private String userPassword;

    public User() {
    }

    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public User(String name, int age, int userID, String userName, String userPassword) {
        super(name, age);
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    int getUserID() {
        return userID;
    }

    void setUserID(int userID) {
        this.userID = userID;
    }


    String getUserName() {
        return userName;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    @Override
    public boolean LogIn(String username, String Password) {
        return this.userName.equals(username) && this.userPassword.equals(Password);
    }
}
  