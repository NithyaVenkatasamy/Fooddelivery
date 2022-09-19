package Models;

public class User {
    private String username;
    private String password;
    private int id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String phonenumber;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {

    }

    public User(int id) {
    }

    public User(int id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;

        this.firstName = firstName;
        this.lastName = lastName;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}