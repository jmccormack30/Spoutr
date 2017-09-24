package main.java;

public class User {

    private String name;
    private String email;
    private String username;
    private String password;
    private String accountType;

    /**
     * This function is the constructor for making a new user
     * @param name String the user's name
     * @param email String the user's email
     * @param username String the user's username
     * @param password String the user's password
     * @param accountType String the user's type of account
     */
    public User(String name, String email, String username, String password, String accountType) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public User() {
        this.name = "";
        this.email = "";
        this.username = "";
        this.password = "";
        this.accountType = "";
    }

    /**
     * This function returns the name of the user
     * @return the user's name
     */
    public String getName() {
        return name;
    }

    /**
     * This function returns the email of the user
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This function sets the email of the user
     * @param email String the user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This function returns the username of the user
     * @return the user's usernname
     */
    public String getUsername() {
        return username;
    }

    /**
     * This function returns the password of the user
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This function sets the password of the user
     * @param password String the user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This function returns the account type of the user
     * @return the user's account type
     */
    public String getAccountType() {
        return accountType;
    }

    public String toString() {
        return name + " - " + email + " - " + username + " - " + password + " - " + accountType;
    }
}