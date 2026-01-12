package citynursinghome.Implementations;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String userId;
    private String userName;
    private String userMobile;
    private String userEmail;
    private String userAddress;
    private String userPassword;

    public User() {}

    public User(String userId, String userName, String userMobile, String userEmail, String userAddress, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userMobile = userMobile;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User : "+ userName + "Mobile : "+ userMobile + "Email : "+ userEmail + "Address : "+ userAddress;
    }

    public abstract void displayRole();
}
